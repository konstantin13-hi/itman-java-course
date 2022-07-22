package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class QueueTest {

    @Nested
    public class Offer {
        @Test
        void shouldAddElementsWhenQueueIsEmpty() {
            Queue queue = new Queue();
            queue.offer(1);
            queue.offer(53);
            queue.offer(119);
            Assertions.assertArrayEquals(new Object[]{1, 53, 119}, queue.toArray());
        }
    }

    @Nested
    public class Pick {
        @Test
        void shouldGetFirstElementFromQueueWhenQueueIsNotEmpty() {
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
        void shouldRemoveFirstElementWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            queue.offer(8);
            Assertions.assertEquals(5, queue.poll());
            Assertions.assertEquals(7, queue.peek());
        }
        @Test
        void shouldWhen(){
            Queue queue = new Queue();
            Ticket ticket = new Ticket(1,"A");
            Ticket ticketSecond = new Ticket(2,"A");
            queue.offer(ticket);
            queue.offer(ticketSecond);
            Assertions.assertEquals(ticket, queue.poll());
            Assertions.assertEquals(ticketSecond, queue.poll());
        }
    }

    @Nested
    public class Size {
        @Test
        void shouldReturnSizeWhenQueueIsNotEmpty() {
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
        void shouldReturnSizeWhenQueueIsEmpty() {
            Queue queue = new Queue();
            Assertions.assertEquals(0, queue.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        void shouldReturnFalseWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            Assertions.assertFalse(queue.isEmpty());
        }

        @Test
        void shouldReturnTrueWhenQueueIsEmpty() {
            Queue queue = new Queue();
            Assertions.assertTrue(queue.isEmpty());

        }
    }

    @Nested
    public class ToArray {
        @Test
        void shouldReturnArrayWhenQueueIsNotEmpty() {
            Queue queue = new Queue();
            queue.offer(5);
            queue.offer(7);
            Assertions.assertArrayEquals(new Object[]{5, 7}, queue.toArray());
        }

    }
}