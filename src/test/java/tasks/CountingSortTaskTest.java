package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTaskTest {

    @Nested
    public class Count {

        @Test
        public void shouldCountElementsWhenArrayHaveUnsortedElements() {
            int[] actual = new int[]{1, 5, 3, 1, 2};
            int[] expected = new int[]{0, 2, 1, 1, 0, 1};
            Assertions.assertArrayEquals(expected, CountingSortTask.count(actual));
        }
    }

    @Nested
    public class Restore {
        @Test
        public void shouldWhenArrayIsNotEmpty() {
            int[] actual = new int[]{0, 2, 1, 1, 0, 1};
            int[] expected = new int[]{1, 1, 2, 3, 5};
            Assertions.assertArrayEquals(expected, CountingSortTask.restore(actual));
        }

        @Nested
        public class Sort {

            @Test
            public void shouldSortWhenArrayHaveUnsortedElements() {
                int[] actual = new int[]{1, 5, 3, 1, 2};
                CountingSortTask.sort(actual);
                int[] expected = new int[]{1, 1, 2, 3, 5};
                Assertions.assertArrayEquals(expected, actual);
            }
        }

    }
}