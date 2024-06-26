package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    @Nested
    public class Equals {

        @Test
        public void shouldEqualsWhenObjectsAreDifferent() {
            Ticket even = new Ticket(19, "TT");
            Ticket event = new Ticket(18, "II");
            Assertions.assertFalse(event.equals(even));
        }

        @Test
        public void shouldEqualsWhenObjectsAreSame() {
            Ticket even = new Ticket(19, "TT");
            Ticket event = new Ticket(19, "TT");
            Assertions.assertTrue(event.equals(even));
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnsStringWhenObjectIsNotEmpty() {
            Ticket actual = new Ticket(20, "DD");
            String expectedElement = "Ticket{number=" + 20 + ", place='DD'}";
            Assertions.assertEquals(expectedElement, actual.toString());
        }
    }
}