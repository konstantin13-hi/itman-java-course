package collections;

import entities.Node;

public class LinkedList {
    private Node head;
  public  LinkedList(){
      head=null;
  }




    public void addFirst(int element){
        head= new Node(element,head);

    }
   public  int getFirst(){
      return   head.getElement();
    }
   public  int removeFirst(){
        int result = head.getElement();
       head= head.getNext();
        return result;
    }

}
