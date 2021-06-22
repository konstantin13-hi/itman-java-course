package tasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class Task407Tests {
    @Test
    public void sortMatrixRowsDesc() {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] b = a[2];//
        Task407.sortMatrixRowsDesc(a);
        Assertions.assertSame(b, a[0]);

    }

    @Test
    public void sortMatrixRowsDesc1() {
        int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = new int[][]{{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};//

        Task407.sortMatrixRowsDesc(a);


        Assertions.assertArrayEquals(b, a);

    }

}