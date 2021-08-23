package tasks;

import entities.Event;
import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueManagementSystemTest {
    @Test
    public void QueueManagementSystem() {
        QueueManagementSystem my = new QueueManagementSystem("WWW");

        Assertions.assertEquals(0,my.getTotalTickets());



    }

    @Test
    public void Queue() {
        QueueManagementSystem my = new QueueManagementSystem("Bank");
        Ticket B = my.getNextTicket();
        Ticket B1 = my.getNextTicket();
        Ticket B2 = my.getNextTicket();
        Assertions.assertEquals(1, B.getNumber());
        Assertions.assertEquals(2, B1.getNumber());
        Assertions.assertEquals(3, B2.getNumber());
        Assertions.assertEquals(3, my.getTotalTickets());
    }

    @Test
    public void getVisitsByDay(){
        QueueManagementSystem system = new QueueManagementSystem("Bank");
        system.getNextTicket();
        system.getNextTicket();
        system.toNextWorkDay();
        system.getNextTicket();
        system.toNextWorkDay();
        Assertions.assertEquals(2,system.getVisitsByDay().get(0));
        Assertions.assertEquals(1,system.getVisitsByDay().get(1));
        Assertions.assertEquals(0,system.getVisitsByDay().get(2));
    }


}
