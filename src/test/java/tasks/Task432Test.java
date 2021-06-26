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
    public void calcPrimeNumbersmax() {
        long x1 = 999999797;
        long[] expected1 = new long[]{999999797};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));

    }

    @Test
    public void calcPrimeNumbersmiddle() {
        long x1 = 899;
        long[] expected1 = new long[]{29, 31};
        Task432.calcPrimeNumbers(x1);
        Assertions.assertArrayEquals(expected1, Task432.calcPrimeNumbers(x1));
    }
}
