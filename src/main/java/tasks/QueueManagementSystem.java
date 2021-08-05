package tasks;

import entities.Ticket;

public class QueueManagementSystem {

    public String place;
    public int currentNumber=1;

    Ticket myticket ;


    public  QueueManagementSystem(String place) {

        this.place =place;
        myticket = new Ticket(currentNumber, this.place);


    }

    public Ticket getNextTicket() {
        currentNumber++;
        return myticket;
    }
    public int getTotalTickets(){
        return getNextTicket().number;
    }



}
