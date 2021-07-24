package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task406Tests {

    @Test
    public void findSecondMaxWhenArrayOfTwoElements() {
        Assertions.assertEquals(1, Task406.findSecondMax(new int[]{1, 1}));
    }

    @Test
    public void findSecondMaxWhenNegativeElements() {
        Assertions.assertEquals(-31231, Task406.findSecondMax(new int[]{-12311, -312133311, -31231, -312312311, -31231231}));
    }

    @Test
    public void findSecondMaxWhenPositiveElements() {
        Assertions.assertEquals(312133311, Task406.findSecondMax(new int[]{12311, 312133311, 31231, 312312311, 31231231}));
    }
}
