package CControlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controlador {
    Lector lector; 
    File file;
    String data;

    public Controlador(){
        lector = new Lector();
        file = new File("Instrucciones.txt");


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


    
}
