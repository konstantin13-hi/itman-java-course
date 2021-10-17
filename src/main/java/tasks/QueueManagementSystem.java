package tasks;

import collections.ArrayList;
import entities.Ticket;

public class QueueManagementSystem {

    private ArrayList arrayList;
    private int currentNumberOfTicket;
    private int index;
    private int numberOfTicketsTheLastDays;
    private String place;

    /**
     * Add current number of ticket in arraylist
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param a the first term
     */

    public QueueManagementSystem(String a) {
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
        currentNumberOfTicket++;
        arrayList.set(index, currentNumberOfTicket - numberOfTicketsTheLastDays);
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
        index++;
        numberOfTicketsTheLastDays = currentNumberOfTicket;
        arrayList.add(0);
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
