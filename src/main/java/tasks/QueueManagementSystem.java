package tasks;

import entities.Ticket;

public class QueueManagementSystem {


    public int currentNumber ;
    String place;
    Ticket my;


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
