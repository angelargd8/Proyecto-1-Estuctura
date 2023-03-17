package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;


public class StackTest {

    @Test
    public void Tamanio(){
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        assertEquals(stack.size(), 2);
    }


    @Test
    public void PopYPeek(){
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        assertEquals(stack.peek(), stack.pop());
    }

    @Test
    public void Empty(){
        Stack<String> stack = new Stack<>();
        assertEquals(stack.empty(), true);
    }



    
}
