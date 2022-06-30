package collections;

import entities.Node;

public class LinkedList {
    private Node head;
  public  LinkedList(){
      head=null;
  }




    void addFirst(int element){
        head= new Node(element,head);

    }
    int getFirst(){
      return   head.getElement();
    }
    int removeFirst(){
        int result = head.getElement();
       head= head.getNext();
        return result;
    }

}
