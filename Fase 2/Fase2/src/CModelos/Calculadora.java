package CModelos;

import java.util.Stack;

import CVista.Vista;

public class Calculadora {
    Vista vista;
    StackArrayList stack;
    public Calculadora(){
        vista = new Vista();
        stack = new StackArrayList<>();
    }

    public String Calcular(String Expresion){
        String resultado = "";
        String[] expresion = Expresion.split(" ");
        int numero1 = 0;
        int numero2 = 0;
        int operador = 0;

        for (String caracter : expresion ){
            double isnum=0;
            boolean numero= false;

            try {
                if (caracter.equals(" ")){
                    continue;
                }
                isnum= Double.parseDouble(caracter);
                numero= true;

                
            } catch (Exception e) {
                // TODO: handle exception
                numero= false;

            }

            if (numero== true){
                stack.push(isnum);
            }else{
                Object n1= stack.pop();
                Object n2= stack.pop();
                switch(caracter){
                    case "*":
                        numero1 = (int)n2 * (int)n1;
                        stack.push(numero1);
                        break;
                    case "/":
                        numero1 = (int)n2 / (int)n1;
                        stack.push(numero1);
                        break;
                    case "+":
                        numero1 = (int)n2 + (int)n1;
                        stack.push(numero1);
                        break;
                    case "-":
                        numero1 = (int)n2 - (int)n1;
                        stack.push(numero1);
                        break;
                    }
                }

            }

        
        //return (int) stack.pop();



        //int resultado = 0;
        /*for(int i = 0; i < expresion.length; i++){
            if(expresion[i].equals("+")){
                operador = 1;
            }
            if(expresion[i].equals("-")){
                operador = 1;
            }
            if(expresion[i].equals("/")){
                operador = 1;
            }
            if(expresion[i].equals("*")){
                operador = 1;
            }
        }*/

        return Expresion;
    }

}
