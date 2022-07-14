package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringBuilderBenchmarkTest {
    @Nested
    public class Concatenate {


        @Test
        public void concatenateShouldConcatenateWhenUsingOperator() {
            int x = 10;
            Assertions.assertEquals(" 0 1 2 3 4 5 6 7 8 9", StringBuilderBenchmark.concatenateUsingOperator(x));
        }

        @Test
        public void concatenateShouldConcatenateWhenUsingWStringBuilder() {
            int x = 10;
            Assertions.assertEquals(" 0 1 2 3 4 5 6 7 8 9", StringBuilderBenchmark.concatenateUsingOperator(x));
        }
    }
}