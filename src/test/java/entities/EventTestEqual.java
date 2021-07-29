package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTestEqual {
    @Test
    public void equals() {
        Event even = new Event(19,3,5, "The independence of the BNR");
        Event event = new Event(1918,3,25, "The independence of the BNR");
        Assertions.assertFalse(event.equals(even));


    }

}