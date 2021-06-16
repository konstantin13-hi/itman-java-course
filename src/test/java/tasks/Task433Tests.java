package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task433Tests {
    @Test
    public void gcd(){
        long x=28;
        long y=42;
        long a=Task433.gcd(x,y);
        Assertions.assertEquals(14, a);


    }
    @Test
    public void gcd1(){
        long x=7;
        long y=49;
        long a=Task433.gcd(x,y);
        Assertions.assertEquals(7, a);


    }
    @Test
    public void gcd2(){
        long x=91351260;
        long y=375320946;
        long a=Task433.gcd(x,y);
        Assertions.assertEquals(78078, a);


    }
}
