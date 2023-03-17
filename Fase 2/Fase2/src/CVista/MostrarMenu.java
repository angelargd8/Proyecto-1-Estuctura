package CVista;

import CControlador.Lector;
import CModelos.Parser;

import java.util.Queue;

import CControlador.Controlador;

public class MostrarMenu {
	Vista vista; 
	int opcion=0;
	Controlador controlador;
	String input;
	Parser parser;

	public MostrarMenu(){
		vista = new Vista();
		controlador = new Controlador();
		parser = new Parser();
	}


	public void mostrarPrograma(){
		vista.Mensaje();
		try {
			while(opcion!=3){
				opcion = vista.SeleccioneMenu("Escoja una opción: \n1. Operar expresión del archivo\n2. Operar expresión ingresada\n3. Salir");
				if (opcion==1){
					String exp = controlador.MostrarExpresion();
					// parser.tokenizeLispExpression(exp);
					try {
						String[] tokenizedExpression = parser.tokenizeLispExpression(exp);
						Object tokenQueue = parser.readTokenQueue(parser.getTokenQueue(tokenizedExpression));
						System.out.println("Result = " + parser.evaluateExpression((Queue<Object>) tokenQueue).toString());
					} catch (Exception e) {
						e.getMessage();
					}

				}if (opcion==2){
					//controlador.LeerArchivo();
					//ArrayList<String>  resultado = new ArrayList<>();
					
					input = vista.SeleccioneMenuString("Ingrese la expresión a calcular:");
					//resultado.add(input);
					// parser.tokenizeLispExpression(input);
					try {
						String[] tokenizedExpression = parser.tokenizeLispExpression(input);
						Object tokenQueue = parser.readTokenQueue(parser.getTokenQueue(tokenizedExpression));
						System.out.println("Result = " + parser.evaluateExpression((Queue<Object>) tokenQueue).toString());
					} catch (Exception e) {
						e.getMessage();
					}

				}if (opcion==3){
					break;
				}
				else{
					vista.validacion();
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			vista.validacion();
		}

	}


}
