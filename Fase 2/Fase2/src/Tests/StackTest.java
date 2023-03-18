package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Stack;

import org.junit.jupiter.api.Test;


public class StackTest {
     /** 
     * @throws EOFException
     */
    @Test
    public void Tamanio(){
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        assertEquals(stack.size(), 2);
    }

     /** 
     * @throws EOFException
     */
    @Test
    public void PopYPeek(){
        Stack<String> stack = new Stack<>();
        stack.push("1");
        stack.push("2");
        assertEquals(stack.peek(), stack.pop());
    }
     /** 
     * @throws EOFException
     */ /** 
     * @throws EOFException
     */
    @Test
    public void Empty(){
        Stack<String> stack = new Stack<>();
        assertEquals(stack.empty(), true);
    }



    
}
