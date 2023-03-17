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

		// Probando el retorno de Cola
		// System.out.println("Los tokens son: " + "\"" + Arrays.toString(tokens) +
		// "\"");
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
		return valores;
	}

	/**
	 * Método para convertir una instruccion en su formato de lista
	 * 
	 * @param tokens, lista con los valores a convertir
	 * @return result, lista de los tokens en un formato de lista
	 */
	public static Object[] convertirLista(QueueArray<Object> origen) {
		// Lista final con todos los elementos
		Object[] listFin = new Object[origen.size()];
		// Indice inicial
		int index = 0;

		// Recorrer mientas la cola no este vacía
		while (!origen.empty()) {

			// Valor actual de la cola
			String valorActual = (String) origen.dequeue();

			// Si el valorActual es "(" debe de realizar una nueva lista
			if (valorActual.equals("(")) {
				// Hace recursividad para crear una nueva lista
				Object[] subList = convertirLista(origen);
				// Añade a la listFin la sublista
				listFin[index++] = subList;

				// Si el valor es ")", acabar el metodo y retornar la lista que se lleva
			} else if (valorActual.equals(")")) {

				Object[] result = new Object[index];
				System.arraycopy(listFin, 0, result, 0, index);
				return result;

				// Si no es un paréntesis, agregar a la lista
			} else {
				listFin[index++] = valorActual;
			}
		}
		// Se acabó los valores para agregar a listFin
		// Se crea una lista result que contendrá los elementos de listFin que no están
		// vacíos
		Object[] result = new Object[index];
		// System.arraycopy(origen, indice_de_inicio, destino, indice_de_inicio,cantidad_de_elementos_a_copiar)
		System.arraycopy(listFin, 0, result, 0, index);
		return result;
	}
}