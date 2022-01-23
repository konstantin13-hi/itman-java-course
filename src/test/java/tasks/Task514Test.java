package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task514Test {

    @Test
    public void solve() {
        int[] books = new int[]{1, 2, 3};
        int[] queue = new int[]{-1, 5, 4, -1, -1};
        Task514.solve(books, queue);
        Assertions.assertEquals(2, Task514.solve(books, queue));
    }
}