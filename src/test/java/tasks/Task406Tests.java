package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task406Tests {
    @Test
    public void sumPositiveValues() {
        Assertions.assertEquals(32, Task406.findSecondMax(new int[]{3, 2, 4, 32, 32, 4, 5, 10, 10}));
    }


}
