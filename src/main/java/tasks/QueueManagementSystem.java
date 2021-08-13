package tasks;

import entities.Ticket;

public class QueueManagementSystem {


    private int currentNumber ;
    String place;


    public QueueManagementSystem(String a) {
        this.place=a;
    }

    public Ticket getNextTicket() {
        currentNumber++;
        return new Ticket(currentNumber,this.place);
    }

    public int getTotalTickets() {

        return currentNumber;
    }
}
