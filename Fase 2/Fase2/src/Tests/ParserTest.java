package Tests;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.EOFException;
import java.util.Queue;

import CModelos.Parser;
import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    public void Test() throws EOFException{
        Parser parser = new Parser();
        String[] tokenizedExpression = parser.tokenizeLispExpression("(+ 2 3)");
		Object tokenQueue = parser.readTokenQueue(parser.getTokenQueue(tokenizedExpression));
        try {
            assertEquals(parser.evaluateExpression((Queue<Object>) tokenQueue).toString(), "5");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
