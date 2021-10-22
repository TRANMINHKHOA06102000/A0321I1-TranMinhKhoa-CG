package test;

import main.Greeter;
import main.Impl.HelloWorld;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloWorldTest {
    @Test
    public void testGreet() {
        Greeter greeter = new HelloWorld();
        String actual = greeter.greet();
        String expected = "Hello";
        String assertResult = expected.equals(actual) ? "PASS" : "FAIL";
        String message = String.format("testGreet: %s, expected: <%s>, actual: <%s>", assertResult, expected, actual);
        System.out.println(message);
        assertEquals(expected, actual);
    }
}
