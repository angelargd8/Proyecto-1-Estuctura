package CModelos;

public interface IStack<E> {
	
	/**
	 * Método push, añade un item al Stack
	 * 
	 * @param item, item a añadir al Stack
	 */
	public void push(E item);

	/**
	 * Método pop, elimina un elemento del Stack
	 * 
	 * @return valor E que contiene el elemento eliminado
	 */
	public E pop();

	/**
	 * Método peek, obtiene el valor del último valor en el Stack
	 * 
	 * @return valor E, valor que contiene el elemento eliminado
	 */
	public E peek();

	/**
	 * Método empty valida si el Stack está vacío
	 * 
	 * @return valor booleano, que contiene si el Stack está vacío 
	 * 		true: vacío
	 *		false: no vacío
	 */
	public boolean empty();

	/**
	 * Método size determina el tamaño del Stack
	 * 
	 * @return valor int que contiene el valor de la cantidad de elementos del Stack
	 */
	public int size();
}
