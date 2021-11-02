package utils;

import entities.Event;

public class ArrayUtils {

    /**
     * Sort elements of array .
     *
     * @param events the first term.
     * @cpu O(n ^ 2)
     * @ram O(1)
     * @return
     */
    public static void bubbleSort(Event[] events) {
        for (int i = 0; i < events.length; i++) {
            for (int j = 1; j < events.length; j++) {
                if ((events[j - 1].compareTo(events[j]) > 0)) {
                    Event t = events[j - 1];
                    events[j - 1] = events[j];
                    events[j] = t;
                }
            }
        }
    }

    /**
     * Sort elements in ascending order
     *
     * n=amount of elements
     *
     * @cpu 0(n^2)
     * @ram 0(1)
     *
     * @param array the first term
     */

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }
}