package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task406Tests {
    @Test
    public void findSecondElement() {
        Assertions.assertEquals(32, Task406.findSecondMax(new int[]{3, 2, 4, 32, 32, 4, 5, 10, 10}));
    }

    @Test
    public void findSecondElementWhenArrayOfTwoElements() {
        Assertions.assertEquals(1, Task406.findSecondMax(new int[]{1, 1}));
    }

    @Test
    public void findSecondElementWhenNegativeElements() {
        Assertions.assertEquals(-31231, Task406.findSecondMax(new int[]{-12311, -312133311, -31231, -312312311, -31231231}));
    }

    @Test
    public void findSecondElementWhenPositiveElements() {
        Assertions.assertEquals(312133311, Task406.findSecondMax(new int[]{12311, 312133311, 31231, 312312311, 31231231}));
    }
}
