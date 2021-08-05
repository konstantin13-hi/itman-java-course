package tasks;

import entities.Ticket;

public class QueueManagementSystem {


    public int currentNumber = 1;

    Ticket myticket;


    public QueueManagementSystem(String a) {

        myticket = new Ticket(currentNumber, "wwww");
        myticket.place=a;

    }

    public Ticket getNextTicket() {
        currentNumber++;
        return myticket;
    }

    public int getTotalTickets() {
        return getNextTicket().number;
    }
}
