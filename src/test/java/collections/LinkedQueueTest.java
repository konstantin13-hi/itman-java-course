package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedQueueTest {

    @Nested
    public class Offer {
        @Test
        void shouldAddElementsWhenQueueIsEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(1);
            linkedQueue.offer(53);
            linkedQueue.offer(119);
            Assertions.assertArrayEquals(new Object[]{1, 53, 119}, linkedQueue.toArray());
        }
    }

    @Nested
    public class Pick {
        @Test
        void shouldGetFirstElementFromQueueWhenQueueIsNotEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(5);
            linkedQueue.offer(7);
            linkedQueue.offer(8);
            Assertions.assertEquals(5, linkedQueue.peek());
        }
    }

    @Nested
    public class Poll {
        @Test
        void shouldRemoveFirstElementWhenQueueIsNotEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(5);
            linkedQueue.offer(7);
            linkedQueue.offer(8);
            Assertions.assertEquals(5, linkedQueue.poll());
            Assertions.assertEquals(7, linkedQueue.peek());
        }
        @Test
        void shouldWhen(){
            LinkedQueue linkedQueue = new LinkedQueue();
            Ticket ticket = new Ticket(1,"A");
            Ticket ticketSecond = new Ticket(2,"A");
            linkedQueue.offer(ticket);
            linkedQueue.offer(ticketSecond);
            Assertions.assertEquals(ticket, linkedQueue.poll());
            Assertions.assertEquals(ticketSecond, linkedQueue.poll());
        }
    }

    @Nested
    public class Size {
        @Test
        void shouldReturnSizeWhenQueueIsNotEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(5);
            linkedQueue.offer(7);
            linkedQueue.offer(8);
            linkedQueue.offer(6);
            linkedQueue.offer(1);
            linkedQueue.offer(2);
            Assertions.assertEquals(6, linkedQueue.size());
        }

        @Test
        void shouldReturnSizeWhenQueueIsEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            Assertions.assertEquals(0, linkedQueue.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        void shouldReturnFalseWhenQueueIsNotEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(5);
            linkedQueue.offer(7);
            Assertions.assertFalse(linkedQueue.isEmpty());
        }

        @Test
        void shouldReturnTrueWhenQueueIsEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            Assertions.assertTrue(linkedQueue.isEmpty());

        }
    }

    @Nested
    public class ToArray {
        @Test
        void shouldReturnArrayWhenQueueIsNotEmpty() {
            LinkedQueue linkedQueue = new LinkedQueue();
            linkedQueue.offer(5);
            linkedQueue.offer(7);
            Assertions.assertArrayEquals(new Object[]{5, 7}, linkedQueue.toArray());
        }

    }
}