package tasks;

public class Task433 {

    /**
     * Find the greatest common divisor of two elements .
     *
     * @param x the first term
     * @param y the second term
     * @return the greatest common divisor .
     * @cpu O(log ( y)+log(y))
     * @ram O(1)
     */
    public static long gcd(long x, long y) {
        while (y != 0) {
            long tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}
