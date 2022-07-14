package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Nested
    public class Offer {
        @Test
        void offerShouldAddElementsWhenQueueIsEmpty() {
            Queue queue = new Queue();
            queue.offer(1);
            queue.offer(53);
            queue.offer(119);
            Assertions.assertArrayEquals(new int[]{1, 53, 119}, queue.toArray());
        }
    }

    @Nested
    public class Pick {
        @Test
        void pickShouldGetFirstElementFromQueueWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            queue.offer(8);
            Assertions.assertEquals(5, queue.peek());
        }
    }

    @Nested
    public class Poll {
        @Test
        void pollShouldRemoveFirstElementWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            queue.offer(8);
            Assertions.assertEquals(5, queue.poll());
            Assertions.assertEquals(7, queue.peek());
        }
    }

    @Nested
    public class Size {
        @Test
        void sizeShouldReturnSizeWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            queue.offer(8);
            queue.offer(6);
            queue.offer(1);
            queue.offer(2);
            Assertions.assertEquals(6, queue.size());
        }

        @Test
        void sizeShouldReturnSizeWhenQueueIsEmpty() {
            Queue queue = new Queue();
            Assertions.assertEquals(0, queue.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        void isEmptyShouldReturnFalseWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            Assertions.assertFalse(queue.isEmpty());
        }

        @Test
        void isEmptyShouldReturnTrueWhenQueueIsEmpty() {
            Queue queue = new Queue();
            Assertions.assertTrue(queue.isEmpty());

        }
    }

    @Nested
    public class Array {
        @Test
        void arrayShouldReturnArrayWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            Assertions.assertArrayEquals(new int[]{5, 7}, queue.toArray());
        }

        @Test
        void arrayShouldReturnArrayWhenQueueIsEmpty() {
            Queue queue = new Queue();

            Assertions.assertArrayEquals(new int[]{}, queue.toArray());
        }
    }
}