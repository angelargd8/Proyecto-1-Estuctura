package CVista;

import java.util.Scanner;
/*
* Esta clase sirve para poder validar los espacios en el input de la consola
*/

public class Teclado {
    Scanner leer;

    public Teclado() {
        leer = new Scanner(System.in);
        
    }

    
    /** 
     * @param titulo
     * @return String
     */
    public String getString(String titulo){
        String string1 = "";

        while(string1.equals("")){
            System.out.println(titulo);
            string1 = leer.nextLine();
        }      
        return string1;

    }
}
