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

    @Test
    public void compareTo(){
        char[]chars=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString a = new MyString(chars);
        char[]ch=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString b = new MyString(chars);
        Assertions.assertEquals(0,a.compareTo(b));
    }

    @Test
    public void compareTo12(){
        char[]chars=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString a = new MyString(chars);
        char[]ch=new char[]{'H', 'e', 'l', 'l'};
        MyString b = new MyString(ch);
        Assertions.assertEquals(1,a.compareTo(b));
    }

    @Test
    public void compareTo1(){
        char[]chars=new char[]{'H', 'e'};
        MyString a = new MyString(chars);
        char[]ch=new char[]{'H', 'e', 'l', 'l'};
        MyString b = new MyString(ch);
        Assertions.assertEquals(-1,a.compareTo(b));
    }

    @Test
    public void equals(){
        char[]chars=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString a = new MyString(chars);
        char[]ch=new char[]{'H', 'e', 'l', 'l'};
        MyString b = new MyString(ch);
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void equals1(){
        char[]chars=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString a = new MyString(chars);
        char[]ch=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString b = new MyString(ch);
        Assertions.assertTrue(a.equals(b));
    }

    @Test
    public void equals132(){
        char[]chars=new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString a = new MyString(chars);
        char[]ch=new char[]{'H', 'e', 'l', 'l', 'D'};
        MyString b = new MyString(ch);
        Assertions.assertFalse(a.equals(b));
    }

    @Test
    public void toCompare(){
        char[]chars=new char[]{'t', 'e', 's', 't' };
        MyString a = new MyString(chars);
        char[]ch=new char[]{'t', 'e', 's', 'z'};
        MyString b = new MyString(ch);
        Assertions.assertEquals(-1,a.compareTo(b));
    }

    @Test
    public void plus(){
        char[]chars=new char[]{'t', 'e', 's', 't' };
        MyString a = new MyString(chars);
        char[]ch=new char[]{'t', 'e', 's', 'z'};
        MyString b = new MyString(ch);
        Assertions.assertEquals("testesz",MyString.plus(a,b).toString());
    }

}