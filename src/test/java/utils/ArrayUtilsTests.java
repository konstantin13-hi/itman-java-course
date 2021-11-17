package utils;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayUtilsTests {

    @Test
    public void sortElementsOfArray() {
        Event[] actual = new Event[]{
                new Event(1994, 11, 12, "sae1"),
                new Event(1994, 2, 4, "sa3"),
                new Event(31, 3, 5, "rew")
        };
        Event[] expectedElement = new Event[actual.length];
        expectedElement[0] = actual[2];
        expectedElement[1] = actual[1];
        expectedElement[2] = actual[0];

        Event[] expected = new Event[]{
                new Event(31, 3, 5, "rew"),
                new Event(1994, 2, 4, "sa3"),
                new Event(1994, 11, 12, "sae1")
        };

        ArrayUtils.bubbleSort(actual);
        checkingASortedArrayElements(actual, expected);
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
        expectedElement[0] = actual[2];
        expectedElement[1] = actual[3];
        expectedElement[2] = actual[1];
        expectedElement[3] = actual[0];
        expectedElement[4] = actual[4];
        Event[] expected = new Event[]{
                new Event(231, 2, 6, "Day of City in Vitebsk"),
                new Event(314, 7, 15, "Day of City in Borisow"),
                new Event(1424, 9, 8, "Day of City in Minsk"),
                new Event(2000, 11, 12, "Day of City in Gomel"),
                new Event(2031, 11, 13, "Day of City in Minsk")
        };

        ArrayUtils.bubbleSort(actual);
        checkingASortedArrayElements(actual, expected);
        checkingASortedArrayLinks(actual, expectedElement);

    }


    @Test
    public void sortElementsOfArrayInAscending() {
        int[] elements = new int[]{0, 2, 12, -3, 55, 2, 0};
        int[] expected = new int[]{-3, 0, 0, 2, 2, 12, 55};
        ArrayUtils.bubbleSort(elements);
        Assertions.assertArrayEquals(expected,elements);

    }

    @Test
    public void countingSort(){
        int[] elements = new int[]{0, 3, 12, 3, 55, 2, 0};
        ArrayUtils.countingSort(elements);
        int [] expected = new int[]{0, 0, 2, 3, 3, 12, 55};
        Assertions.assertArrayEquals(expected,elements);

    }
    @Test
    public void countingSortSecond(){
        int[] elements = new int[]{2147483647, 2146483648};
        ArrayUtils.countingSort(elements);
        int [] expected = new int[]{2146483648,2147483647};
        Assertions.assertArrayEquals(expected,elements);

    }

    public static void checkingASortedArrayElements(Event[] actual, Event[] expected) {
        for (int i = 0; i < actual.length; i++) {
            Assertions.assertTrue(actual[i].equals(expected[i]));
        }
    }

    public static void checkingASortedArrayLinks(Event[] actual, Event[] expectedElement) {
        for (int i = 0; i < expectedElement.length; i++) {
            Assertions.assertEquals(expectedElement[i], actual[i]);
        }
    }
}


