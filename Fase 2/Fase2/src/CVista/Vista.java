package CVista;
import java.util.Scanner;

public class Vista {
    Scanner leer; 
    //para validar los espacios 
    Teclado in;
    //Controlador controlador;

    public Vista(){
        leer = new Scanner(System.in);
        //para validar los espacios 
        in = new Teclado();
        //controlador= new Controlador();
    }

    public void Mensaje(){
        System.out.println("\n\n - Presione Enter para ingresar -");
        leer.nextLine();
    }

    /** 
     * @param Seleccion
     * @return int
     */
    public int SeleccioneMenu(String Seleccion){
        int opcion;
        System.out.println(Seleccion);
        opcion= leer.nextInt();
        return opcion; 
    }

    
    /** 
     * @param Seleccion
     * @return String
     */
    public String SeleccioneMenuString(String Seleccion){
        String respuesta;
        respuesta= in.getString(Seleccion);
        return respuesta; 
    }

    public void validacion(){
        System.out.println("\n- --- -");
    }

    public void SeAbrioArchivo(){
        System.out.println("\n- Se abrio el archivo correctamente   -");
    }

    public void validacion2(){
        System.out.println("\n- Hay  algo que ha ingresado mal, revise los espacios, puede afectar a su resultado-");
    }

}