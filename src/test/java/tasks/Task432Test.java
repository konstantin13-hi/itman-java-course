package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task432Test {
    @Nested
    public class CalcPrimeNumbers {
        @Test
        public void shouldCalcPrimeNumbersWhenFirstPrimeIsTwo() {
            long x = 360;
            long[] expected = new long[]{2, 3, 5};
            Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));
        }

        @Test
        public void shouldCalcPrimeNumbersMaxWhenNumberIsMax() {
            long x = 999999797;
            long[] expected = new long[]{999999797};
            Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));
        }

        @Test
        public void shouldCalcPrimeNumbersWhenNumberIs899() {
            long x = 899;
            long[] expected = new long[]{29, 31};
            Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));
        }

        @Test
        public void shouldCalcPrimeNumbersWhenMinNumber() {
            long x = 2;
            long[] expected = new long[]{2};
            Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));
        }

        @Test
        public void shouldCalcPrimeNumbersWhenNumberIs9() {
            long x = 9;
            long[] expected = new long[]{3};
            Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));
        }

        @Test
        public void shouldCalcPrimeNumbersWhenNumberIs4() {
            long x = 4;
            long[] expected = new long[]{2};
            Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));
        }

        @Test
        public void shouldCalcPrimeNumbersWhenNumberIs10e16() {
            long x = (long) 1e16;
            long[] expected = new long[]{2, 5};
            Assertions.assertArrayEquals(expected, Task432.calcPrimeNumbers(x));
        }
    }
}