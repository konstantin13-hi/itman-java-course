package tasks;

public class Task497 {

    /**
     * Merge two sorted arrays
     *
     * @cpu O(n+m)
     * @ram O(n+m)
     *
     * @param a the first term
     * @param b the second term
     *
     * @return sorted array containing elements from two sorted arrays
     */
    public static int[] merge(int[] a, int[] b) {
        int[] twoArrays = new int[a.length + b.length];
        for (int i = 0, j = 0, k = 0; j < twoArrays.length; j++) {
            if (i < a.length && k < b.length) {
                if (a[i] == b[k]) {
                    twoArrays[j++] = a[i++];
                    twoArrays[j] = b[k++];
                } else if (a[i] < b[k]) {
                    twoArrays[j] = a[i++];
                } else {
                    twoArrays[j] = b[k++];
                }
            } else {
                if (i == a.length || k == b.length) {
                    if (i == a.length) {
                        twoArrays[j] = b[k++];
                    } else {
                        twoArrays[j] = a[i++];
                    }
                }

            }
        }
        return twoArrays;
    }
}

