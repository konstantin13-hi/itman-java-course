package services.queue;

import collections.IntArrayList;
import entities.Ticket;
import org.springframework.web.bind.annotation.*;
import tasks.QueueManagementSystem;



@RestController
public class QueueController {
    private QueueManagementSystem queueManagementSystem;

    /**
     * Creates a queue for the bank named "bank".
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public QueueController() {
        queueManagementSystem = new QueueManagementSystem("bank");
    }

    /**
     * Creates a new ticket and return him.
     *
     * @return a ticket with data about the number and name
     * @cpu 0(1)
     * @ram 0(1)
     */
    @GetMapping("/api/queue/nextTicket")
    public Ticket indexNextTicket() {
        Ticket ticket = queueManagementSystem.getNextTicket();
        return ticket;
    }

    /**
     * Get information how many tickets were issued.
     *
     * @return the number of issued tickets
     * @cpu 0(1)
     * @ram 0(1)
     */
    @GetMapping("/api/queue/totalTickets")
    public int indexTotalTickets() {
        return queueManagementSystem.getTotalTickets();
    }

    /**
     * Create next work day.
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    @PostMapping("/api/queue/toNextWorkDay")
    public void indexNextWorkDay() {
        queueManagementSystem.toNextWorkDay();
    }

    /**
     * Create string which containing the number of issued tickets per day.
     * n=logicalSize
     *
     * @return string containing the number of issued tickets per day
     * @cpu 0(n)
     * @ram 0(n)
     */

    @GetMapping("/api/queue/getVisitsByDays")
    public String indexGetVisitsByDays() {
        IntArrayList intArrayList = queueManagementSystem.getVisitsByDay();
        return intArrayList.toString();
    }

    /**
     * Returns array containing tickets current queue.
     * n=number of elements in current queue
     *
     * @return array containing tickets current queue
     * @cpu O(n)
     * @ram O(n)
     */

    @GetMapping("/api/queue/getCurrentQueue")
    public Ticket[] getCurrentQueue() {
        return queueManagementSystem.getCurrentQueue();
    }

    /**
     * Returns ticket from head.
     *
     * @return ticket from head
     * @cpu O(1)
     * @ram O(1)
     */
    @PostMapping("/api/queue/callNext")
    public Ticket callNext() {
        return queueManagementSystem.callNext();
    }
}
