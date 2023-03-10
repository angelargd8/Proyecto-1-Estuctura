package CModelos;

import java.util.Arrays;

public class Traductor {

	/**
	 * Método dividir, que separa la instruccion como tokens y los almacena en un
	 * stack
	 * 
	 * @param instruccion, instruccion a dividir
	 * @return stack con los tokens
	 */
	public StackArrayList<Object> dividir(String instruccion) {

		// Stack que almacena la instrucción separada
		StackArrayList<Object> tokens = new StackArrayList<Object>();

		// separa la instruccion por comas
		String[] valores = instruccion.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").trim().split("\\s+");

		System.out.println(Arrays.toString(valores));

		// tamaño de valores
		int size = valores.length;

		// recorrer todos los valores de la lista "valores"
		for (int i = 0; i < size; i++) {

			tokens.push(valores[i]);

			// añadir "," despues de cada valor solo si ha llegado al final de la
			// instruccion
			if (i != size) {
				tokens.push(",");
			}
		}

		return tokens;
	}

}