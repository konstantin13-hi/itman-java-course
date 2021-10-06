package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MyStringTest {
    @Test
    public void testToString() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myString = new MyString(chars);
        Assertions.assertEquals("Hello", myString.toString());
    }

    @Test
    public void charAt() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myString = new MyString(chars);
        Assertions.assertEquals('H', myString.charAt(0));
    }

    @Test
    public void compareTo() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertEquals(0, myString.compareTo(myStringSecond));
    }

    @Test
    public void compareToWhenFirstLengthLonger() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'H', 'e', 'l', 'l'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertEquals(1, myString.compareTo(myStringSecond));
    }

    @Test
    public void compareToWhenSecondLengthLonger() {
        char[] chars = new char[]{'H', 'e'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'H', 'e', 'l', 'l'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertEquals(-1, myString.compareTo(myStringSecond));
    }

    @Test
    public void equals() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'H', 'e', 'l', 'l'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertFalse(myString.equals(myStringSecond));
    }

    @Test
    public void equalsWhenTwoSameLengthsAndElements() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertTrue(myString.equals(myStringSecond));
    }

    @Test
    public void equalsWhenTwoSameLengthsButDifferentElements() {
        char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'H', 'e', 'l', 'l', 'D'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertFalse(myString.equals(myStringSecond));
    }

    @Test
    public void toCompare() {
        char[] chars = new char[]{'t', 'e', 's', 't'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'t', 'e', 's', 'z'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertEquals(-1, myString.compareTo(myStringSecond));
    }

    @Test
    public void plus() {
        char[] chars = new char[]{'t', 'e', 's', 't'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'t', 'e', 's', 'z'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertEquals("testtesz", MyString.plus(myString, myStringSecond).toString());
    }

    @Test
    public void plusSecondTest() {
        char[] chars = new char[]{'h', 'i'};
        MyString myString = new MyString(chars);
        char[] charsSecond = new char[]{'w', 'o', 'r', 'l', 'd'};
        MyString myStringSecond = new MyString(charsSecond);
        Assertions.assertEquals("hiworld", MyString.plus(myString, myStringSecond).toString());
    }
}