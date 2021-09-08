package tasks.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderTest {
    @Test
    public void string(){
        StringBuilder S =new StringBuilder();
        StringBuilder s = new StringBuilder();


                s.append(2.0);
                s.append(" + ");
                s.append(2);
                s.append(" = ");
                s.append(4);
               Assertions.assertEquals("2.0 + 2 = 4",s.toString());

    }

    @Test
    public void string1  (){

        StringBuilder s = new StringBuilder(1);


        s.append("itman");

        Assertions.assertEquals("itman",s.toString());
        Assertions.assertEquals(5,s.toString().length());



    }
    @Test
    public void string15  (){

        StringBuilder s = new StringBuilder(2);


        s.append("itman");
        s.append("ff");
        s.append("lol");

        Assertions.assertEquals("itmanfflol",s.toString());





    }

}