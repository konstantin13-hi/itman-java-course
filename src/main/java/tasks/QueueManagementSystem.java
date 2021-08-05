package tasks;

import entities.Ticket;

public class QueueManagementSystem {

    public String place;
    public int currentNumber;
    public   int number=1;
    Ticket myticket ;


    public  QueueManagementSystem(String place) {


        currentNumber=number;
        this.place =place;
        myticket = new Ticket(currentNumber, this.place);


    }

    public Ticket getNextTicket() {
        number++;
        return myticket;
    }
    public int getTotalTickets(){
        return getNextTicket().number;
    }



}
