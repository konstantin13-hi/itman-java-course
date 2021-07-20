package tasks;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task408Tests {

    @Test
    public void sortElementsOfArray() {
        Event[] actual = new Event[]{
                new Event(1994, 11, 12, "sae1"),
                new Event(1994, 2, 4, "sa3"),
                new Event(31, 3, 5, "rew")
        };
        Event[] expectedElement = new Event[actual.length];
        Task408.sort(actual);
        Event[] expected = new Event[]{
                new Event(31, 3, 5, "rew"),
                new Event(1994, 2, 4, "sa3"),
                new Event(1994, 11, 12, "sae1")
        };
        checkingASortedArrayElements(actual, expected);
        createArray(actual, expectedElement);
        checkingASortedArrayLinks(actual, expectedElement);
    }


    @Test
    public void sortElementsOfArrayTwoNameSame() {
        Event[] actual = new Event[]{
                new Event(2000, 11, 12, "Day of City in Gomel"),
                new Event(1424, 9, 8, "Day of City in Minsk"),
                new Event(231, 2, 6, "Day of City in Vitebsk"),
                new Event(314, 7, 15, "Day of City in Borisow"),
                new Event(2031, 11, 13, "Day of City in Minsk")
        };
        Event[] expectedElement = new Event[actual.length];
        Task408.sort(actual);
        Event[] expected = new Event[]{
                new Event(231, 2, 6, "Day of City in Vitebsk"),
                new Event(314, 7, 15, "Day of City in Borisow"),
                new Event(1424, 9, 8, "Day of City in Minsk"),
                new Event(2000, 11, 12, "Day of City in Gomel"),
                new Event(2031, 11, 13, "Day of City in Minsk")
        };
        checkingASortedArrayElements(actual, expected);
        createArray(actual, expectedElement);
        checkingASortedArrayLinks(actual, expectedElement);

    }

    public static void checkingASortedArrayElements(Event[] actual, Event[] expected) {
        for (int i = 0; i < actual.length; i++) {
            Assertions.assertEquals(expected[i].day, actual[i].day);
            Assertions.assertEquals(expected[i].month, actual[i].month);
            Assertions.assertEquals(expected[i].year, actual[i].year);
            Assertions.assertEquals(expected[i].name, actual[i].name);
        }
    }

    public static void createArray(Event[] actual, Event[] expectedElement) {
        for (int i = 0; i < expectedElement.length; i++) {
            expectedElement[i] = actual[i];
        }
    }

    public static void checkingASortedArrayLinks(Event[] actual, Event[] expectedElement) {
        for (int i = 0; i < expectedElement.length; i++) {
            Assertions.assertEquals(expectedElement[i], actual[i]);
        }
    }
}


