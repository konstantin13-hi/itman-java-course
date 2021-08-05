package tasks;

import entities.Ticket;

public class QueueManagementSystem {

    public String place;
    public int currentNumber;
    public static int number;
    Ticket myticket;


    public  QueueManagementSystem(String place) {

        number++;
        currentNumber=number;
        this.place =place;
        myticket = new Ticket(currentNumber, this.place);


    }

    public Ticket getNextTicket() {
        return myticket;
    }
    public int getTotalTickets(){
        return getNextTicket().number;
    }



}
