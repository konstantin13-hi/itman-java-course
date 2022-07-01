package collections;

import entities.Node;

public class LinkedList {
    private Node head;
    private Node prev;


    public LinkedList() {
        this.head = null;
    }


    public void addFirst(int element) {
        if (head == null) {
            head = new Node(element, null, null);
            prev=head;
        } else {
            Node node = new Node(element, head, null);
            head.setPrev(node);
            head = node;
        }
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
        Node current =prev;
        if (prev == null) {
            prev = new Node(element, null, null);
            head=prev;
        } else {

            Node newNode = new Node(element, prev.getNext(), current);
            prev.setNext(newNode);
            prev=current.getNext();

        }

    }

    public  int getLast() {
        return prev.getElement();
    }

    public int removeLast() {
        int result = 0;
        result=prev.getElement();
       Node node= prev.getPrev();
       if (node!=null){
       node.setNext(null);
           prev=node;}


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
