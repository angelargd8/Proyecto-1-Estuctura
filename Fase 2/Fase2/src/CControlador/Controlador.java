package CControlador;

public class Controlador {
    Lector lector;

    public Controlador(){
        lector = new Lector();

    }
    
    public void LeerArchivo(){
        lector.menu();
    }


    
}
