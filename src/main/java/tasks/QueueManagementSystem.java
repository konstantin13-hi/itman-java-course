package tasks;

import entities.Ticket;

public class QueueManagementSystem {


    public int currentNumber = 1;
    public String place;
    Ticket myticket;

    public QueueManagementSystem(String place) {
        this.place = place;
        myticket = new Ticket(currentNumber, place);

    }

    public Ticket getNextTicket() {
        currentNumber++;
        return myticket;
    }

    public int getTotalTickets() {
        return getNextTicket().number;
    }
}
