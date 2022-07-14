package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Task406Tests {
    @Nested
    public class SecondMax {

        @Test
        public void findShouldFindSecondMaxWhenArrayOfTwoElements() {
            Assertions.assertEquals(1, Task406.findSecondMax(new int[]{1, 1}));
        }

        @Test
        public void findShouldFindSecondMaxWhenNegativeElements() {
            Assertions.assertEquals(-31231, Task406.findSecondMax(new int[]{-12311, -312133311, -31231, -312312311, -31231231}));
        }

        @Test
        public void findShouldFindSecondMaxWhenPositiveElements() {
            Assertions.assertEquals(312133311, Task406.findSecondMax(new int[]{12311, 312133311, 31231, 312312311, 31231231}));
        }
    }
}