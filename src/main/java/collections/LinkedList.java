package collections;

import entities.Node;

public class LinkedList {
    private Node head;
    private Node prev;


    public LinkedList() {
        this.head = null;
    }


    public void addFirst(int element) {
        head = new Node(element, head,prev);

    }

    public int getFirst() {
        return head.getElement();
    }

    public int removeFirst() {
        int result = head.getElement();
        head = head.getNext();
        return result;
    }

    public void addLast(int element) {
      Node current = head;
       Node previous = null;
       if (current == null) {
           head = new Node(element, null,null);
        } else {
         while (current.getNext()!=null){
               current= current.getNext();
            }
           Node newNode = new Node(element,current.getNext(),current );
           current.setNext(newNode);

        }

    }

    public  int getLast() {
        while (head.getNext() != null) {
            head = head.getNext();
        }
        return head.getElement();
    }

    public int removeLast() {
        int result = 0;
        Node current=head;
        Node previous=null;
            while (current.getNext() != null) {
                previous=current;
                current=current.getNext();
         //       if (head.getNext().getNext() == null) {
         //           result = head.getNext().getElement();
          //          head.setNext(null);
         //       } else {
         //           head = head.getNext();
        //        }
            }
            result=current.getElement();
            if(previous!=null){
            previous.setNext(null);}


        return result;

    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        while (head != null) {
            stringBuilder.append(head.getElement());

            head = head.getNext();
            if (head != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

}
