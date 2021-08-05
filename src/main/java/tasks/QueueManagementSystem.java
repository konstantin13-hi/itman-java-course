package tasks;

import entities.Ticket;

public class QueueManagementSystem {


    public int currentNumber = 1;
    String place;
    Ticket my;
    int count ;


    public QueueManagementSystem(String a) {


        this.place=a;
        my = new Ticket(currentNumber,this.place);

    }

    public Ticket getNextTicket() {
        count++;

        return my;
    }

    public int getTotalTickets() {

        return count;
    }
}
