package CVista;

import CControlador.Lector;
import CControlador.Controlador;

public class MostrarMenu {
	Vista vista; 
	int opcion=0;
	Controlador controlador;

	public MostrarMenu(){
		vista = new Vista();
		controlador = new Controlador();
	}


	public void mostrarPrograma(){
		vista.Mensaje();
		try {
			while(opcion!=3){
				opcion = vista.SeleccioneMenu("Escoja una opción: \n1. Mostrar expresión del archivo\n2. Operar expresión del archivo");
				if (opcion==1){
					controlador.LeerArchivo();

				}if (opcion==2){

				}else{
					vista.validacion();
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			vista.validacion();
		}

	}


}
