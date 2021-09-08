package tasks.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderTest {
    @Test
    public void string(){
        StringBuilder s = new StringBuilder();
                
                s.append(2.0);
                s.append(" + ");
                s.append(2);
                s.append(" = ");
                s.append(4);
               Assertions.assertEquals("2.0 + 2 = 4",s.toString());

    }

}