package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void offer(){
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(1);
        queue.offer(1);
      Assertions.assertFalse(queue.isEmpty());

    }

}