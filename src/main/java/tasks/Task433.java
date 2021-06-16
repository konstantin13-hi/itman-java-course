package tasks;

public class Task433 {
    public static long gcd(long x, long y) {

        if (x == 0)
            return y;

        while (y != 0) {
            if (x > y)
                x = x - y;
            else
                y = y - x;
        }

        return x;


    }
}
