package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task510Test {

    @Nested
    public class MostFrequent {

        @Test
        void mostFrequentShouldFindTheMinimumElementThatOccursMoreOftenWhenArrayIsNotEmpty() {
            int[] array = new int[]{1, 2, 5, 1, 2, 2, 3, 1};
            int expected = 1;
            Assertions.assertEquals(expected, Task510.mostFrequent(array));
        }

        @Test
        void mostFrequentShouldFindTheMinimumElementThatOccursMoreOftenWhenOnlyTwoTypesElements() {
            int[] array = new int[]{1, 1, 1, 1, 2, 2, 2, 2};
            int expected = 1;
            Assertions.assertEquals(expected, Task510.mostFrequent(array));
        }

        @Test
        void mostFrequentShouldFindTheMinimumElementThatOccursMoreOftenWhenAllElementsSame() {
            int[] array = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
            int expected = 1;
            Assertions.assertEquals(expected, Task510.mostFrequent(array));
        }

        @Test
        void mostFrequentShouldFindTheMinimumElementThatOccursMoreOftenWhenArrayWithNegativeElements() {
            int[] array = new int[]{2147483647, 1073741823, 0, -1073741824, -2147483648, 0};
            int expected = 0;
            Assertions.assertEquals(expected, Task510.mostFrequent(array));
        }

        @Test
        void mostFrequentShouldFindTheMinimumElementThatOccursMoreOftenWhenArrayWithTheBiggestElements() {
            int[] array = new int[]{2147483647, 2146483648, 2147483647};
            int expected = 2147483647;
            Assertions.assertEquals(expected, Task510.mostFrequent(array));
        }

    }
}