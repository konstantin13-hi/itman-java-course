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
        int numberPrimeCheck = 0;
        int count = 2;
        if (x == 2 || x == 3) {
            divisors[0] = x;
        }
        for (int i = 2; i <= sqrtX; i++, count++) {
            if (x % i == 0) {
                numberPrimeCheck++;
                while (x % i == 0) {
                    x = x / i;
                }
                divisors[nextPosition] = i;
                nextPosition++;
                if (i == sqrtX && x != 1 && x != i) {
                    divisors[nextPosition] = x;
                    nextPosition++;
                }
            }
        }
        if (count >= sqrtX && numberPrimeCheck == 0) {
            divisors[0] = x;
            nextPosition++;
        }
        long[] result = new long[nextPosition];
        System.arraycopy(divisors, 0, result, 0, result.length);
        return result;
    }
}
