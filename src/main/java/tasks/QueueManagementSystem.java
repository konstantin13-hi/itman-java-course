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
        number++;
        arrayList.set(index,number);
        return new Ticket(currentNumber,this.place);
    }

    public int getTotalTickets() {

        return currentNumber;
    }

    public void toNextWorkDay(){
        index++;
        number=0;
        arrayList.add(0);


    }

   public ArrayList getVisitsByDay(){

       return ArrayList.of(arrayList.toArray());
   }
}
