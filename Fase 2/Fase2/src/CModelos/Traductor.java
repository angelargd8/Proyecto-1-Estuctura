package CModelos;

// Libreria para leer tokens/stack
// import java.util.Arrays;

public class Traductor {

	/**
	 * Método dividir, que separa la instruccion como tokens y los almacena en un
	 * stack
	 * 
	 * @param instruccion, instruccion a dividir
	 * @return stack con los tokens
	 */
	public static StackArrayList<Object> dameToken(String instruccion) {

		// Stack que almacena la instrucción separada
		StackArrayList<Object> tokens = new StackArrayList<Object>();

		// separa la instruccion por comas
		String[] valores = instruccion.replaceAll("\\(", " ( ").replaceAll("\\)", " ) ").trim().split("\\s+");

		// System.out.println(Arrays.toString(valores));

		// tamaño de valores
		int size = valores.length;

		// recorrer todos los valores de la lista "valores"
		for (int i = 0; i < size; i++) {
			tokens.push(valores[i]);

		}
		return tokens;
	}

	/**
	 * Método para convertir el Stack en una Cola
	 * 
	 * @param tokens, Stack con los tokens
	 * @return valores, Cola con los tokens
	 */
	public static QueueArray<Object> convertirTokenCola(StackArrayList<Object> tokens) {

		QueueArray<Object> valores = new QueueArray<Object>(tokens.size());

		// Lista para leer los tokens
		Object[] listaTemporal = new Object[tokens.size()];

		// Recorrer los tokens y gurdarlos en la lista temporal
		for (int i = tokens.size() - 1; i >= 0; i--) {
			listaTemporal[i] = tokens.pop();
		}

		// Guardar los datos de la lista temporal en Cola
		for (int x = 0; x < listaTemporal.length; x++) {
			valores.enqueue(listaTemporal[x]);
		}

		// Probando el retorno de Cola
		// System.out.println("Los tokens son: " + "\"" + Arrays.toString(listaTemporal)
		// + "\"");
		return valores;
	}

	/**
	 * Método para convertir una instruccion en su formato de lista
	 * 
	 * @param tokens, lista con los valores a convertir
	 */
	public static Object[] convertirLista(QueueArray<Object> origen) {

		// Tamaño de la lista a convertir
		int size = origen.size();
		// Lista temporal que contendrá los valores finales
		Object[] temporal = new Object[size];

		// Recorrer la lista para comprobar si se debe de crear una nueva lista
		for (int i = 0; i < size; i++) {

			// Valor recorrido
			String valorActual = (String) origen.dequeue();

			/*
			 * Comienza el algoritmo
			 */

			// Si el valor es "(" debe de realizar recursividad para realizar una nueva
			// lista
			if (valorActual.equals("(")) {
				

				convertirLista
				
				
				
				
				// Si el valor es ")", acabar el metodo y retonar la lista que se lleva
			} else if (valorActual.equals(")")) {

				
				
				
				
				// Si no debe hacer recursividad o terminar el método, meter a origen el valor
				// actual
			} else {

				
				
				
			}

		}

		return null;
	}

}