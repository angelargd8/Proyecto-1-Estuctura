package CModelos;

//libreria para el uso de ArrayList
import java.util.ArrayList;

public class StackArrayList<E> implements IStack<E> {

	// stack tipo arraylist a utilizar
	protected ArrayList<E> data;

	/**
	 * Método que construye un stack tipo ArrayList
	 */
	public StackArrayList() {
		data = new ArrayList<E>();
	}

	@Override
	/**
	 * Método push, añade un item al Stack
	 * 
	 * @param item, item a añadir al Stack
	 */
	public void push(E item) {
		data.add(item);
	}

	@Override
	/**
	 * Método pop, elimina un elemento del Stack
	 * 
	 * @return valor E que contiene el elemento eliminado
	 */
	public E pop() {
		return data.remove(size() - 1);
	}

	@Override
	/**
	 * Método peek, obtiene el valor del último valor en el Stack
	 * 
	 * @return valor E, valor que contiene el elemento eliminado
	 */
	public E peek() {
		return data.get(size() - 1);
	}

	@Override
	/**
	 * Método empty valida si el Stack está vacío
	 * 
	 * @return valor booleano, que contiene si el Stack está vacío true: vacío
	 *         false: no vacío
	 */
	public boolean empty() {
		return data.size() == 0 ? true : false;
	}

	@Override
	/**
	 * Método size determina el tamaño del Stack
	 * 
	 * @return valor int que contiene el valor de la cantidad de elementos del Stack
	 */
	public int size() {
		return data.size();
	}

}
