package services.queue;

import collections.ArrayList;
import org.springframework.web.bind.annotation.*;
import tasks.QueueManagementSystem;
import entities.Ticket;
import utils.StringBuilder;


@RestController
public class QueueController {
    private QueueManagementSystem queueManagementSystem;

    /**
     *Creates a queue for the bank named "bank"
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public QueueController() {
        queueManagementSystem = new QueueManagementSystem("bank");
    }

    /**
     * Creates a new ticket and return him
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return a ticket with data about the number and name
     */
    @GetMapping("/api/queue/nextTicket")
    public Ticket indexNextTicket() {
        Ticket ticket = queueManagementSystem.getNextTicket();
        return ticket;
    }

    /**
     *Get information how many tickets were issued
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return the number of issued tickets
     */
    @GetMapping("/api/queue/totalTickets")
    public int indexTotalTickets() {
        return queueManagementSystem.getTotalTickets();
    }

    /**
     * Create next work day
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    @PostMapping("/api/queue/toNextWorkDay")
    public void indexNextWorkDay() {
        queueManagementSystem.toNextWorkDay();
    }
    /**
     *Create string which containing the number of issued tickets per day
     *
     * n=logicalSize
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return string containing the number of issued tickets per day
     */

    @GetMapping("/api/queue/getVisitsByDays")
    public String indexGetVisitsByDays() {
        ArrayList arrayList =queueManagementSystem.getVisitsByDay();
        return arrayList.toString();
    }
}
