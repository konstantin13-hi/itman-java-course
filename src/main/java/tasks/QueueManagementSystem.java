package tasks;

import collections.IntArrayList;
import collections.Queue;
import entities.Ticket;

public class QueueManagementSystem  {
    private IntArrayList intArrayList;
    private int currentNumberOfTicket;
    private int numberOfTicketsTheLastDays;
    private String place;
    private Queue queue;



    /**
     * Add current number of ticket in arraylist
     *
     * @param a the first term
     * @cpu 0(1)
     * @ram 0(1)
     */

    public QueueManagementSystem(String a) {
        queue = new Queue();
        this.place = a;
        intArrayList = new IntArrayList();
        intArrayList.add(currentNumberOfTicket);
    }

    /**
     * Create new ticket
     *
     * @return new ticket
     * @cpu 0(1)
     * @ram 0(1)
     */
    public Ticket getNextTicket() {
        currentNumberOfTicket++;
        Ticket ticket = new Ticket(currentNumberOfTicket - numberOfTicketsTheLastDays, this.place);
        queue.offer(ticket);
        intArrayList.set(intArrayList.size() - 1, currentNumberOfTicket - numberOfTicketsTheLastDays);
        return ticket;
    }

    /**
     * Get information of tickets
     *
     * @return current number
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int getTotalTickets() {
        return currentNumberOfTicket;
    }

    /**
     * Made next work day
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void toNextWorkDay() {
        queue = new Queue();
        numberOfTicketsTheLastDays = currentNumberOfTicket;
        intArrayList.add(0);
    }

    public Ticket[] getCurrentQueue() {
        int length = queue.size();
        Ticket[] tickets = new Ticket[length];
        for (int i = 0; i < length; i++) {
            tickets[i] = (Ticket) queue.peek();
        }
        return tickets;
    }

    public Ticket callNext() {

        return (Ticket) queue.poll();
    }

    /**
     * Get visits day
     *
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     */
    public IntArrayList getVisitsByDay() {
        return IntArrayList.of(intArrayList.toArray());
    }
}
