package utils;

import entities.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayUtilsTests {


    @Nested
    public class BubbleSort {

        @Test
        public void shouldUseBubbleSortWhenArrayIsNotEmpty() {
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
            ArrayUtils.bubbleSort(actual, new Event.EventComparator());
            checkingASortedArrayElements(actual, expected);
            checkingASortedArrayLinks(actual, expectedElement);
        }

        @Test
        public void shouldUseBubbleSortWhenArrayTwoNameSame() {
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
            ArrayUtils.bubbleSort(actual, new Event.EventComparator());
            checkingASortedArrayElements(actual, expected);
            checkingASortedArrayLinks(actual, expectedElement);
        }

        @Test
        public void shouldUseBubbleSortWhenElementsOfArrayInAscending() {
            int[] elements = new int[]{0, 2, 12, -3, 55, 2, 0};
            int[] expected = new int[]{-3, 0, 0, 2, 2, 12, 55};
            ArrayUtils.bubbleSort(elements);
            assertArrayEquals(expected, elements);
        }


        @Test
        public void shouldThrowExceptionBubbleSortWithNullElements() {
            assertThrows(NullPointerException.class, () -> ArrayUtils.bubbleSort(null, new Event.EventComparator()));
        }

        @Test
        public void shouldThrowExceptionBubbleSortWithNullComparator() {
            Integer[] elements = new Integer[]{0, 2, 12, -3, 55, 2, 0};
            assertThrows(NullPointerException.class, () -> ArrayUtils.bubbleSort(elements, null));
        }

        @Test
        public void shouldThrowExceptionBubbleSortWithNullComparatorAndNullElements() {
            assertThrows(NullPointerException.class, () -> ArrayUtils.bubbleSort(null, null));
        }


    }

    @Nested
    public class CountingSort {
        @Test
        public void sortShouldCountingSortWhenArrayIsNotEmpty() {
            int[] elements = new int[]{0, 3, 12, 3, 55, 2, 0};
            ArrayUtils.countingSort(elements);
            int[] expected = new int[]{0, 0, 2, 3, 3, 12, 55};
            assertArrayEquals(expected, elements);
        }

        @Test
        public void sortShouldCountingSortWhenBigNumbersPositive() {
            int[] elements = new int[]{2147483647, 2146483648};
            ArrayUtils.countingSort(elements);
            int[] expected = new int[]{2146483648, 2147483647};
            assertArrayEquals(expected, elements);
        }

        @Test
        public void sortShouldCountingSortWhenBigNumbersNegative() {
            int[] elements = new int[]{-2146483649, -2147483648};
            ArrayUtils.countingSort(elements);
            int[] expected = new int[]{-2147483648, -2146483649};
            assertArrayEquals(expected, elements);
        }

        @Test
        public void shouldThrowExceptionCountingSortWithNullElements() {
            assertThrows(NullPointerException.class, () -> ArrayUtils.countingSort((int[]) null));
        }

        @Test
        public void shouldCountingSortWithNullEvents() {
            assertThrows(NullPointerException.class, () -> ArrayUtils.countingSort(null));
        }
    }

    @Nested
    public class Distinct {

        @Test
        public void shouldFindOlyUniqueElementsInArrayWhenArrayIsNotEmpty() {
            int[] element = new int[]{1, 2, 5, -10, 3, 2, 1, 4};
            int[] expected = new int[]{1, 2, 5, -10, 3, 4};
            assertArrayEquals(expected, ArrayUtils.distinct(element));
        }

        @Test
        public void shouldThrowExceptionDistinctWithNullElements() {
            assertThrows(NullPointerException.class, () -> ArrayUtils.distinct(null));
        }
    }

    @Nested
    public class MostFrequent {
        @Test
        public void shouldFindTheNumberThatOccursTheMostTimesWhenArrayIsNotEmpty() {
            int[] element = new int[]{1, 2, 5, -10, 3, 2, 1, 4};
            int expected = 1;
            Assertions.assertEquals(expected, ArrayUtils.mostFrequent(element));
        }

        @Test
        public void shouldThrowExceptionMostFrequentWithNullElements() {
            assertThrows(NullPointerException.class, () -> ArrayUtils.mostFrequent(null));
        }
    }

    @Nested
    public class CountEquals {

        @Test
        public void shouldFindTheNumberOfElementsThatAreContainedSimultaneouslyInTwoArraysWhenArraysAreNotEmpty() {
            int[] elements = new int[]{2, 2, 1, 0, 10, 30, 15, 0, 2, 10};
            int[] elementsSecond = new int[]{2, 1, 0, 10, 30, 15};
            int expected = 6;
            Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
        }

        @Test
        public void shouldFindTheNumberOfElementsThatAreContainedSimultaneouslyInTwoArraysWhenInFirstArrayOneElement() {
            int[] elements = new int[]{5};
            int[] elementsSecond = new int[]{-10, 0, 0, 0, 0, 0, 1, 0, 0, 1, 2, 3, 4, 5};
            int expected = 1;
            Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
        }

        @Test
        public void shouldFindTheNumberThatAreContainedSimultaneouslyInTwoArraysWhenArraysNoContainTheSameElements() {
            int[] elements = new int[]{-1000000};
            int[] elementsSecond = new int[]{1000000};
            int expected = 0;
            Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
        }

        @Test
        public void shouldFindNumbersThatAreContainedInTwoArraysWhenBigNumbersNegativeAndPositive() {
            int[] elements = new int[]{2147483647, 2146483648, 2147483647};
            int[] elementsSecond = new int[]{-2147483648, 1, 2147483647};
            int expected = 1;
            Assertions.assertEquals(expected, ArrayUtils.countEquals(elements, elementsSecond));
        }

        @Test
        public void shouldThrowExceptionCountEqualsWithNullElements() {
            int[] elements = new int[]{2147483647, 2146483648, 2147483647};
            assertThrows(NullPointerException.class, () -> ArrayUtils.countEquals(elements, null));
            assertThrows(NullPointerException.class, () -> ArrayUtils.countEquals(null, null));
            assertThrows(NullPointerException.class, () -> ArrayUtils.countEquals(null, elements));
        }

    }

    @Nested
    public class CountingSortEvents {
        @Test
        public void sortEventsShouldCountingSortEventsWhenArrayIsNotEmpty() {
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
            ArrayUtils.countingSort(actual, event -> event.getYear() * 372 + event.getMonth() * 31 + event.getDay());
            checkingASortedArrayElements(actual, expected);
            checkingASortedArrayLinks(actual, expectedElement);
        }
    }

    @Nested
    public class Merge {

        @Test
        public void shouldMergeWithNullArraysAndComparator() {
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(null, 0, 0, null,
                            0, 0, null, 0, Comparator.comparingInt(o -> (int) o)));
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(new Integer[]{1}, 0, 0, null,
                            0, 0, null, 0, Comparator.comparingInt(o -> o)));
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(new Integer[]{1}, 0, 0, new Integer[]{1},
                            0, 0, null, 0, Comparator.comparingInt(o -> o)));
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(null, 0, 0, new Integer[]{1},
                            0, 0, null, 0, Comparator.comparingInt(o -> o)));
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(new Integer[]{1}, 0, 0, new Integer[]{1},
                            0, 0, null, 0, null));
        }

        @Test
        public void shouldMergeWithInvalidIndices() {
            Integer[] a = {1, 3, 5};
            Integer[] b = {2, 4, 6};
            Integer[] r = new Integer[6];
            Comparator<Integer> comparator = Comparator.naturalOrder();


            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.merge(a, 2, 1, b, 2, 1, r, 0, comparator));
            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.merge(a, 2, 1, b, 0, 2, r, 0, comparator));
            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.merge(a, 0, 2, b, 2, 1, r, 0, comparator));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 3, b, 0, 3, r, -1, comparator));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 3, b, -1, 3, r, -1, comparator));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, -1, 3, b, 0, 3, r, 0, comparator));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 3, b, 0, 4, r, 0, comparator));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 4, b, 0, 3, r, 0, comparator));
        }

        @Test
        public void shouldMergeWithValidInput() {
            Integer[] a = {1, 3, 5};
            Integer[] b = {2, 4, 6};
            Integer[] r = new Integer[6];

            ArrayUtils.merge(a, 0, 3, b, 0, 3, r, 0, Comparator.comparingInt(o -> (int) o));
            assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, r);
        }


    }

    @Nested
    public class MergeForIntArray {

        @Test
        public void shouldMergeWhenArraysAreNotEmpty() {
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
            assertArrayEquals(expected, r);
        }


        @Test
        public void shouldMergeWithNullArrays() {
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(null, 0, 0, null,
                            0, 0, null, 0));
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(new int[]{1}, 0, 0, null,
                            0, 0, null, 0));
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(new int[]{1}, 0, 0, new int[]{1},
                            0, 0, null, 0));
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.merge(null, 0, 0, new int[]{1},
                            0, 0, null, 0));
        }

        @Test
        public void shouldMergeWithInvalidIndices() {
            int[] a = {1, 3, 5};
            int[] b = {2, 4, 6};
            int[] r = new int[6];


            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.merge(a, 2, 1, b, 2, 1, r, 0));
            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.merge(a, 2, 1, b, 0, 2, r, 0));
            assertThrows(IllegalArgumentException.class, () -> ArrayUtils.merge(a, 0, 2, b, 2, 1, r, 0));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 3, b, 0, 3, r, -1));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 3, b, -1, 3, r, -1));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, -1, 3, b, 0, 3, r, 0));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 3, b, 0, 4, r, 0));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.merge(a, 0, 4, b, 0, 3, r, 0));
        }

        @Test
        public void shouldMergeWithValidInput() {
            int[] a = {1, 3, 5};
            int[] b = {2, 4, 6};
            int[] r = new int[6];

            ArrayUtils.merge(a, 0, 3, b, 0, 3, r, 0);
            assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, r);
        }


    }

    @Nested
    public class MergeSortWithIntegers {
        @Test
        public void shouldMergeSortWhenArrayIsNotEmpty() {
            int[] a = new int[]{4, 1, 3, 3, 1, 3, 4, 5, 1};
            ArrayUtils.mergeSort(a);
            int[] expected = new int[]{1, 1, 1, 3, 3, 3, 4, 4, 5};
            assertArrayEquals(expected, a);
        }

        @Test
        public void shouldMergeSortWhenUsingIndexesFromZeroToTheEnd() {
            int[] a = new int[]{2, 2, 1, 0, 10, 30, 15};
            ArrayUtils.mergeSort(a, 0, 7);
            int[] expected = new int[]{0, 1, 2, 2, 10, 15, 30};
            assertArrayEquals(expected, a);
        }

        @Test
        public void shouldMergeSortWhenSortAPieceInTheMiddleOfAnArray() {
            int[] a = new int[]{2, 2, 1, 0, 40, 30, 15};
            ArrayUtils.mergeSort(a, 4, 6);
            int[] expected = new int[]{2, 2, 1, 0, 30, 40, 15};
            assertArrayEquals(expected, a);
        }

        @Test
        public void shouldMergeSortSpeedTestWhenIsNotEmpty() {
            int[] a = new int[1000000];
            for (int i = 0; i < a.length; i++) {
                a[i] = 1000000 - i - 1;
            }
            int[] b = new int[1000000];
            for (int i = 0; i < a.length; i++) {
                b[i] = i;
            }
            ArrayUtils.mergeSort(a);
            assertArrayEquals(b, a);
        }

        @Test
        public void shouldThrowExceptionMergeSortWithNullArray() {
            assertThrows(NullPointerException.class, () -> ArrayUtils.mergeSort(null, 0, 5));
        }

        @Test
        public void shouldThrowExceptionMergeSortWithInvalidFromIndex() {
            int[] array = {1, 2, 3, 4, 5};
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.mergeSort(array, -1, 3));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.mergeSort(array, 5, 3));
        }

        @Test
        public void shouldThrowExceptionMergeSortWithInvalidToIndex() {
            int[] array = {1, 2, 3, 4, 5};
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.mergeSort(array, 0, 6));
            assertThrows(IndexOutOfBoundsException.class, () -> ArrayUtils.mergeSort(array, 0, -1));
        }
    }

    @Nested
    public class MergeSort {


        @Test
        public void shouldMergeSortEventsWhenArrayIsNotEmpty() {
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
            ArrayUtils.mergeSort(actual, new Event.EventComparator());
            checkingASortedArrayElements(actual, expected);
            checkingASortedArrayLinks(actual, expectedElement);
        }

        @Test
        public void shouldMergeSortWhenArrayIsNotEmptySortAPieceInTheMiddleOfAnArrayObjects() {
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
            ArrayUtils.mergeSort(actual, new Event.EventComparator(), 1, 3);
            checkingASortedArrayElements(actual, expected);
            checkingASortedArrayLinks(actual, expectedElement);
        }


        @Test
        public void shouldThrowExceptionMergeSortWithNullArray() {
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.mergeSort(null,
                            Comparator.comparingInt(o -> (int) o), 0, 5));
        }

        @Test
        public void shouldThrowExceptionMergeSortWithNullComparator() {
            Integer[] array = new Integer[]{3, 2, 1};
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.mergeSort(array, null, 0, 5));
        }

        @Test
        public void shouldThrowExceptionMergeSortWithNullComparatorAndNullElements() {
            assertThrows(NullPointerException.class,
                    () -> ArrayUtils.mergeSort(null, null, 0, 5));
        }

        @Test
        public void shouldThrowExceptionMergeSortWithInvalidFromIndex() {
            Integer[] array = {1, 2, 3, 4, 5};
            assertThrows(IndexOutOfBoundsException.class,
                    () -> ArrayUtils.mergeSort(array,
                            Comparator.comparingInt(o -> o), -1, 3));
            assertThrows(IndexOutOfBoundsException.class,
                    () -> ArrayUtils.mergeSort(array,
                            Comparator.comparingInt(o -> o), 6, 3));
        }

        @Test
        public void shouldThrowExceptionMergeSortWithInvalidToIndex() {
            Integer[] array = {1, 2, 3, 4, 5};
            assertThrows(IndexOutOfBoundsException.class,
                    () -> ArrayUtils.mergeSort(array,
                            Comparator.comparingInt(o -> o), 0, 6));
            assertThrows(IndexOutOfBoundsException.class,
                    () -> ArrayUtils.mergeSort(array,
                            Comparator.comparingInt(o -> o), 0, -1));
        }
    }

    private static void checkingASortedArrayElements(Event[] actual, Event[] expected) {
        for (int i = 0; i < actual.length; i++) {
            Assertions.assertEquals(actual[i], expected[i]);
        }
    }

    private static void checkingASortedArrayLinks(Event[] actual, Event[] expectedElement) {
        for (int i = 0; i < expectedElement.length; i++) {
            Assertions.assertEquals(expectedElement[i], actual[i]);
        }
    }
}


