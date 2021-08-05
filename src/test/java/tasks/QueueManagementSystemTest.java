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

        Assertions.assertEquals(3,my.getTotalTickets());



}}