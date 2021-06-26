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
        int a = 0;
        int a1 = 0;
        long[] c = new long[1000];
        for (int i = 2; i <= Math.sqrt(x); i++) { //5 = 2 3 4 5 // 6 = 2 3 // 7= 2 3 4 5 6 7 //8 =2 /9=2,3 10=2,3,
            if (x % i == 0) {
                a++;
                c[a1] = i;
                a1++;
                for (int i1 = 0; true; i1++) { //5 =1
                    if (x % i == 0) {
                        x = x / i;
                    } else {
                        break;
                    }

                }
            }
            if (x < i) {
                break;
            }
            if (i >= Math.sqrt(x) & a == 0) {
                return new long[]{x};
            }
        }
        long[] c1 = new long[a];
        System.arraycopy(c, 0, c1, 0, c1.length);
        return c1;


    }
}
