package CControlador;

// libreria para el uso de Scanner
import java.util.Scanner;
import CModelos.Traductor;

public class Lector {

	/**
	 * Constructor de la clase Lector
	 */
	public Lector() {

	}

	/**
	 * Método para pedir la instrucción LISP al usuario
	 */
	public void menu() {

		System.out.println("=======================");
		System.out.println("||Traductor LISP-JAVA||");
		System.out.println("=======================");

		// pedir la instruccion
		System.out.println("Ingresa tu instrucción");

		// ========================
		// || Pedir instrucciones||
		// ========================
		
		// instancia de Scanner
		Scanner s = new Scanner(System.in);
		
		// respuesta del usuario
		String respuesta = s.next();
		
		// esta respuesta debe enviarse a un stack y evaluarlo

	}

}
