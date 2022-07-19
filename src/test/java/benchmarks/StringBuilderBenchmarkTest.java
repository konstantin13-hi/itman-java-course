package benchmarks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StringBuilderBenchmarkTest {
    @Nested
    public class ConcatenateUsingOperator {

        @Test
        public void shouldConcatenateWhenUsingOperator() {
            int x = 10;
            Assertions.assertEquals(" 0 1 2 3 4 5 6 7 8 9", StringBuilderBenchmark.concatenateUsingOperator(x));
        }
    }

    @Nested
    public class ConcatenateUsingStringBuilder {

        @Test
        public void shouldConcatenateWhenUsingWStringBuilder() {
            int x = 10;
            Assertions.assertEquals(" 0 1 2 3 4 5 6 7 8 9", StringBuilderBenchmark.concatenateUsingStringBuilder(x));
        }
    }
}