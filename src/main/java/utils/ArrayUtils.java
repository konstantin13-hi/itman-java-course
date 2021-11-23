package utils;

import entities.Event;

public class ArrayUtils {

    /**
     * Sort elements of array .
     *
     * @param events the first term.
     * @return
     * @cpu O(n ^ 2)
     * @ram O(1)
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
     * <p>
     * n=amount of elements
     *
     * @param array the first term
     * @cpu 0(n ^ 2)
     * @ram 0(1)
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
        if (array.length != 0) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
                if (min > array[i]) {
                    min = array[i];
                }
            }
            int dif = max - min;
            int[] cnt = new int[dif + 1];
            for (int i = 0; i < array.length; i++) {
                cnt[array[i] - min]++;
            }

            for (int i = 0, j = 0; i < cnt.length; i++) {
                for (int k = cnt[i]; k > 0; k--) {
                    array[j++] = i + min;
                }
            }
        }
    }

    public static int[] distinct(int[] array) {
        if (array.length != 0) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
                if (min > array[i]) {
                    min = array[i];
                }
            }
            int dif = max - min;
            int[] cnt = new int[dif + 1];
            for (int i = 0; i < array.length; i++) {
                cnt[array[i] - min]++;
            }
            int sum = 0;
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] >= 1) {
                    sum++;
                }
            }
            // 1 0 0 0 0 0 0 0 0 0 2 2 1 1 1 0
            // 1, 2, 5, -10, 3, 2, 1, 4
            // 1, 2, 5, -10, 3, 4
            int[] newArray = new int[sum];
            for (int k = 0,l = 0; k < array.length; k++) {
                if (l==newArray.length){
                    break;
                }
                int count =0;
                for (int i = 0; i < newArray.length; i++) {
                    if (array[k] != newArray[i]) {

                        count++;
                    }
                    if (count==newArray.length){
                    newArray[l++] = array[k];
                   }
                }



            }
            return newArray;
        }
        return array;

    }
}










