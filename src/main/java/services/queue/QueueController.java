package services.queue;

import collections.ArrayList;
import org.springframework.web.bind.annotation.*;
import tasks.QueueManagementSystem;
import entities.Ticket;
import utils.StringBuilder;


@RestController
public class QueueController {
   private QueueManagementSystem queueManagementSystem;
   public QueueController (String a){
       queueManagementSystem = new QueueManagementSystem(a);
   }
    public QueueController(){
        queueManagementSystem = new QueueManagementSystem("'bank'");
    }



    @GetMapping("/api/queue/nextTicket")

    public String indexNextTicket() {
       Ticket ticket=queueManagementSystem.getNextTicket();
        return "Ticket{number="+ticket.getNumber()+", place="+ticket.getPlace()+"}";
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
