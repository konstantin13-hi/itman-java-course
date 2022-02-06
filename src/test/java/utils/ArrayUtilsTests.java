package utils;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

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
        Assertions.assertArrayEquals(expected, elements);

    }

    @Test
    public void countingSort() {
        int[] elements = new int[]{0, 3, 12, 3, 55, 2, 0};
        ArrayUtils.countingSort(elements);
        int[] expected = new int[]{0, 0, 2, 3, 3, 12, 55};
        Assertions.assertArrayEquals(expected, elements);

    }

    @Test
    public void countingSortWhenBigNumbersPositive() {
        int[] elements = new int[]{2147483647, 2146483648};
        ArrayUtils.countingSort(elements);
        int[] expected = new int[]{2146483648, 2147483647};
        Assertions.assertArrayEquals(expected, elements);

    }

    @Test
    public void countingSortWhenBigNumbersNegative() {
        int[] elements = new int[]{-2146483649, -2147483648};
        ArrayUtils.countingSort(elements);
        int[] expected = new int[]{-2147483648, -2146483649};
        Assertions.assertArrayEquals(expected, elements);

    }

    @Test
    public void distinct() {
        int[] element = new int[]{1, 2, 5, -10, 3, 2, 1, 4};
        int[] expected = new int[]{1, 2, 5, -10, 3, 4};
        Assertions.assertArrayEquals(expected, ArrayUtils.distinct(element));
    }

    @Test
    public void mostFrequent() {
        int[] element = new int[]{1, 2, 5, -10, 3, 2, 1, 4};
        int expected = 1;
        Assertions.assertEquals(expected, ArrayUtils.mostFrequent(element));
    }

    @Test
    public void countEquals() {
        int[] elements = new int[]{2, 2, 1, 0, 10, 30, 15, 0, 2, 10};
        int[] elementsSecond = new int[]{2, 1, 0, 10, 30, 15};
        int expected = 6;
        Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
    }

    @Test
    public void countEqualsWhenInFirstArrayOneElement() {
        int[] elements = new int[]{5};
        int[] elementsSecond = new int[]{-10, 0, 0, 0, 0, 0, 1, 0, 0, 1, 2, 3, 4, 5};
        int expected = 1;
        Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
    }

    @Test
    public void countEqualsWhenArraysDoNotContainTheSameElements() {
        int[] elements = new int[]{-1000000};
        int[] elementsSecond = new int[]{1000000};
        int expected = 0;
        Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
    }

    @Test
    public void countEqualsWhenBigNumbersNegativeAndPositive() {
        int[] elements = new int[]{2147483647, 2146483648, 2147483647};
        int[] elementsSecond = new int[]{-2147483648, 1, 2147483647};
        int expected = 1;
        Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
    }

    @Test
    public void countingSortEvents() {
        Event[] actual = new Event[]{
                new Event(2020, 10, 25, "A"),
                new Event(2020, 5, 20, "B"),
                new Event(2020, 7, 15, "C"),
                new Event(2021, 1, 1, "D"),
                new Event(2020, 7, 15, "E")
        };
        Event[] expectedElement = new Event[actual.length];
        expectedElement[0] = actual[1];
        expectedElement[1] = actual[2];
        expectedElement[2] = actual[4];
        expectedElement[3] = actual[0];
        expectedElement[4] = actual[3];
        Event[] expected = new Event[]{
                new Event(2020, 5, 20, "B"),
                new Event(2020, 7, 15, "C"),
                new Event(2020, 7, 15, "E"),
                new Event(2020, 10, 25, "A"),
                new Event(2021, 1, 1, "D")
        };
        ArrayUtils.countingSort(actual);
        checkingASortedArrayElements(actual, expected);
        checkingASortedArrayLinks(actual, expectedElement);
    }

    @Test
    public void merge() {
        int[] a = new int[]{100, 2, 4, 5, -7};
        int aFrom = 1;
        int aTo = 4;
        int[] b = new int[]{-7, 2, 3};
        int bFrom = 1;
        int bTo = 3;
        int[] r = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        int rFrom = 2;
        ArrayUtils.merge(a, aFrom, aTo, b, bFrom, bTo, r, rFrom);
        int[] expected = new int[]{1, 1, 2, 2, 3, 4, 5, 1};
        Assertions.assertArrayEquals(expected, r);
    }

    @Test
    public void mergeSort() {
        int[] a = new int[]{4, 1, 3, 3, 1, 3, 4, 5, 1};
        ArrayUtils.mergeSort(a);
        int[] expected = new int[]{1, 1, 1, 3, 3, 3, 4, 4, 5};
        Assertions.assertArrayEquals(expected, a);
    }

    @Test
    public void mergeSortUsingIndexesFromZeroToTheEnd() {
        int[] a = new int[]{2, 2, 1, 0, 10, 30, 15};
        ArrayUtils.mergeSort(a, 0, 7);
        int[] expected = new int[]{0, 1, 2, 2, 10, 15, 30};
        Assertions.assertArrayEquals(expected, a);
    }

    @Test
    public void mergeSortWhenSortAPieceInTheMiddleOfAnArray() {
        int[] a = new int[]{2, 2, 1, 0, 40, 30, 15};
        ArrayUtils.mergeSort(a, 4, 6);
        int[] expected = new int[]{2, 2, 1, 0, 30, 40, 15};
        Assertions.assertArrayEquals(expected, a);
    }

    @Test
    public void mergeSortSpeedTest() {
        int[] a = new int[1000000];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1000000 - i - 1;
        }
        int[] b = new int[1000000];
        for (int i = 0; i < a.length; i++) {
            b[i] = i;
        }
        ArrayUtils.mergeSort(a);
        Assertions.assertArrayEquals(b, a);

    }

    @Test
    public void mergeSortWithObjects() {
        Event[] actual = new Event[]{
                new Event(10, 0, 0, "Day of City in Gomel"),
                new Event(9, 0, 0, "Day of City in Minsk"),
                new Event(7, 0, 0, "Day of City in Vitebsk"),
                new Event(8, 0, 0, "Day of City in Borisow"),
                new Event(11, 0, 0, "Day of City in Minsk")
        };
        Event[] expectedElement = new Event[actual.length];
        expectedElement[0] = actual[2];
        expectedElement[1] = actual[3];
        expectedElement[2] = actual[1];
        expectedElement[3] = actual[0];
        expectedElement[4] = actual[4];
        Event[] expected = new Event[]{
                new Event(7, 0, 0, "Day of City in Vitebsk"),
                new Event(8, 0, 0, "Day of City in Borisow"),
                new Event(9, 0, 0, "Day of City in Minsk"),
                new Event(10, 0, 0, "Day of City in Gomel"),
                new Event(11, 0, 0, "Day of City in Minsk")
        };

        ArrayUtils.mergeSort(actual);
        checkingASortedArrayElements(actual, expected);
        checkingASortedArrayLinks(actual, expectedElement);
    }

    @Test
    public void mergeSortWhenSortAPieceInTheMiddleOfAnArrayObjects() {
        Event[] actual = new Event[]{
                new Event(10, 0, 0, "Day of City in Gomel"),
                new Event(9, 0, 0, "Day of City in Minsk"),
                new Event(7, 0, 0, "Day of City in Vitebsk"),
                new Event(8, 0, 0, "Day of City in Borisow"),
                new Event(11, 0, 0, "Day of City in Minsk")
        };
        Event[] expectedElement = new Event[actual.length];
        expectedElement[0] = actual[0];
        expectedElement[1] = actual[2];
        expectedElement[2] = actual[1];
        expectedElement[3] = actual[3];
        expectedElement[4] = actual[4];
        Event[] expected = new Event[]{
                new Event(10, 0, 0, "Day of City in Gomel"),
                new Event(7, 0, 0, "Day of City in Vitebsk"),
                new Event(9, 0, 0, "Day of City in Minsk"),
                new Event(8, 0, 0, "Day of City in Borisow"),
                new Event(11, 0, 0, "Day of City in Minsk")
        };

        ArrayUtils.mergeSort(actual, 1, 3);
        checkingASortedArrayElements(actual, expected);
        checkingASortedArrayLinks(actual, expectedElement);
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


