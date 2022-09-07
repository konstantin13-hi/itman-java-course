package tasks;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedQueueManagementSystemTest {

    @Nested
    public class GetCurrentLinkedQueue {

        @Test
        public void shouldGetCurrentQueueWhenCalledOne() {
            QueueManagementSystem system = new QueueManagementSystem("Bank");
            system.getNextTicket();
            system.getNextTicket();

            Assertions.assertEquals(2, system.getCurrentQueue().length);
        }

    }

    @Nested
    public class GetTotalTickets {

        @Test
        public void shouldGetTotalTicketsWhenQueueIsEmpty() {
            QueueManagementSystem my = new QueueManagementSystem("WWW");
            Assertions.assertEquals(0, my.getTotalTickets());
        }

        @Test
        public void shouldGetTotalTicketsWhenQueueIsNotEmpty() {
            QueueManagementSystem my = new QueueManagementSystem("Bank");
            Ticket b = my.getNextTicket();
            Ticket b1 = my.getNextTicket();
            Ticket b2 = my.getNextTicket();
            Assertions.assertEquals(1, b.getNumber());
            Assertions.assertEquals(2, b1.getNumber());
            Assertions.assertEquals(3, b2.getNumber());
            Assertions.assertEquals(3, my.getTotalTickets());
        }
    }

    @Nested
    public class GetVisitsByDay {

        @Test
        public void shouldGetVisitsByDayWhenQueueHasThreeWorkDays() {
            QueueManagementSystem system = new QueueManagementSystem("Bank");
            system.getNextTicket();
            system.getNextTicket();
            system.toNextWorkDay();
            system.getNextTicket();
            system.toNextWorkDay();
            Assertions.assertEquals(3, system.getTotalTickets());
            Assertions.assertEquals(2, system.getVisitsByDay().get(0));
            Assertions.assertEquals(1, system.getVisitsByDay().get(1));
            Assertions.assertEquals(0, system.getVisitsByDay().get(2));
            Assertions.assertEquals(3, system.getVisitsByDay().size());
        }

        @Test
        public void shouldGetVisitsByDayWhenQueueHasTwoWorkDays() {
            QueueManagementSystem system = new QueueManagementSystem("Bank");
            system.getNextTicket();
            system.getNextTicket();
            system.toNextWorkDay();
            system.getNextTicket();
            Assertions.assertEquals(3, system.getTotalTickets());
            Assertions.assertEquals(2, system.getVisitsByDay().get(0));
            Assertions.assertEquals(1, system.getVisitsByDay().get(1));
            Assertions.assertEquals(2, system.getVisitsByDay().size());
        }

    }
}