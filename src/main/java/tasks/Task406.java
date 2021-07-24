package tasks;

public class Task406 {
    /**
     * Find second max element of array .
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param array the first term
     * @return the second max element of array .
     */
    public static int findSecondMax(int[] array) {
        int a = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                a = i;
            }
        }
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (max1 < array[i] && i != a) {
                max1 = array[i];

            }
        }
        return max1;
    }


}
