package CModelos;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.HashMap;

public class Parser {
    HashMap<String, Object> variables = new HashMap<String, Object>();

    
    /** 
     * @param expression
     * @return String[]
     */
    public String[] tokenizeLispExpression(String expression) {
        // Agregar separadores a parentesis
        expression = expression.replace("(", " ( ").replace(")", " ) ");
        // Separar QUOTE del resto de elementos
        expression = expression.replace("'", " ' ");
        // quitar espacios dobles
        expression = expression.replaceAll("\\s+", " ");
        // Devolver expresion sin espacios al inicio y al final, separada por espacios
        return expression.trim().split("\\s");
    }

    
    /** 
     * @param tokenQueue
     * @return Object
     * @throws EOFException
     */
    public Object readTokenQueue(Queue<Object> tokenQueue) throws EOFException{
        Object token = tokenQueue.poll();
        if (tokenQueue.isEmpty()) throw new EOFException("Expression is empty");
        if (token.equals("(")) {
            Queue<Object> newQueue = new LinkedList<Object>();
            while (!tokenQueue.peek().toString().equals(")")) {
                // Object newElement = readTokenQueue(tokenQueue);
                newQueue.offer(readTokenQueue(tokenQueue));
            }
            tokenQueue.poll();
            return newQueue;
        } else if (token.equals(")")) {
            throw new EOFException("Unexpected ')' found");
        } else {
            return atom(token);
        }
    }

    
    /** 
     * @param tokens
     * @return Queue<Object>
     */
    public Queue<Object> getTokenQueue(String[] tokens) {
        Queue<Object> tokenQueue = new LinkedList<Object>();
        for (String token : tokens) {
            tokenQueue.add(token);
        }
        return tokenQueue;
    }

    
    /** 
     * @param tokenQueue
     * @return Object
     * @throws Exception
     */
    public Object evaluateExpression(Queue<Object> tokenQueue) throws Exception {
        Object token = tokenQueue.poll();
        if (token instanceof Number) {
            return token;
        } else if (token instanceof LinkedList) {
            return evaluateExpression((Queue<Object>) token);
        } else if (token instanceof String) {
            switch (token.toString().toUpperCase()) {
                case "+":
                    return tokenQueueToIntegerList(tokenQueue).stream().reduce(0, Integer::sum);
                case "-":
                    List<Integer> tokenList = tokenQueueToIntegerList(tokenQueue);
                    return tokenList.stream().reduce((a, b) -> a - b).get();
                case "*":
                    return tokenQueueToIntegerList(tokenQueue).stream().reduce(1, (a, b) -> a * b);
                case "/":
                    try {
                        Integer operandA = Integer.parseInt(tokenQueue.poll().toString());
                        Integer operandB = Integer.parseInt(tokenQueue.poll().toString());
                        if (!tokenQueue.isEmpty())
                            throw new ArithmeticException("Too many operands for operation '/'");
                        return operandA / operandB;
                    } catch (Exception e) {
                        throw e;
                    }
                case "'":
                    return tokenQueue.poll().toString();
                case "QUOTE":
                    return tokenQueue.poll().toString();
                case "DEFUN":
                    return null;
                case "SETQ":
                    //asignar valores a variables (setq variable valor)
                    try {
                        String variable= tokenQueue.poll().toString();
                        Object value = evaluateExpression(tokenQueue);
                        variables.put(variable, value);
                        System.out.println("variable "+variable);
                        return value;
                    } catch (Exception e) {
                        throw e;
                    }
                case "COND":
                    try {
                        //no me funciona aún
                        /*while (!tokenQueue.isEmpty()){
                            Object condicion = evaluateExpression(tokenQueue);
                            if (!(condicion instanceof Boolean)) {
                                throw new Exception("COND no válido");
                            }
                            if ((Boolean) condicion) {
                                return evaluateExpression(tokenQueue);
                            }else {// si la condicion no se cumple, entonces se va a omitir el resultado
                                tokenQueue.poll();
                            }
                            
                        }
                        throw new Exception("no hay una condicion en COND que se cumpla ");*/
                        return null;
                    } catch (Exception e) {
                        throw e;
                    }
                case "LIST":
                    try {
                        List<Object> list = new ArrayList<>();
                        while (!tokenQueue.isEmpty()){
                            list.add(evaluateExpression(tokenQueue));
                        }
                        return list;
                    } catch (Exception e) {
                        throw e;
                    }
                case "EQUAL":
                    try {
                        String operandA = tokenQueue.poll().toString();
                        String operandB = tokenQueue.poll().toString();
                        if (!tokenQueue.isEmpty())
                            throw new ArithmeticException("Too many operands for operation 'EQUAL'");
                        return operandA.equals(operandB);
                    } catch (Exception e) {
                        throw e;
                    }
                case ">":
                    try {
                        Integer operandA = Integer.parseInt(tokenQueue.poll().toString());
                        Integer operandB = Integer.parseInt(tokenQueue.poll().toString());
                        if (!tokenQueue.isEmpty())
                            throw new ArithmeticException("Too many operands for operation '>'");
                        return operandA > operandB;
                    } catch (Exception e) {
                        throw e;
                    }
                case ">=":
                    try {
                        Integer operandA = Integer.parseInt(tokenQueue.poll().toString());
                        Integer operandB = Integer.parseInt(tokenQueue.poll().toString());
                        if (!tokenQueue.isEmpty())
                            throw new ArithmeticException("Too many operands for operation '>='");
                        return operandA >= operandB;
                    } catch (Exception e) {
                        throw e;
                    }
                case "<":
                    try {
                        Integer operandA = Integer.parseInt(tokenQueue.poll().toString());
                        Integer operandB = Integer.parseInt(tokenQueue.poll().toString());
                        if (!tokenQueue.isEmpty())
                            throw new ArithmeticException("Too many operands for operation '<='");
                        return operandA < operandB;
                    } catch (Exception e) {
                        throw e;
                    }
                case "<=":
                    try {
                        Integer operandA = Integer.parseInt(tokenQueue.poll().toString());
                        Integer operandB = Integer.parseInt(tokenQueue.poll().toString());
                        if (!tokenQueue.isEmpty())
                            throw new ArithmeticException("Too many operands for operation '<='");
                        return operandA <= operandB;
                    } catch (Exception e) {
                        throw e;
                    }
                case "=":
                    try {
                        Queue<Object> queueA =  new LinkedList<Object>();
                        queueA.offer(tokenQueue.poll());
                        Object operandA = evaluateExpression(queueA);
                        Queue<Object> queueB =  new LinkedList<Object>();
                        queueB.offer(tokenQueue.poll());
                        Object operandB = evaluateExpression(queueB);
                        if (!tokenQueue.isEmpty())
                            throw new ArithmeticException("Too many operands for operation '<='");
                        return operandA.equals(operandB);
                    } catch (Exception e) {
                        throw e;
                    }
                default:
                    throw new ArithmeticException("Undefined parameter '" + token.toString() + "'");
            }
        } else {
            throw new Exception("Invalid element");
        }
    }

    
    /** 
     * @param element
     * @return Object
     */
    public Object atom(Object element) {
        try {
            return Integer.parseInt(element.toString());
        } catch (Exception e1) {
            try {
                return Double.parseDouble(element.toString());
            } catch (Exception e2) {
                return element.toString();
            }
        }
    }

    
    /** 
     * @param tokenQueue
     * @return List<Integer>
     * @throws Exception
     */
    public List<Integer> tokenQueueToIntegerList(Queue<Object> tokenQueue) throws Exception {
        List<Integer> tokenList = new ArrayList<Integer>();
        for (Object token : tokenQueue) {
            Queue<Object> newQueue = new LinkedList<Object>();
            newQueue.offer(token);
            try {
                tokenList.add((Integer) evaluateExpression(newQueue));
            } catch (Exception e) {
                throw e;
            }
        }
        return tokenList;
    }

    
    /** 
     * @param expression
     * @return Object
     * @throws Exception
     */
    public Object parseLispExpression(String expression) throws Exception {
        String[] tokenizedExpression = tokenizeLispExpression(expression);
        try {
            return evaluateExpression(getTokenQueue(tokenizedExpression));
        } catch (Exception e) {
            throw e;
        } 
    }




}