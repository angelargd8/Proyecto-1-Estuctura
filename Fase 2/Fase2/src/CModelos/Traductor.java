package CModelos;

public class Traductor {

	public StackArrayList<Object> dividir(String instruccion) {

		StackArrayList<Object> tokens = new StackArrayList<Object>();

		String[] partes = instruccion.split(",");

		for (int i = 0; i < instruccion.length(); i++) {
			tokens.push(instruccion.charAt(i));
			if (i != instruccion.length() - 1) {
				
				tokens.push(", ");
				System.out.println(instruccion.charAt(i));
			}
			
			System.out.println(instruccion.charAt(i));
			
		}
		
		
		return null;
	}

	public StackArrayList<Object> traducir(StackArrayList<Object> stack) {
		StackArrayList<Object> toreturn = new StackArrayList<Object>();
		while (!stack.empty()) {
			if (stack.peek().equals('(')) {
				stack.pop();

				StackArrayList<Object> pivot = traducir(stack); // Llama a la función de forma recursiva para crear un
																// nuevo stack
				// para los elementos entre los paréntesis
				toreturn.push(pivot);
			}

			else if (stack.peek().equals(')')) {
				stack.pop(); // Quita el paréntesis de cierre de la pila original
				return toreturn; // se retorna el del principio
			} else {
				toreturn.push(stack.peek()); // Agrega el elemento actual a la pila que se va a devolver
				stack.pop();
			}
		}
		return toreturn;
	}
}