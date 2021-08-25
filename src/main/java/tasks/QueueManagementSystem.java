package tasks;

import collections.ArrayList;
import entities.Ticket;

public class QueueManagementSystem {

    private ArrayList arrayList;
    private int currentNumber ;
    private int index;
    String place;


    public QueueManagementSystem(String a) {
        this.place=a;
        arrayList = new ArrayList();
    }

    public Ticket getNextTicket() {
        currentNumber++;
        return new Ticket(currentNumber,this.place);
    }

    public int getTotalTickets() {

        return currentNumber;
    }

    public void toNextWorkDay(){
        index++;
        arrayList.add(currentNumber);
        currentNumber=0;



    }

   public ArrayList getVisitsByDay(){

        return ArrayList.of(arrayList.toArray());
   }
}
