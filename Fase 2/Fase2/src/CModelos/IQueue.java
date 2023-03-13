package CModelos;

public interface IQueue<E> {

	/**
	 * Método que agrega un elemento al final de la estructura de datos de la cola
	 *
	 * @param value, valor para agregar a la cola
	 */
	public void enqueue(E value);

	/**
	 * Método que elimina y devuelve el elemento en la cabeza de la cola
	 *
	 * @return valor eliminado
	 */
	public E dequeue();

	/**
	 * Método que devuelve el elemento en la cabeza de la cola sin eliminarlo
	 * 
	 * @return valor en el encabezado de la cola
	 */
	public E peek();

	/**
	 * Método que devuelve true si la cola está vacía, false en caso contrario
	 */
	public boolean empty();

	/**
	 * Método que retorna el tamaño de la cola
	 */
	public int size();
}
