package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class EventTest {
    @Nested
    public class ToString {

        @Test
        public void shouldReturnStringWhenObjectIsNotEmpty() {
            Event events = new Event(5, 1918, 3, 25, "The independence of the BNR");
            String expectedElement = "Event{id=5, year=1918, month=3, day=25, name='The independence of the BNR'}";
            Assertions.assertEquals(expectedElement, events.toString());
        }

        @Test
        public void shouldReturnStringWhenNameIsNull() {
            Event events = new Event(5, 1918, 3, 25, null);
            String expectedElement = "Event{id=5, year=1918, month=3, day=25, name='null'}";
            Assertions.assertEquals(expectedElement, events.toString());
        }
    }

    @Nested
    public class Compare {

        @Test
        public void shouldCompareWhenTwoObjectsAreDifferent() {
            Event even = new Event(19, 3, 5, "The independence of the BNR");
            Event event = new Event(1918, 3, 25, "The independence of the BNR");
            Assertions.assertEquals(1, event.compareTo(even));
        }

        @Test
        public void shouldCompareWhenTwoObjectsAreSame() {
            Event even = new Event(1918, 3, 25, "The independence of the BNR");
            Event event = new Event(1918, 3, 25, "The independence of the BNR");
            Assertions.assertEquals(0, event.compareTo(even));
        }

        @Test
        public void shouldCompareWhenTheCurrentObjectHappenedBeforeThePassedOne() {
            Event even = new Event(1918, 3, 25, "The independence of the BNR");
            Event event = new Event(191, 3, 25, "The independence of the BNR");
            Assertions.assertEquals(-1, event.compareTo(even));
        }
    }

    @Nested
    public class Equals {

        @Test
        public void shouldEqualsWhenDifferentDatesAndSameNames() {
            Event even = new Event(19, 3, 5, "The independence of the BNR");
            Event event = new Event(1918, 3, 25, "The independence of the BNR");
            Assertions.assertFalse(event.equals(even));
        }

        @Test
        public void shouldEqualsWhenSecondObjectIsNull() {
            Event event = new Event(1918, 3, 25, "The independence of the BNR");
            Assertions.assertFalse(event.equals(null));
        }

        @Test
        public void shouldEqualsWhenTwoDateAreSameAndTheirNamesAreNull() {
            Event even = new Event(2024, 2, 28, null);
            Event event = new Event(2024, 2, 28, null);
            Assertions.assertTrue(event.equals(even));
        }

        @Test
        public void shouldEqualsWhenNamesAreNullAndDifferentDates() {
            Event even = new Event(2020, 1, 1, null);
            Event event = new Event(2020, 2, 2, null);
            Assertions.assertFalse(event.equals(even));
        }

        @Test
        public void shouldEqualsWhenSameDatesAndDifferentNames() {
            Event even = new Event(2021, 10, 10, "A");
            Event event = new Event(2021, 2, 2, "B");
            Assertions.assertFalse(event.equals(even));
        }

        @Test
        public void shouldEqualsWhenSameDatesAndNames() {
            Event even = new Event(2021, 10, 10, "AA");
            Event event = new Event(2021, 10, 10, new String("AA"));
            Assertions.assertTrue(event.equals(even));
        }

        @Test
        public void shouldEqualsWhenDatesSameAndSecondObjectHasNullName() {
            Event event = new Event(2023, 2, 28, "AA");
            Event even = new Event(2023, 2, 28, null);
            Assertions.assertFalse(event.equals(even));
        }
    }
}