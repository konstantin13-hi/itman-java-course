package tasks;

import utils.ArrayUtils;

public class Task510 {

    /**
     * Finds the minimum element that occurs more often
     * n=array length
     *
     * @param array the first term
     * @return result containing minimum element that occurs more often
     * @cpu O(nlog ( n))
     * @ram O(n)
     */
    public static int mostFrequent(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] t = new int[array.length];
        System.arraycopy(array, 0, t, 0, array.length);
        ArrayUtils.mergeSort(t);
        int element = t[array.length - 1];
        int count = 0;
        int result = element;
        int resultCount = 0;
        for (int i = t.length - 1; 0 <= i; i--) {
            if (t[i] == element) {
                count++;
            } else {
                element = t[i];
                result = count >= resultCount ? t[i + 1] : result;
                resultCount = Math.max(count, resultCount);
                count = 1;
            }
        }
        if (count >= resultCount) {
            result = t[0];
        }
        return result;
    }

}