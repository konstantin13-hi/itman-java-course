package utils;

public class StringBuilder {
    private char[] chars;
    private int capacity;
    private int logicalSize;

    public StringBuilder(int capacity) {
        this.capacity = capacity;
        chars = new char[this.capacity];

    }

    public StringBuilder() {
        this.capacity = 16;
        chars = new char[capacity];
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
     * @ram 0(n)
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
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return new string
     */
    public String toString() {
        char[] newCh = new char[logicalSize];
        System.arraycopy(chars, 0, newCh, 0, newCh.length);
        return new String(newCh);
    }

    private void stringBuilder(char[] y) {
        if (this.capacity <= logicalSize + y.length) {
            this.capacity = Math.max(this.capacity + y.length, this.capacity * 2);
            logicalSize += y.length;                //  1 1 1 1 1 /2 2 2 2 2 2 2
            char[] newChar = new char[capacity];
            System.arraycopy(chars, 0, newChar, 0, logicalSize - y.length);
            System.arraycopy(y, 0, newChar, logicalSize - y.length, y.length);
            chars = newChar;
        } else {
            System.arraycopy(y, 0, chars, logicalSize, y.length);
            logicalSize += y.length;
        }

    }
}
