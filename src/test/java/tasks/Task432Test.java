package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task432Test {
    @Test
    public void calcPrimeNumbers() {
        long x = 360;
        long[] expected = new long[]{2, 3, 5};

        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));

    }

    @Test
    public void calcPrimeNumbersMax() {
        long x1 = 999999797;
        long[] expected1 = new long[]{999999797};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));

    }

    @Test
    public void calcPrimeNumbersMiddle() {
        long x1 = 899;
        long[] expected1 = new long[]{29, 31};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));
    }

    @Test
    public void calcPrimeNumbersMiddleMin() {
        long x1 = 2;
        long[] expected1 = new long[]{2};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));
    }

    @Test
    public void calcPrimeNumbersMiddleMinWith9() {
        long x1 = 9;
        long[] expected1 = new long[]{3};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));
    }

    @Test
    public void calcPrimeNumbersMiddleMinWith4() {
        long x1 = 4;
        long[] expected1 = new long[]{2};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));
    }
    @Test
    public void calcPrimeNumbersMiddleMinWith10e16() {
        long x1 = (long) 1e16;;
        long[] expected1 = new long[]{2,5};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));

    }
}
