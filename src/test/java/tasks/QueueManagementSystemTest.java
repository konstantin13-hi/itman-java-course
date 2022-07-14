package tasks;

import entities.Event;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemTest {

    @Nested
    public class GetCurrentQueue {

        @Test
        public void getCurrentQueueShouldGetCurrentQueueWhenCalledOne() {
            QueueManagementSystem system = new QueueManagementSystem("Bank");
            Ticket a = system.getNextTicket();
            Ticket b = system.getNextTicket();
            Ticket[] tickets = system.getCurrentQueue();
            Assertions.assertEquals(a, tickets[0]);
            Assertions.assertEquals(b, tickets[1]);
            system.callNext();
            Assertions.assertEquals(1, system.getCurrentQueue().length);
        }

    }

    @Nested
    public class GetTotalTickets {

        @Test
        public void getTotalTicketsShouldGetTotalTicketsWhenQueueIsEmpty() {
            QueueManagementSystem my = new QueueManagementSystem("WWW");
            Assertions.assertEquals(0, my.getTotalTickets());
        }

        @Test
        public void getTotalTicketsShouldGetTotalTicketsWhenQueueIsNotEmpty() {
            QueueManagementSystem my = new QueueManagementSystem("Bank");
            Ticket B = my.getNextTicket();
            Ticket B1 = my.getNextTicket();
            Ticket B2 = my.getNextTicket();
            Assertions.assertEquals(1, B.getNumber());
            Assertions.assertEquals(2, B1.getNumber());
            Assertions.assertEquals(3, B2.getNumber());
            Assertions.assertEquals(3, my.getTotalTickets());
        }
    }

    @Nested
    public class GetVisitsByDay {

        @Test
        public void getVisitsByDayShouldGetVisitsByDayWhenQueueHasThreeWorkDays() {
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
        public void getVisitsByDayShouldGetVisitsByDayWhenQueueHasTwoWorkDays() {
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