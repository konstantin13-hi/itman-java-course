package benchmarks;
import utils.StringBuilder;

public class StringBuilderBenchmark {


    public static String concatenateUsingOperator(int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += " " + i % 10;
        }
        return result;
    }
    public static String concatenateUsingStringBuilder(int n){
        StringBuilder s = new StringBuilder(1);
        for (int i = 0; i < n; i++) {
            s.append(" "+i%10);
        }
        return s.toString();
    }
    //35 sec 954ms concatenateUsingOperator
    //3 sec 12ms

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
