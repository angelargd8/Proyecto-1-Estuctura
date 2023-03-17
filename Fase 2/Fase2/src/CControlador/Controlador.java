package CControlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

import CVista.Vista;

public class Controlador {
    Lector lector; 
    File file;
    String data;
    Vista vista;
    //LinkedList<String> ExpresionLista;
    ArrayList<Object> ExpresionLista;
    //LinkedList<String> ExpresionTemp;
    String ExpresionTemp= "";
    int resultado= 0;

    public Controlador(){
        lector = new Lector();
        file = new File("Instrucciones.txt");
        vista= new Vista();
        //ExpresionLista = new LinkedList<>();
        //ExpresionLista = new LinkedList<>();
        ExpresionTemp= " + 2 3";
        //ExpresionTemp.add("+");
        //ExpresionTemp.add("2");
        //ExpresionTemp.add("3");

    }
    
    public void LeerArchivo(){
        lector.menu();
    }

    public void MostrarExpresion(){
        try {
            Scanner leer_archivo = new Scanner(file);

            while (leer_archivo.hasNextLine()) {
                data = leer_archivo.nextLine();
                System.out.println("Expresión: "+ data);
            }

            leer_archivo.close();
            

        } catch (FileNotFoundException e) {
            System.out.println(" - Excepcion al abrir el archivo" + e);

        }
		
	}

    public ArrayList<String> ExpresionM (String StringExpresion){
        //expresion :(+ 2 3)
        ArrayList<String> resultado = new ArrayList<>();
        resultado.add(StringExpresion);
        System.out.println(resultado);
        for (int i =0; i<StringExpresion.length(); i++){
            System.out.println(StringExpresion.charAt(i));
            if (StringExpresion.charAt(i)=='('){
                resultado.add(StringExpresion.substring(i, i+1));
                System.out.println("xd"+resultado);
            }else if (StringExpresion.charAt(i)==')'){
                vista.validacion();
                //resultado.add(StringExpresion.substring(i, i+1));
            }else if (Character.isWhitespace(StringExpresion.charAt(i))){
                System.out.println(i);
                i++;
                System.out.println("2"+i);
            }else{
                resultado.add(StringExpresion.substring(i, i+1));
                System.out.println("xddd"+resultado);

            }

        }
        
        /*for (int i=0; i<ExpresionLista.size(); i++){
            String elemento = ExpresionLista.get(i);
            ExpresionLista.add(elemento);
            System.out.println(elemento);
        }*/
        return resultado;
    }



    /*public ArrayList<String> ExpresionM (ArrayList<String> StringExpresion){
        ArrayList<String> resultado = new ArrayList<>();
        System.out.println(resultado);

        for (int i =0; i<StringExpresion.size(); i++){
            // tiene que cerrar el parentesis ()
            System.out.println("bandera 1");
            System.out.println(StringExpresion.toString());
            if (StringExpresion.get(i).equals("(")){
                System.out.println("bandera 2");
                //resultado.add(expresion.get(i));
                int posicion=0;
                int contadorAbre= 1;
                int contadorCierre =0;

                for (int j= i+1; j<StringExpresion.size(); j++){
                    System.out.println("bandera 3");

                    if (StringExpresion.get(j).equals(")")){
                        System.out.println("bandera 4");

                        posicion= j;
                        contadorCierre++;
                    }
                    if (StringExpresion.get(j).equals("(")){
                        System.out.println("bandera 5");

                        contadorAbre++;
                    }
                    if (contadorAbre==contadorCierre){
                        List<String> SubLista =StringExpresion.subList(i+1, contadorCierre+1);
                        ArrayList<String> tempS = new ArrayList<>(SubLista);
                        resultado.addAll(ExpresionM(tempS)); 
                        for (int k = i+1; k<posicion+1; k++){
                            //StringExpresion.remove(i+1);
                            StringExpresion.remove(k);
                        }
                        //resultado.add(StringExpresion.get(i));
                    }
                }
            }else{
                resultado.add(StringExpresion.get(i));
            }
        }

        return resultado;
        
    }*/

    


    
}
