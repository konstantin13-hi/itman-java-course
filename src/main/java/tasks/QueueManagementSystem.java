package tasks;

import collections.IntArrayList;
import collections.LinkedQueue;
import entities.Ticket;

public class QueueManagementSystem {
    private IntArrayList intArrayList;
    private int currentNumberOfTicket;
    private int numberOfTicketsTheLastDays;
    private String place;
    private LinkedQueue linkedQueue;


    /**
     * Add current number of ticket in arraylist.
     *
     * @param a the first term
     * @cpu 0(1)
     * @ram 0(1)
     */

    public QueueManagementSystem(String a) {
        linkedQueue = new LinkedQueue();
        this.place = a;
        intArrayList = new IntArrayList();
        intArrayList.add(currentNumberOfTicket);
    }

    /**
     * Create new ticket.
     *
     * @return new ticket
     * @cpu 0(1)
     * @ram 0(1)
     */
    public Ticket getNextTicket() {
        currentNumberOfTicket++;
        Ticket ticket = new Ticket(currentNumberOfTicket - numberOfTicketsTheLastDays, this.place);
        linkedQueue.offer(ticket);
        intArrayList.set(intArrayList.size() - 1, currentNumberOfTicket - numberOfTicketsTheLastDays);
        return ticket;
    }

    /**
     * Get information of tickets.
     *
     * @return current number
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int getTotalTickets() {
        return currentNumberOfTicket;
    }

    /**
     * Made next work day.
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void toNextWorkDay() {
        linkedQueue = new LinkedQueue();
        numberOfTicketsTheLastDays = currentNumberOfTicket;
        intArrayList.add(0);
    }

    /**
     * Returns current queue.
     * n=queue length
     *
     * @return current queue
     * @cpu O(n)
     * @ram O(n)
     */

    public Ticket[] getCurrentQueue() {
        int length = linkedQueue.size();
        Object[] objects = linkedQueue.toArray();
        Ticket[] tickets = new Ticket[length];
        for (int i = 0; i < length; i++) {
            tickets[i] = (Ticket) objects[i];
        }
        return tickets;
    }

    /**
     * Returns ticket from head of queue.
     *
     * @return ticket from head of queue
     * @cpu O(1)
     * @ram O(1)
     */

    public Ticket callNext() {
        return (Ticket) linkedQueue.poll();
    }

    /**
     * Get visits day.
     *
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     */
    public IntArrayList getVisitsByDay() {
        return IntArrayList.of(intArrayList.toArray());
    }
}
