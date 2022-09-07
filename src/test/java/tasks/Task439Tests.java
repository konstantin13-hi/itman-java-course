package tasks;


import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task439Tests {
    @Nested
    public class FindLast {

        @Test
        public void shouldFindElementWithBiggestDateWhenArrayIsNotEmpty() {
            Event[] events = new Event[]{
                    new Event(1994, 11, 12, "sae1"),
                    new Event(1994, 2, 4, "sa3"),
                    new Event(31, 3, 5, "rew")

            };
            Event expectedElement = new Event(1994, 11, 12, "sae1");
            Event expected = events[0];
            Event actual = Task439.findLast(events);
            assert actual != null;
            Assertions.assertSame(expected, actual);
            checkingArrayElements(expectedElement, actual);
        }

        @Test
        public void shouldFindElementWithBiggestDateWhenTwoNameSame() {
            Event[] events = new Event[]{
                    new Event(2000, 11, 12, "Day of City in Gomel"),
                    new Event(1424, 9, 8, "Day of City in Minsk"),
                    new Event(2031, 11, 13, "Day of City in Minsk"),
                    new Event(231, 2, 6, "Day of City in Vitebsk"),
                    new Event(314, 7, 15, "Day of City in Borisow")

            };
            Event expectedElement = new Event(2031, 11, 13, "Day of City in Minsk");
            Event expected = events[2];
            Event actual = Task439.findLast(events);
            assert actual != null;
            Assertions.assertSame(expected, actual);
            checkingArrayElements(expectedElement, actual);
        }

        @Test
        public void shouldFindElementWithBiggestDateWhenArrayHasFiveEvents() {
            Event[] events = new Event[]{
                    new Event(2020, 10, 25, "A"),
                    new Event(2020, 5, 20, "B"),
                    new Event(2020, 7, 15, "C"),
                    new Event(2021, 1, 1, "D"),
                    new Event(2021, 1, 1, "E")

            };
            Event expectedElement = new Event(2021, 1, 1, "E");
            Event expected = events[4];
            Event actual = Task439.findLast(events);
            assert actual != null;
            Assertions.assertSame(expected, actual);
            checkingArrayElements(expectedElement, actual);
        }

        @Test
        public void shouldFindElementWithBiggestDateWhenArrayEmpty() {
            Event[] events = new Event[0];
            Event actual = Task439.findLast(events);
            Assertions.assertNull(actual);
        }
    }


    private static void checkingArrayElements(Event expectedElement, Event actual) {
        Assertions.assertEquals(0, expectedElement.compareTo(actual));

    }
}
