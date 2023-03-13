package CModelos;

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
	 */
	public static void convertirTokenLista(StackArrayList<Object> tokens) {

		QueueArray<Object> valores = new QueueArray<Object>(tokens.size());

		// Lista para leer los tokens
		Object[] listaTemporal = new Object[tokens.size()];

		// Recorrer los tokens y gurdarlos en la lista temporal
		for (int i = tokens.size() - 1; i >= 0; i--) {
			System.out.print(tokens.peek() + ", ");
			listaTemporal[i] = tokens.pop();

		}

		// Guardar los datos de la lista temporal en Cola
		for (int x = 0; x < tokens.size(); x++) {
			valores.enqueue(listaTemporal[x]);
		}
		System.out.println(valores.dequeue());

	}

	/**
	 * Método para convertir una instruccion en su formato de lista
	 * 
	 * @param tokens, lista con los valores a convertir
	 */
	public static Object[] convertirLista(Object[] tokens) {

		// Tamaño de la lista a convertir
		int size = tokens.length;
		// Lista temporal que contendrá los valores finales
		Object[] valores = new Object[size];

		// Recorrer la lista para comprobar si se debe de crear una nueva lista
		for (int i = 0; i < size; i++) {

			// Valor recorrido
			String valorActual = (String) tokens[i];

			// Si el valor es "(", crear una lista
			if (valorActual.equals("(")) {

				// Si el valor es ")", acabar el metodo y retonar la lista que se lleva
			} else if (valorActual.equals(")")) {

				return valores;
			}

		}

		return null;
	}

}