package tasks;

public class Task407 {

    /**
     * Sort rows of array .
     *
     * @param matrix the first term
     * @cpu O(n * m + n ^ 2)
     * @ram O(n)
     */
    public static void sortMatrixRowsDesc(int[][] matrix) {
        int[] a = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                a[i] += matrix[i][j];
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length; j++) {
                if (a[j - 1] < a[j]) {
                    int t = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = t;
                    int[] t2 = matrix[j];
                    matrix[j] = matrix[j - 1];
                    matrix[j - 1] = t2;
                }
            }
        }
    }
}