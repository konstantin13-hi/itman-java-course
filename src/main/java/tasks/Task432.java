package tasks;

public class Task432 {
    /**
     * Find prime divisors in ascending .
     *
     * @cpu O(sqrt ( n))
     * @ram O(1)
     *
     * @param x the first term
     * @return new array of prime divisors in ascending.
     */
    public static long[] calcPrimeNumbers(long x) {
        int a = 0;// variable indicates the dimension of the array с1
        int a1 = 0;//variable indicates the dimension of the array с
        long r = x;
        long a2 = (long) Math.sqrt(x);
        long[] c = new long[1000];
        if (x >= a2 && x<5) {
            return new long[]{x};
        }
        for (int i = 2; i < r; i++) {
            if (x % i == 0) {
                a++;
                c[a1] = i;
                a1++;
                for (int i1 = 0; i1<x; i1++) { //5 =1
                    if (x % i == 0) {
                        x = x / i;
                    }
                }
            }
            if (i >= a2 && a == 0) {
                return new long[]{x};
            }

        }
        long[] c1 = new long[a];
        System.arraycopy(c, 0, c1, 0, c1.length);
        return c1;
    }
}
