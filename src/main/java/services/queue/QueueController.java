package services.queue;

import collections.ArrayList;
import org.springframework.web.bind.annotation.*;
import tasks.QueueManagementSystem;
import entities.Ticket;
import utils.StringBuilder;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {
   private QueueManagementSystem queueManagementSystem;

    @GetMapping("/api/queue/nextTicket")

    public String indexNextTicket() {
        int number=queueManagementSystem.getNextTicket().getNumber();
        String place =queueManagementSystem.toString();

        return "Ticket{number="+number+", place="+place+"}";
    }

    @GetMapping("/api/queue/totalTickets")

    public int indexTotalTickets() {
        return queueManagementSystem.getTotalTickets();
    }


    @PostMapping("/api/queue/toNextWorkDay")
    public void indexNextWorkDay() {
        queueManagementSystem.toNextWorkDay();
    }

    @GetMapping("/api/queue/getVisitsByDays")
    public String indexGetVisitsByDays() {
        int logicalSize= queueManagementSystem.getVisitsByDay().size();
        ArrayList arraylist =queueManagementSystem.getVisitsByDay();
        StringBuilder stringBuilder = new StringBuilder();
        if (logicalSize != 0) {
            stringBuilder.append("[");
            for (int i = 0; i < logicalSize; i++) {
                stringBuilder.append(arraylist.get(i));
                if (i != logicalSize - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");

        } else {
            stringBuilder.append("[]");
        }

        return stringBuilder.toString();
    }




}
