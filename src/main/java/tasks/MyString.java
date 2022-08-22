package tasks;

import java.util.Arrays;
import java.util.Objects;

public class MyString {
    private final char[] chars;

    /**
     * Setting elements of char.
     *
     * @param a the first term
     * @cpu 0(n)
     * @ram 0(n)
     */
    public MyString(char[] a) {
        char[] b = new char[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        this.chars = b;
    }

    /**
     * Create a string.
     * n=amount 0f elements in chars
     *
     * @return new string
     * @cpu 0(n)
     * @ram 0(n)
     */
    public String toString() {
        return new String(chars);
    }

    /**
     * Find a length.
     *
     * @return length of array
     * @cpu 0(1)
     * @ram 0(1)
     */

    public int length() {
        return chars.length;
    }

    /**
     * Find char.
     *
     * @param index the first term
     * @return index from array
     * @cpu 0(1)
     * @ram 0(1)
     */
    public char charAt(int index) {
        return chars[index];
    }

    /**
     * Make a lexicographically compare between two strings.
     * n=that.length
     *
     * @param that the first term
     * @return result
     * @cpu 0(n)
     * @ram 0(1)
     */
    public int compareTo(MyString that) {
        int result = 0;
        if (that == null) {
            return 1;
        }
        if (that.chars.length > chars.length) {
            result = -1;
        }
        if (that.chars.length < chars.length) {
            result = 1;
        }
        if ((that.chars.length == chars.length) && !Arrays.equals(that.chars, chars)) {
            for (int i = 0; i < chars.length; i++) {
                if (that.chars[i] != chars[i]) {
                    if ((int) that.chars[i] < (int) chars[i]) {
                        result = 1;
                    } else {
                        result = -1;
                    }
                }
            }
        }

        return result;
    }

    /**
     * Make a compare between two strings.
     * n=that.length
     *
     * @param obj first term
     * @return result of sameness
     * @cpu 0(n)
     * @ram 0(1)
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        MyString that = (MyString) obj;
        if (this.length() != that.length()) {
            return false;
        }
        for (int i = 0; i < that.length(); i++) {
            if (!Objects.equals(this.charAt(i), that.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Make a concatenation.
     *
     * @param a the first term
     * @param b the second term
     * @return string
     * @cpu O(n + m)
     * @ram O(n + m)
     */
    public static MyString plus(MyString a, MyString b) {
        char[] twoChars = new char[a.length() + b.length()];
        System.arraycopy(a.chars, 0, twoChars, 0, a.chars.length);
        System.arraycopy(b.chars, 0, twoChars, a.chars.length, b.chars.length);
        return new MyString(twoChars);
    }

    /**
     * Create new a variable containing two chars.
     * n=amount of elements chars in variable chars
     * m=amount of elements chars in variable that
     *
     * @param that the first term
     * @return result of two chars
     * @cpu 0(n + m)
     * @ram 0(n + m)
     */
    public MyString plus(MyString that) {
        return MyString.plus(this, that);
    }

    /**
     * Make a replacement target in chars.
     * n=amount of elements chars in variable chars
     *
     * @param target      the first term
     * @param replacement the second term
     * @return result replacement of chars
     * @cpu 0(n)
     * @ram 0(n)
     */
    public MyString replace(char target, char replacement) {
        char[] newChar = new char[chars.length];
        System.arraycopy(chars, 0, newChar, 0, newChar.length);
        for (int i = 0; i < chars.length; i++) {
            if (newChar[i] == target) {
                newChar[i] = replacement;
            }
        }
        return new MyString(newChar);
    }


}
