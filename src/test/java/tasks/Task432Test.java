package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task432Test {

    @Test
    public void calcPrimeNumbers() {
        long actual = 360;
        long[] expected = new long[]{2, 3, 5};

        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(actual));

    }

    @Test
    public void calcPrimeNumbersMax() {
        long actual = 999999797;
        long[] expected = new long[]{999999797};
        Task432.calcPrimeNumbers(actual);
        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(actual));

    }

    @Test
    public void calcPrimeNumbersMiddle() {
        long actual = 899;
        long[] expected = new long[]{29, 31};
        Task432.calcPrimeNumbers(actual);
        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(actual));
    }

    @Test
    public void calcPrimeNumbersMiddleMin() {
        long actual = 2;
        long[] expected = new long[]{2};
        Task432.calcPrimeNumbers(actual);
        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(actual));
    }

    @Test
    public void calcPrimeNumbersMiddleMinWith9() {
        long actual = 9;
        long[] expected = new long[]{3};
        Task432.calcPrimeNumbers(actual);
        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(actual));
    }

    @Test
    public void calcPrimeNumbersMiddleMinWith4() {
        long actual = 4;
        long[] expected = new long[]{2};
        Task432.calcPrimeNumbers(actual);
        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(actual));
    }

    @Test
    public void calcPrimeNumbersMiddleMinWith10e16() {
        long actual = (long) 1e16;
        long[] expected = new long[]{2, 5};
        Task432.calcPrimeNumbers(actual);
        Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(actual));

    }
}
