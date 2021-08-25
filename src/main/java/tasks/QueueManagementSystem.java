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
        arrayList.add(0);
    }

    public Ticket getNextTicket() {
        currentNumber++;
        return new Ticket(currentNumber,this.place);
    }

    public int getTotalTickets() {

        return currentNumber;
    }

    public void toNextWorkDay(){
        arrayList.set(index,currentNumber);
        index++;
        currentNumber=0;
        arrayList.add(0);



    }

   public ArrayList getVisitsByDay(){

        return ArrayList.of(arrayList.toArray());
   }
}
