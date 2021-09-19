package tasks;

import collections.ArrayList;
import entities.Ticket;

public class QueueManagementSystem {

    private ArrayList arrayList;
    private int currentNumber;
    private int index;
    private int number;
    String place;

    public QueueManagementSystem(String a) {
        this.place = a;
        arrayList = new ArrayList();
        arrayList.add(currentNumber);
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
        currentNumber++;
        arrayList.set(index, currentNumber - number);
        return new Ticket(currentNumber - number, this.place);
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
        return currentNumber;
    }

    /**
     *Made next work day
     *
     * @cpu 0(1)
     * @ram 0(n)
     */
    public void toNextWorkDay() {
        index++;
        number = currentNumber;
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
