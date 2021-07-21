package tasks;

public class Task432 {
    /**
     * Find prime divisors in ascending .
     *
     * @param x the first term
     * @return new array of prime divisors in ascending.
     * @cpu O(sqrt ( n))
     * @ram O(1)
     */
    public static long[] calcPrimeNumbers(long x) {
        int countArrayC1Elements = 0;// variable indicates the dimension of the array с1
        int countArrayCElements = 0;//variable indicates the dimension of the array с
        long SqrtTermX = (long) Math.sqrt(x);
        long duplicateForCycle = x;
        long[] ArrayC = new long[1000];
        if (x < 5) {
            return new long[]{x};
        }
        for (int i = 2; i < duplicateForCycle; i++) {
            if (x % i == 0) {
                countArrayC1Elements++;
                ArrayC[countArrayCElements] = i;
                countArrayCElements++;
                for (int i1 = 0; i1 < x; i1++) { //5 =1
                    if (x % i == 0) {
                        x = x / i;
                    }
                }
            }
            if (i >= SqrtTermX && countArrayC1Elements == 0) {
                return new long[]{x};
            }

        }
        long[] c1 = new long[countArrayC1Elements];
        System.arraycopy(ArrayC, 0, c1, 0, c1.length);
        return c1;
    }
}
