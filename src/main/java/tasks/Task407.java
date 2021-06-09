package tasks;

public class Task407 {
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
                    //  for (int j2=0; j2 < matrix[j].length; j2++) {
                    //       int t1 =matrix[j][j2];
                    //      matrix[j][j2]=matrix[j-1][j2];
                    //       matrix[j-1][j2]=t1;
                    //  }

                }

            }
        }
    }
}