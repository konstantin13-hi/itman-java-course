package collections;

import entities.Node;

public class LinkedList {
    private Node head;

    public LinkedList() {
        head = null;
    }


    public void addFirst(int element) {
        head = new Node(element, head);

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
        Node node = new Node(element, null);
        if(head==null){
            head = new Node(element, null);
        }
        while (head.getNext() != null) {
            head = head.getNext();
        }
        head.setNext(node);
    }

    public int getLast() {
        while (head.getNext() != null) {
            head = head.getNext();
        }
        return head.getElement();
    }

    public int removeLast() {
        int result = 0;
        if (head.getNext() == null) {
            result = head.getElement();
            head = null;
        } else {
            while (head.getNext() != null) {
                if (head.getNext().getNext() == null) {
                    result = head.getNext().getElement();
                    head.setNext(null);
                } else {
                    head = head.getNext();
                }
            }
        }
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
