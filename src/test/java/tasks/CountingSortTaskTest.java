package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTaskTest {
    @Test
    public void count() {
        int[] actual = new int[]{1, 5, 3, 1, 2};
        int[] expected = new int[]{0, 2, 1, 1, 0, 1};
        Assertions.assertArrayEquals(expected, CountingSortTask.count(actual));
    }

}