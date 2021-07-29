package entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class EventTestCompareTo {
    @Test
    public void compareToTwoObjecktDiferent(){
        Event even = new Event(19,3,5, "The independence of the BNR");
        Event event = new Event(1918,3,25, "The independence of the BNR");
        Assertions.assertEquals(1, event.compareTo(even));

    }

    @Test
    public void compareToTwoObjecktSame(){
        Event even = new Event(1918,3,25, "The independence of the BNR");
        Event event = new Event(1918,3,25, "The independence of the BNR");
        Assertions.assertEquals(0, event.compareTo(even));

    }

    @Test
    public void compareToWhenTheCurrentObjectHappenedBeforeThePassedOne(){
        Event even = new Event(1918,3,25, "The independence of the BNR");
        Event event = new Event(191,3,25, "The independence of the BNR");
        Assertions.assertEquals(-1, event.compareTo(even));

    }

}