package tasks;

import entities.Ticket;

public class QueueManagementSystem {


    public int currentNumber ;
    String place;
    Ticket my;


    public QueueManagementSystem(String a) {


        this.place=a;
        my = new Ticket(currentNumber,this.place);

    }

    public Ticket getNextTicket() {
        currentNumber++;

        return my;
    }

    public int getTotalTickets() {

        return currentNumber;
    }
}
