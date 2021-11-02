package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    public void compareToTwoObjecktDiferent() {
        Event even = new Event(19, 3, 5, "The independence of the BNR");
        Event event = new Event(1918, 3, 25, "The independence of the BNR");
        Assertions.assertEquals(1, event.compareTo(even));
    }

    @Test
    public void compareToTwoObjecktSame() {
        Event even = new Event(1918, 3, 25, "The independence of the BNR");
        Event event = new Event(1918, 3, 25, "The independence of the BNR");
        Assertions.assertEquals(0, event.compareTo(even));
    }

    @Test
    public void compareToWhenTheCurrentObjectHappenedBeforeThePassedOne() {
        Event even = new Event(1918, 3, 25, "The independence of the BNR");
        Event event = new Event(191, 3, 25, "The independence of the BNR");
        Assertions.assertEquals(-1, event.compareTo(even));
    }

    @Test
    public void equals() {
        Event even = new Event(19, 3, 5, "The independence of the BNR");
        Event event = new Event(1918, 3, 25, "The independence of the BNR");
        Assertions.assertFalse(event.equals(even));
    }

    @Test
    public void equalsWithNull() {
        Event event = new Event(1918, 3, 25, "The independence of the BNR");
        Assertions.assertFalse(event.equals(null));
    }

    @Test
    public void equalsWithNameNull() {
        Event even = new Event(2024, 2, 28, null);
        Event event = new Event(2024, 2, 28, null);
        Assertions.assertTrue(event.equals(even));
    }

    @Test
    public void equalsWithNameNullAndDifferentDates() {
        Event even = new Event(2020, 1, 1, null);
        Event event = new Event(2020, 2, 2, null);
        Assertions.assertFalse(event.equals(even));
    }

    @Test
    public void equalsWithSameNamesButDifferentData() {
        Event even = new Event(2021, 10, 10, "A");
        Event event = new Event(2021, 2, 2, "B");
        Assertions.assertFalse(event.equals(even));
    }

    @Test
    public void equalsWithSameData() {
        Event even = new Event(2021, 10, 10, "AA");
        Event event = new Event(2021, 10, 10, new String("AA"));
        Assertions.assertTrue(event.equals(even));
    }

    @Test
    public void equalsWithSame() {
        Event event = new Event(2023, 2, 28, "AA");
        Event even = new Event(2023, 2, 28, null);
        Assertions.assertFalse(event.equals(even));
    }


}