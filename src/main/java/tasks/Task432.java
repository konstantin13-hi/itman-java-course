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
        int divisionsNumber = 0;
        for (int i = 2; i <= sqrtX + sqrtX; i++) {
            if (x % i == 0) {
                if (divisionsNumber == 0) {
                    divisors[nextPosition] = i;
                    nextPosition++;
                    divisionsNumber++;
                }
                x = x / i;
                i--;
            } else {
                divisionsNumber = 0;
            }
            if (i >= sqrtX && nextPosition == 0) {
                divisors[0] = x;
                nextPosition++;
            }

        }
        long[] result = new long[nextPosition];
        System.arraycopy(divisors, 0, result, 0, result.length);
        return result;
    }
}
