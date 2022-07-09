package tasks;

import collections.ArrayList;
import collections.Queue;
import entities.Ticket;

public class QueueManagementSystem {
    private ArrayList arrayList;
    private int currentNumberOfTicket;
    private int numberOfTicketsTheLastDays;
    private String place;
    private Queue queue;


    /**
     * Add current number of ticket in arraylist
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param a the first term
     */

    public QueueManagementSystem(String a) {
        queue = new Queue();
        this.place = a;
        arrayList = new ArrayList();
        arrayList.add(currentNumberOfTicket);
    }

    /**
     *Create new ticket
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return new ticket
     */
    public Ticket getNextTicket() {
        queue.offer(currentNumberOfTicket - numberOfTicketsTheLastDays);
        currentNumberOfTicket++;
        arrayList.set(arrayList.size() - 1, currentNumberOfTicket - numberOfTicketsTheLastDays);
        return new Ticket(currentNumberOfTicket - numberOfTicketsTheLastDays, this.place);
    }

    /**
     *Get information of tickets
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return current number
     */
    public int getTotalTickets() {
        return currentNumberOfTicket;
    }

    /**
     *Made next work day
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void toNextWorkDay() {
        queue=new Queue();
        numberOfTicketsTheLastDays = currentNumberOfTicket;
        arrayList.add(0);
    }
    public Ticket[] getCurrentQueue(){
        Ticket[] tickets=new Ticket[queue.size()];
        for (int i=0;i<tickets.length;i++){
            tickets[i]=new Ticket(queue.poll(),place);
        }
        return tickets;
    }
    public Ticket callNext(){
        return new Ticket(queue.poll(),place);
    }

    /**
     *Get visits day
     *
     * @cpu 0(n)
     * @ram 0(n)
     * @return new arraylist
     */
    public ArrayList getVisitsByDay() {
        return ArrayList.of(arrayList.toArray());
    }
}
