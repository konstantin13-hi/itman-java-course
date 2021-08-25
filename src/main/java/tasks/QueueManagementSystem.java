package tasks;

import collections.ArrayList;
import entities.Ticket;

public class QueueManagementSystem {

    private ArrayList arrayList;
    private int currentNumber ;
    private int index;
    private int number;
    String place;


    public QueueManagementSystem(String a) {
        this.place=a;
        arrayList = new ArrayList();
        arrayList.add(currentNumber);
    }

    public Ticket getNextTicket() {
        currentNumber++;

        arrayList.set(index,currentNumber-number);
        return new Ticket(currentNumber-number,this.place);
    }

    public int getTotalTickets() {

        return currentNumber;
    }

    public void toNextWorkDay(){
        index++;
        number=currentNumber;
        arrayList.add(0);


    }

   public ArrayList getVisitsByDay(){

       return ArrayList.of(arrayList.toArray());
   }
}
