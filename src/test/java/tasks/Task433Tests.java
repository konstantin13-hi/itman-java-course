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
}
