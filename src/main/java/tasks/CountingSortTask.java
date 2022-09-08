package tasks;

public class CountingSortTask {

    /**
     * It counts how many times each element occurs.
     * m=the maximum element
     * n=amount of elements
     *
     * @param array the first term
     * @return array
     * @cpu O(n)
     * @ram O(m)
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
        for (int j = 0; j < array.length; j++) {
            count[array[j]]++;
        }

        return count;
    }

    /**
     * Fetches elements in sorted order.
     * n=amount of the elements
     * k=sum of elements
     *
     * @param array the first term
     * @return sorted array
     * @cpu O(n + k)
     * @ram О(k)
     */
    // 0 1 0 0 6 0 0 0 10
    public static int[] restore(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        int[] restore = new int[sum];
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
     * Sorting elements of array.
     * m=the maximum element
     * n=amount of elements
     *
     * @param array the first term
     * @cpu O(n + m)
     * @ram 0(n + m)
     */
    public static void sort(int[] array) {
        int[] restore = count(array);
        int[] sort = restore(restore);
        for (int i = 0; i < array.length; i++) {
            array[i] = sort[i];
        }
    }
}
