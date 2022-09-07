package tasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class Task407Tests {

    @Nested

    public class SortMatrixRowsDesc {

        @Test
        public void shouldSortMatrixRowsDescWhenMatrixIsNotEmpty() {
            int[][] a = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
            int[][] b = new int[][]{{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
            Task407.sortMatrixRowsDesc(a);
            Assertions.assertArrayEquals(b, a);
        }

        @Test
        public void shouldSortMatrixRowsDescWhenTwoRowsSame() {
            int[][] a = new int[][]{{1, 1, 1}, {1, 1, 1}, {7, 8, 9}};
            int[][] b = new int[][]{{7, 8, 9}, {1, 1, 1}, {1, 1, 1}};
            Task407.sortMatrixRowsDesc(a);
            Assertions.assertArrayEquals(b, a);
        }

        @Test
        public void shouldSortMatrixRowsDescWhenThreePairs() {
            int[][] a = new int[][]{{1, 1, 1}, {199, 199, 199}, {7, 8, 9}, {1, 1, 1}, {199, 199, 199}, {7, 8, 9}};
            int[][] b = new int[][]{{199, 199, 199}, {199, 199, 199}, {7, 8, 9}, {7, 8, 9}, {1, 1, 1}, {1, 1, 1}};
            Task407.sortMatrixRowsDesc(a);
            Assertions.assertArrayEquals(b, a);
        }
    }
}