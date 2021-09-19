package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tasks.Task408;
import tasks.Task439;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {
    @Test
    public void toStringWithObject() {
        Event events = new Event(2031, 11, 13, "Day of City in Minsk");
        String expectedElement = "Event{year=" + 2031 + ", month=" + 11 + ", day=" + 13 + ", name='Day of City in Minsk'}";
        Assertions.assertEquals(expectedElement, events.toString());
    }

    @Test
    public void toStringWithSecondObject() {
        Event events = new Event(1918, 3, 25, "The independence of the BNR");
        String expectedElement = "Event{year=1918, month=3, day=25, name='The independence of the BNR'}";
        Assertions.assertEquals(expectedElement, events.toString());
    }
}