package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MyStringTest {
    @Nested
    public class ToString {
        @Test
        public void toStringShouldReturnsStringWhenArrayCharsIsNotEmpty() {
            char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
            MyString myString = new MyString(chars);
            Assertions.assertEquals("Hello", myString.toString());
        }

        @Test
        public void toStringShouldReturnsStringWhenArrayCharsIsEmpty() {
            char[] chars = new char[]{};
            MyString myString = new MyString(chars);
            Assertions.assertEquals("", myString.toString());
        }
    }

    @Nested
    public class ChartAt {
        @Test
        public void charAtShouldReturnCharWhenIndexZero() {
            char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
            MyString myString = new MyString(chars);
            Assertions.assertEquals('H', myString.charAt(0));
        }

        @Test
        public void charAtShouldReturnCharWhenIndexPositionOfLastLetter() {
            char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
            MyString myString = new MyString(chars);
            Assertions.assertEquals('o', myString.charAt(4));
        }

        @Test
        public void charAtShouldReturnCharWhenIndexPositionIs2() {
            char[] chars = new char[]{'H', 'e', 'p', 'l', 'o'};
            MyString myString = new MyString(chars);
            Assertions.assertEquals('p', myString.charAt(2));
        }
    }

    @Nested
    public class CompareTo {

        @Test
        public void compareToShouldCompareWhenTwoCharArrayAreSame() {
            char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
            MyString myString = new MyString(chars);
            char[] charsSecond = new char[]{'H', 'e', 'l', 'l', 'o'};
            MyString myStringSecond = new MyString(charsSecond);
            Assertions.assertEquals(0, myString.compareTo(myStringSecond));
        }

        @Test
        public void compareToShouldCompareWhenFirstCharArrayLengthLonger() {
            char[] chars = new char[]{'H', 'e', 'l', 'l', 'o'};
            MyString myString = new MyString(chars);
            char[] charsSecond = new char[]{'H', 'e', 'l', 'l'};
            MyString myStringSecond = new MyString(charsSecond);
            Assertions.assertEquals(1, myString.compareTo(myStringSecond));
        }

        @Test
        public void compareToShouldCompareWhenSecondCharArrayLengthLonger() {
            char[] chars = new char[]{'H', 'e'};
            MyString myString = new MyString(chars);
            char[] charsSecond = new char[]{'H', 'e', 'l', 'l'};
            MyString myStringSecond = new MyString(charsSecond);
            Assertions.assertEquals(-1, myString.compareTo(myStringSecond));
        }

        @Test
        public void compareToShouldCompareWhenTwoCharArrayAreSameLength() {
            char[] chars = new char[]{'H', 'e', 'l', 'r', 'o'};
            MyString myString = new MyString(chars);
            char[] charsSecond = new char[]{'H', 'e', 'l', 'l', 'o'};
            MyString myStringSecond = new MyString(charsSecond);
            Assertions.assertEquals(1, myString.compareTo(myStringSecond));
        }
    }

    @Nested
    public class Equals {

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
    }

    @Nested
    public class Plus {

        @Test
        public void plusShouldPlusTwoArrayCharsWhenArrayAreSame() {
            char[] chars = new char[]{'t', 'e', 's', 't'};
            MyString myString = new MyString(chars);
            char[] charsSecond = new char[]{'t', 'e', 's', 'z'};
            MyString myStringSecond = new MyString(charsSecond);
            Assertions.assertEquals("testtesz", MyString.plus(myString, myStringSecond).toString());
        }

        @Test
        public void plusShouldPlusTwoArrayCharsWhenArrayAreDifferent() {
            char[] chars = new char[]{'h', 'i'};
            MyString myString = new MyString(chars);
            char[] charsSecond = new char[]{'w', 'o', 'r', 'l', 'd'};
            MyString myStringSecond = new MyString(charsSecond);
            Assertions.assertEquals("hiworld", MyString.plus(myString, myStringSecond).toString());
        }

    }

    @Nested
    public class Replace {
        @Test
        public void replaceShouldReplaceWhenArrayHasSeveralSameChars() {
            char[] chars = new char[]{'p', 'i', 'c', 'p', 'h', 'p'};
            char charsSecond = 'p';
            char charsThird = 'L';
            MyString myString = new MyString(chars);
            Assertions.assertEquals("LicLhL", myString.replace(charsSecond, charsThird).toString());
        }
    }
}