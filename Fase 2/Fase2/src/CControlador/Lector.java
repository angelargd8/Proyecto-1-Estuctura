package CControlador;

// Librerias para leer el archivo de instrucciones txt
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Paquete con las operaciones de traductor
import CModelos.*;
// Libreria para leer tokens/stack
import java.util.Arrays;

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

		try {

			// Ruta del archivo de instrucciones
			File archivo = new File("Instrucciones.txt");
			// Instancia de Scanner para leer el archivo
			Scanner scanner = new Scanner(archivo);

			// Lee el archivo línea por línea
			while (scanner.hasNextLine()) {
				String linea = scanner.nextLine();

				// Muestra la instrucción y seguidamente su token
				System.out.println("==============================");
				System.out.println("La instruccion es: " + "\"" + linea + "\"");
				// Tokens
				StackArrayList<Object> tokens = Traductor.dameToken(linea);
				// Ver la cola
				Traductor.convertirTokenLista(tokens);
				System.out.println("==============================");

			}
			// Cierra el objeto Scanner
			scanner.close();

		} catch (FileNotFoundException e) {
			System.out.println("El archivo no se encuentra.");
			e.printStackTrace();
		}

		// traductor.traducir(traductor.dividir(respuesta));
		// traductor.dividir(respuesta);

	}
}
