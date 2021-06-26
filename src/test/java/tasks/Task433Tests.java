package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task433Tests {
    @Test
    public void gcdwith28and42() {
        long x = 28;
        long y = 42;
        long a = Task433.gcd(x, y);
        Assertions.assertEquals(14, a);


    }

    @Test
    public void gcdwith7and49() {
        long x = 7;
        long y = 49;
        long a = Task433.gcd(x, y);
        Assertions.assertEquals(7, a);


    }

    @Test
    public void gcdwith91351260and375320946() {
        long x = 91351260;
        long y = 375320946;
        long a = Task433.gcd(x, y);
        Assertions.assertEquals(78078, a);

    }

    @Test
    public void gcdwith13and21() {
        long x = 13;
        long y = 21;
        long a = Task433.gcd(x, y);
        Assertions.assertEquals(1, a);

    }

    @Test
    public void gcdwith1and10e16() {
        long x = 1;
        long y = (long) 1e16;
        long a = Task433.gcd(x, y);
        Assertions.assertEquals(1, a);

    }
}
