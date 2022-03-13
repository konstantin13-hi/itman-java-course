package example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.example.example;

public class ExampleTests {
    @Test
    public void sumPositiveValues() {
        Assertions.assertEquals(15, example.sum(5, 10));
    }

    @Test
    public void sumNegativeValues() {
        Assertions.assertEquals(-10, example.sum(-7, -3));
    }
}
