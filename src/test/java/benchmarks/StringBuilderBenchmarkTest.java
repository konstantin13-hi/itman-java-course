package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringBuilderBenchmarkTest {

    @Test
    public void concatenateUsingOperator() {
        int x = 10;
        Assertions.assertEquals(" 0 1 2 3 4 5 6 7 8 9", StringBuilderBenchmark.concatenateUsingOperator(x));
    }

    @Test
    public void concatenateUsingStringBuilder() {
        int x = 10;
        Assertions.assertEquals(" 0 1 2 3 4 5 6 7 8 9", StringBuilderBenchmark.concatenateUsingOperator(x));
    }


}