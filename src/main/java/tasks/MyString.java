package tasks;

import java.util.Arrays;

public class MyString {
    private final char[] chars;

    public MyString(char[] a) {
        char[] b = new char[a.length];
        System.arraycopy(a, 0, b, 0, a.length);
        this.chars = b;
    }

    /**
     * Create a string
     *
     * @cpu 0(1)
     * @ram 0(n)
     *
     * @return new string
     */
    public String toString() {
        return new String(chars);
    }

    /**
     * Find a length
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return length of array
     */

    public int length() {
        return chars.length;
    }

    /**
     * Find char
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param index the first term
     * @return index from array
     */
    public char charAt(int index) {
        return chars[index];
    }

    /**
     * Make a lexicographically compare between two strings
     *
     * n=that.length
     *
     * @cpu 0(n)
     * @ram 0(1)
     * @param that the first term
     *
     * @return result
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
                    } else result = -1;
                }
            }
        }

        return result;
    }

    /**
     * Make a compare between two strings
     *
     * n=that.length
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param that first term
     * @return result of sameness
     */
    public boolean equals(MyString that) {
        if (that == null) {
            return false;
        }
        return Arrays.equals(that.chars, chars);
    }

    /**
     * Make a concatenation
     *
     * @cpu O(n+m)
     * @ram o(n+m)
     *
     * @param a the first term
     * @param b the second term
     * @return
     */
    public static MyString plus(MyString a, MyString b) {
        char[] twoChars = new char[a.length() + b.length()];/// 1 2 3     4 5 6
        System.arraycopy(a.chars,0,twoChars,0,a.chars.length);
        System.arraycopy(b.chars,0,twoChars,a.chars.length,b.chars.length);
        return new MyString(twoChars);
    }

    public MyString plus(MyString that){
        char[] b = new char[that.chars.length];
        System.arraycopy(that.chars, 0, b, 0, that.chars.length);
        MyString myString;
        myString = new MyString(b);
        char[] twoChars = new char[this.length() + that.chars.length];
        System.arraycopy(this.chars,0,twoChars,0,this.chars.length);
        System.arraycopy(myString.chars,0,twoChars,this.chars.length,myString.chars.length);
        return new MyString(twoChars);
    }

    public MyString replace(char target, char replacement){
        char a = target;
        char b = replacement;
        char []newChar =new char[chars.length];
        System.arraycopy(chars,0,newChar,0,newChar.length);
        for (int i = 0; i < chars.length; i++) {
            if (newChar[i] == a) {
                newChar[i] = b;
            }
        }

        return new MyString(newChar);
    }

}
