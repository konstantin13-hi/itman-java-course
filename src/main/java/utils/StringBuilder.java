package utils;

public class StringBuilder {
    private char[] chars;
    private int logicalSize;

    public StringBuilder(int capacity) {
        chars = new char[capacity];
    }

    public StringBuilder() {
        chars = new char[16];
    }

    /**
     *Find logical size
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return logical size
     */
    public int length() {
        return logicalSize;
    }

    /**
     *Made concatenation between of two strings
     *
     * n=s.length
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param s the first term
     * @return concatenation of two strings
     */
    public StringBuilder append(String s) {
        char[] y;
        if (s != null) {
            y = s.toCharArray();
            stringBuilder(s.toCharArray());
        } else {
            String x = "null";
            stringBuilder(x.toCharArray());
        }
        return this;
    }

    /**
     *Made concatenation between of two strings
     *
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param x the first term
     * @return concatenation of two strings
     */
    public StringBuilder append(boolean x) {
        String str ;
        if (!x) {
            str = "false";
        } else {
            str = "true";
        }
        stringBuilder(str.toCharArray());
        return this;
    }

    /**
     *Made concatenation between of two strings
     *
     * n=number of digits in the number
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param x the first term
     * @return concatenation of two strings
     */
    public StringBuilder append(int x) {
        String str = Integer.toString(x);
        stringBuilder(str.toCharArray());
        return this;
    }

    /**
     *Made concatenation between of two strings
     *
     * n=number of digits in the number
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param x the first term
     * @return concatenation of two strings
     */
    public StringBuilder append(double x) {
        String str = Double.toString(x);
        stringBuilder(str.toCharArray());
        return this;
    }

    /**
     *Made concatenation between of two strings
     *
     * n=number of digits in the number
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param x the first term
     * @return concatenation of two strings
     */
    public StringBuilder append(long x) {
        String str = Long.toString(x);
        stringBuilder(str.toCharArray());
        return this;
    }

    /**
     *Made new string
     *
     *n=logicalSize
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return new string
     */
    public String toString() {

        return new String(chars,0,logicalSize);
    }

    private void stringBuilder(char[] y) {
        if (chars.length <= logicalSize + y.length) {
            char[] newChar = new char[((chars.length + y.length) * 2)];
            System.arraycopy(chars, 0, newChar, 0, logicalSize );
            System.arraycopy(y, 0, newChar, logicalSize , y.length);
            chars = newChar;
            logicalSize +=y.length;
        } else {
            System.arraycopy(y, 0, chars, logicalSize, y.length);
            logicalSize += y.length;
        }

    }
}
