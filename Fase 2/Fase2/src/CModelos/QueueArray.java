package CModelos;

public class QueueArray<E> implements IQueue<E> {

	/**
	 * Lista con la cola
	 */
	protected Object data[];
	/**
	 * Indicador del próximo valor de la cola
	 */
	protected int head;
	/**
	 * Tamaño actual de la cola
	 */
	protected int count;

	/**
	 * Método que construye una cola con el tamaño indicado
	 * 
	 */
	public QueueArray(int size) {
		data = new Object[size];
		head = 0;
		count = 0;
	}

	/**
	 * Método que retorna true si la cola ya no tiene capacidad para guardar más
	 * información
	 */
	public boolean isFull() {
		return count == data.length;
	}

	@Override
	/**
	 * Método que agrega un elemento al final de la estructura de datos de la cola
	 *
	 * @param value, valor para agregar a la cola
	 */
	public void enqueue(E value) {
		if (!isFull()) {
			int tail = (head + count) % data.length;
			data[tail] = value;
			count++;
		}
	}

	@Override
	/**
	 * Método que elimina y devuelve el elemento en la cabeza de la cola
	 *
	 * @return valor eliminado
	 */
	public E dequeue() {
		if (!empty()) {
			E value = (E) data[head];
			head = (head + 1) % data.length;
			count--;
			return value;
		}
		return null;
	}

	@Override
	/**
	 * Método que devuelve el elemento en la cabeza de la cola sin eliminarlo
	 * 
	 * @return valor en el encabezado de la cola
	 */
	public E peek() {
		if (!empty()) {
			return (E) data[head];
		}

		return null;
	}

	@Override
	/**
	 * Método que devuelve true si la cola está vacía, false en caso contrario
	 */
	public boolean empty() {
		return size() == 0 ? true : false;
	}

	@Override
	/**
	 * Método que retorna el tamaño de la cola
	 */
	public int size() {
		return count;
	}

}
