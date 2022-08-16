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
     * Find logical size
     *
     * @return logical size
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int length() {
        return logicalSize;
    }

    /**
     * Made concatenation between of two strings
     * <p>
     * n=s.length
     *
     * @param s the first term
     * @return concatenation of two strings
     * @cpu 0(n)
     * @ram 0(n)
     */
    public StringBuilder append(String s) {
        char[] y;
        if (s != null) {
            y = s.toCharArray();
            addNewElementInChar(s.toCharArray());
        } else {
            String x = "null";
            addNewElementInChar(x.toCharArray());
        }
        return this;
    }

    /**
     * Made concatenation between of two strings
     *
     * @param x the first term
     * @return concatenation of two strings
     * @cpu 0(1)
     * @ram 0(1)
     */
    public StringBuilder append(boolean x) {
        String str;
        if (!x) {
            str = "false";
        } else {
            str = "true";
        }
        addNewElementInChar(str.toCharArray());
        return this;
    }

    /**
     * Made concatenation between of two strings
     * <p>
     * n=number of digits in the number
     *
     * @param x the first term
     * @return concatenation of two strings
     * @cpu 0(n)
     * @ram 0(n)
     */
    public StringBuilder append(int x) {
        String str = Integer.toString(x);
        addNewElementInChar(str.toCharArray());
        return this;
    }

    /**
     * Made concatenation between of two strings
     * <p>
     * n=number of digits in the number
     *
     * @param x the first term
     * @return concatenation of two strings
     * @cpu 0(n)
     * @ram 0(n)
     */
    public StringBuilder append(double x) {
        String str = Double.toString(x);
        addNewElementInChar(str.toCharArray());
        return this;
    }

    /**
     * Made concatenation between of two strings
     * <p>
     * n=number of digits in the number
     *
     * @param x the first term
     * @return concatenation of two strings
     * @cpu 0(n)
     * @ram 0(n)
     */
    public StringBuilder append(long x) {
        String str = Long.toString(x);
        addNewElementInChar(str.toCharArray());
        return this;
    }

    /**
     * Made new string
     * <p>
     * n=logicalSize
     *
     * @return new string
     * @cpu 0(n)
     * @ram 0(n)
     */
    public String toString() {
        return new String(chars, 0, logicalSize);
    }

    private void addNewElementInChar(char[] y) {
        if (chars.length <= logicalSize + y.length) {
            char[] newChar = new char[((chars.length + y.length) * 2)];
            System.arraycopy(chars, 0, newChar, 0, logicalSize);
            System.arraycopy(y, 0, newChar, logicalSize, y.length);
            chars = newChar;
            logicalSize += y.length;
        } else {
            System.arraycopy(y, 0, chars, logicalSize, y.length);
            logicalSize += y.length;
        }
    }
}
