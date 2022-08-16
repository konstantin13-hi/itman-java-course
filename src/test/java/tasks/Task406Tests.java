package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task406Tests {
    @Nested
    public class FindSecondMax {

        @Test
        public void shouldFindSecondMaxWhenArrayOfTwoElements() {
            Assertions.assertEquals(1, Task406.findSecondMax(new int[]{1, 1}));
        }

        @Test
        public void shouldFindSecondMaxWhenNegativeElements() {
            Assertions.assertEquals(-31231,
                    Task406.findSecondMax(new int[]{-12311, -312133311,
                            -31231, -312312311, -31231231}));
        }

        @Test
        public void shouldFindSecondMaxWhenPositiveElements() {
            Assertions.assertEquals(312133311,
                    Task406.findSecondMax(new int[]{12311,
                            312133311, 31231, 312312311, 31231231}));
        }
    }
}