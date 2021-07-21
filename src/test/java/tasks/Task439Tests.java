package tasks;


import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task439Tests {

    @Test
    public void findTheElementOfArrayWhichHaveTheBiggestDate() {


        Event[] events = new Event[]{
                new Event(1994, 11, 12, "sae1"),
                new Event(1994, 2, 4, "sa3"),
                new Event(31, 3, 5, "rew")

        };
        Event expectedelement = new Event(1994, 11, 12, "sae1");
        Event expected = events[0];
        Event actual = Task439.findLast(events);
        assert actual != null;
        checkingASortedArrayLinks(expected, actual);
        checkingASortedArrayElements(expectedelement, actual);

    }

    @Test
    public void findTheElementOfArrayWhichHaveTheBiggestDateWhenTwoNameSame() {
        Event[] events = new Event[]{
                new Event(2000, 11, 12, "Day of City in Gomel"),
                new Event(1424, 9, 8, "Day of City in Minsk"),
                new Event(2031, 11, 13, "Day of City in Minsk"),
                new Event(231, 2, 6, "Day of City in Vitebsk"),
                new Event(314, 7, 15, "Day of City in Borisow")

        };
        Event expectedelement = new Event(2031, 11, 13, "Day of City in Minsk");
        Event expected = events[2];
        Event actual = Task439.findLast(events);
        assert actual != null;
        checkingASortedArrayLinks(expected, actual);
        checkingASortedArrayElements(expectedelement, actual);
    }

    @Test
    public void findTheElementOfArrayWhichHaveTheBiggestDateIfArrayEmpty() {
        Event[] events = new Event[0];
        Event actual = Task439.findLast(events);
        Assertions.assertNull(actual);
    }

    public static void checkingASortedArrayLinks(Event expected, Event actual) {
        Assertions.assertSame(expected, actual);

    }

    public static void checkingASortedArrayElements(Event expectedelement, Event actual) {
        Assertions.assertEquals(expectedelement.name, actual.name);
        Assertions.assertEquals(expectedelement.day, actual.day);
        Assertions.assertEquals(expectedelement.month, actual.month);
        Assertions.assertEquals(expectedelement.year, actual.year);
    }
}