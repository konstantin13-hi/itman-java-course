package benchmarks;

import utils.StringBuilder;

public class StringBuilderBenchmark {

    /**
     *Made a concatenation between of two string
     *
     * @cpu 0(n^2)
     * @ram 0(n)
     *
     * @param n the first term
     * @return new string
     */
    public static String concatenateUsingOperator(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " " + i % 10;
        }
        return result;
    }

    /**
     * Made a concatenation between of two string
     *
     * @cpu 0(n)
     * @ram 0(n)
     * @param n the first term
     * @return
     */
    public static String concatenateUsingStringBuilder(int n) {
        StringBuilder s = new StringBuilder(1);
        for (int i = 0; i < n; i++) { //
            s.append(" " + i % 10);
        }
        return s.toString();
    }
    //35 sec 954ms concatenateUsingOperator
    //69ms
    public static void main(String[] args) {
        int number = 500000;
        long time = System.currentTimeMillis();
        concatenateUsingOperator(number);
        System.out.println(System.currentTimeMillis() - time);
        long timeSecond = System.currentTimeMillis();
        concatenateUsingStringBuilder(number);
        System.out.println(System.currentTimeMillis() - timeSecond);
    }
}
