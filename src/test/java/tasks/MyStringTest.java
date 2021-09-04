package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MyStringTest {
    @Test
    public void toString1(){
        char[]chars=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString a = new MyString(chars);
        Assertions.assertEquals("Hello",a.toString());



    }

    @Test
    public void charAt(){

        char[]chars=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString a = new MyString(chars);

        Assertions.assertEquals('H',a.charAt(0));



    }

}