package tasks;
 import org.junit.jupiter.api.Assertions;
 import org.junit.jupiter.api.Test;
public class Task406Tests {
    @Test
    public void sumPositiveValues() {
        int[] a = new int[]{5, 3, 1, -1, 0};
        Assertions.assertEquals(3, Task406.findSecondMax(new int[]{3,2,4,32,32,4,5,10,10}) );
    }


}
