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
        QueueManagementSystem my1 = new QueueManagementSystem("WEW");
        QueueManagementSystem my2 = new QueueManagementSystem("WWC");


        Assertions.assertEquals(1,my.getTotalTickets());
        Assertions.assertEquals(1,my1.getTotalTickets());
        Assertions.assertEquals(1,my2.getTotalTickets());

    }

    @Test
    public void getNextTicket() {
        QueueManagementSystem my = new QueueManagementSystem("WWW");
        Assertions.assertEquals(1,my.currentNumber);
        Assertions.assertEquals("WWW",my.place);


    }






}