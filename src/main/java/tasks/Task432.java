package tasks;

public class Task432 {
    /**
     * Find prime divisors in ascending .
     *
     * @param x the first term
     * @return new array of prime divisors in ascending.
     * @cpu O(sqrt(n))
     * @ram O(1)
     */
    public static long[] calcPrimeNumbers(long x) {
        long sqrtX = (long) Math.sqrt(x);
        long[] divisors = new long[1000];
        int nextPosition = 0;
        for (int i = 2; i <= sqrtX; i++) {
            if (x % i == 0) {
                while (x % i == 0) {
                    x = x / i;
                }
                divisors[nextPosition] = i;
                nextPosition++;
            }
        }
        if (x != 1) {
            divisors[nextPosition] = x;
            nextPosition++;
        }
        long[] result = new long[nextPosition];
        System.arraycopy(divisors, 0, result, 0, result.length);
        return result;
    }
}
