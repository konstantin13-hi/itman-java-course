package tasks;

import entities.Ticket;

public class QueueManagementSystem {

    public String place;
    public static int number;
    Ticket myticket;


    public  QueueManagementSystem(String place) {

        number++;
        this.place =place;
        myticket = new Ticket(number, this.place);


    }

    public Ticket getNextTicket() {
        return myticket;
    }
    public int getTotalTickets(){
        return getNextTicket().number;
    }



}
