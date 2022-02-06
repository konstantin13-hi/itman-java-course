package tasks;

public class CountingSortTask {

    /**
     * It counts how many times each element occurs
     *
     * m=the maximum element
     * n=amount of elements
     *
     * @cpu O(m*n)
     * @ram O(m)
     *
     * @param array
     * @return
     */
    public static int[] count(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] count = new int[max + 1];
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    count[i]++;
                }
            }
        }
        return count;
    }

    /**
     *Fetches elements in sorted order
     *
     * n=amount of the elements
     * m= the greatest number of element
     * k=amount of elements that occur at least once
     *
     * @cpu O(n*m)
     * @ram О(k)
     *
     * @param array the first term
     *
     * @return sorted array
     */
    public static int[] restore(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max += array[i];
        }
        int[] restore = new int[max];
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i]; j++) {
                restore[length] = i;
                length++;
            }
        }
        return restore;

    }

    /**
     * Sorting elements of array
     *
     * @cpu O(n)
     * @ram 0(m)
     *
     * @param array the first term
     */
    public static void sort(int[] array) {
        int[] sort = restore(count(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = sort[i];
        }
    }
}
