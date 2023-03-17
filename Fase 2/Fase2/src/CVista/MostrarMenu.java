package CVista;

import CControlador.Lector;

import CControlador.Controlador;

public class MostrarMenu {
	Vista vista; 
	int opcion=0;
	Controlador controlador;
	String input;

	public MostrarMenu(){
		vista = new Vista();
		controlador = new Controlador();
		
	}


	public void mostrarPrograma(){
		vista.Mensaje();
		try {
			while(opcion!=3){
				opcion = vista.SeleccioneMenu("Escoja una opción: \n1. Operar expresión del archivo\n2. Operar expresión ingresada\n3. Salir");
				if (opcion==1){
					String exp = controlador.MostrarExpresion();
					controlador.ExpresionM(exp);

				}if (opcion==2){
					//controlador.LeerArchivo();
					//ArrayList<String>  resultado = new ArrayList<>();
					
					input = vista.SeleccioneMenuString("Ingrese la expresión a calcular:");
					//resultado.add(input);
					controlador.ExpresionM(input);

				}if (opcion==3){
					break;
				}
				else{
					vista.validacion();
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			vista.validacion();
		}

	}


}
