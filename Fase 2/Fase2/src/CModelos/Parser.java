package CModelos;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Parser {

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

    public Queue<Object> getTokenQueue(String[] tokens) {
        Queue<Object> tokenQueue = new LinkedList<Object>();
        for (String token : tokens) {
            tokenQueue.add(token);
        }
        return tokenQueue;
    }

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
                    return null;
                case "COND":
                    return null;
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
                // case "=":
                //     try {
                //         Object operandA = evaluateExpression(tokenQueue.poll());
                //         Object operandB = tokenQueue.poll().toString();
                //         if (!tokenQueue.isEmpty())
                //             throw new ArithmeticException("Too many operands for operation '<='");
                //         return operandA.equals(operandB);
                //     } catch (Exception e) {
                //         throw e;
                //     }
                default:
                    throw new ArithmeticException("Undefined parameter '" + token.toString() + "'");
            }
        } else {
            throw new Exception("Invalid element");
        }
    }

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

    public Object parseLispExpression(String expression) throws Exception {
        String[] tokenizedExpression = tokenizeLispExpression(expression);
        try {
            return evaluateExpression(getTokenQueue(tokenizedExpression));
        } catch (Exception e) {
            throw e;
        } 
    }

}