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
    public static void countingSort(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int first =max/2;
        int second = max -first+1;

        int [] cnt = new int[first];
        int [] cnt2 = new int[second];

        for (int i = 0; i < array.length; i++) {
            cnt[array[i]]++;
        }
        int count=0;

        for (int i = 0, j = 0; i < cnt.length; i++) {
            for (int k = cnt[i]; k > 0; k--) {
                array[j++] = i;
                count++;
            }

        }
        for (int i = 0, j = count; i < cnt2.length; i++) {
            for (int k = cnt2[i]; k > 0; k--) {
                array[j++] = i;
            }

        }
    }
}