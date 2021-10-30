package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    @Test
    public void equals() {
        Ticket even = new Ticket(19, "TT");
        Ticket event = new Ticket(18, "II");
        Assertions.assertFalse(event.equals(even));
    }

    @Test
    public void toStringWithObject() {
        Ticket actual = new Ticket(20, "DD");
        String expectedElement = "Ticket{number=" + 20 + ", place='DD'}";
        Assertions.assertEquals(expectedElement, actual.toString());
    }

    @Test
    public void equalsDiferent() {
        Ticket even = new Ticket(19, "TT");
        Ticket event = new Ticket(19, "TT");
        Assertions.assertTrue(event.equals(even));
    }
}