package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import CModelos.QueueArray;
import org.junit.jupiter.api.Test;

public class QueueTest {

    @Test
    public void Tamanio(){
        QueueArray<String> queue= new QueueArray<>(2);
        queue.enqueue("1");
        queue.enqueue("2");
        assertEquals(queue.size(), 2);
    }

    @Test
    public void DequeueTest(){
        QueueArray<String> queue= new QueueArray<>(2);
        queue.enqueue("1");
        queue.enqueue("2");
        queue.dequeue();
        assertEquals(queue.size(), 1);
    }

    @Test
    public void PeekTest(){
        QueueArray<String> queue= new QueueArray<>(2);
        queue.enqueue("1");
        queue.enqueue("2");
        assertEquals(queue.peek(), "1");
    }

    @Test
    public void EmptyTest(){
        QueueArray<String> queue= new QueueArray<>(0);
        assertEquals(queue.empty(), true);
    }


    @Test
    public void SizeTest(){
        QueueArray<String> queue= new QueueArray<>(0);
        assertEquals(queue.size(), 0);
    }

    
}
