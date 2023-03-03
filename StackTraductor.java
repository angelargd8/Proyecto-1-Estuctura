public Stack<Object> pharse(Stack<Object> stack){
		Stack<Object> toreturn = new Stack<Object>();
		while(!stack.isEmpty()) {
			if(stack.peek().equals('(')) {
				stack.pop();
				Stack<Object> pivot = pharse(stack); // Llama a la función de forma recursiva para crear un nuevo stack para los elementos entre los paréntesis
	            toreturn.push(pivot); 
			}
			else if(stack.peek().equals(')')) {
				stack.pop(); // Quita el paréntesis de cierre de la pila original
	            return toreturn; //se retorna el del principio
			}
			else {
				toreturn.push(stack.peek()); // Agrega el elemento actual a la pila que se va a devolver
	            stack.pop();
			}
			
		}
		return toreturn;
	}