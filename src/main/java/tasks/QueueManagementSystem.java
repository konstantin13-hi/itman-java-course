package tasks;

import collections.ArrayList;
import entities.Ticket;

public class QueueManagementSystem {
    private ArrayList arrayList;
    private int currentNumberOfTicket;
    private int numberOfTicketsTheLastDays;
    private String place;
    private Queue queue;

    public static class Queue {
        LinkedList linkedList = new LinkedList();

        public Queue() {
        }

        public void offer(Ticket element) {
            linkedList.addLast(element);
        }

        public Ticket peek() {
            return linkedList.getFirst();
        }

        public Ticket poll() {
            return linkedList.removeFirst();
        }

        public int size() {
            return linkedList.size();
        }

        public boolean isEmpty() {
            return linkedList.size() == 0;
        }

        public Ticket[] toArray() {
            return linkedList.toArray();
        }

    }

    public static class LinkedList {
        private Node head;
        private Node prev;
        private int logicalSize;

        public LinkedList() {

        }

        public void addFirst(Ticket element) {
            if (this.head == null) {
                this.head = new Node(element, null, null);
                this.prev = head;
            } else {
                Node node = new Node(element, head, head.getPrev());
                head.setPrev(node);
                head = node;
            }
            logicalSize++;
        }

        public Ticket getFirst() {
            return head.getElement();
        }

        public Ticket removeFirst() {
            Ticket result = head.getElement();
            head = head.getNext();
            logicalSize--;
            return result;
        }

        public void addLast(Ticket element) {
            if (prev == null) {
                prev = new Node(element, null, null);
                head = prev;
            } else {

                Node newNode = new Node(element, null, prev);
                prev.setNext(newNode);
                prev = prev.getNext();
            }
            logicalSize++;

        }

        public Ticket getLast() {
            return prev.getElement();
        }

        public Ticket removeLast() {
            Ticket result;
            Node current = prev;
            result = current.getElement();
            if (prev.getPrev() != null) {
                current.getPrev().setNext(null);
                prev = current.getPrev();
            } else {
                prev = null;
                head = null;
            }
            logicalSize--;


            return result;

        }


        public void set(int index, Ticket element) {
            Node current = head;
            int c = 0;
            while (current != null && c != index) {
                current = current.getNext();
                c++;
            }
            current.setElement(element);
        }

        public Ticket get(int index) {
            Node current = head;
            int c = 0;
            while (current != null && c != index) {
                current = current.getNext();
                c++;
            }
            return current.getElement();
        }

        public Ticket remove(int index) {
            Node current = head;
            int c = 0;
            while (current != null && c != index) {
                current = current.getNext();
                c++;
            }
            Ticket result = current.getElement();
            if (current.getPrev() == null && current.getNext() == null) {
                head = null;
                prev = null;
            } else {
                if (current.getNext() != null && current.getPrev() != null) {
                    current.getNext().setPrev(current.getPrev());
                    current.getPrev().setNext(current.getNext());
                    current.setNext(null);
                    current.setPrev(null);
                } else if (current.getNext() == null && current.getPrev() != null) {
                    current.getPrev().setNext(null);
                    prev = current.getPrev();
                    current.setPrev(null);
                } else {
                    current.getNext().setPrev(null);
                    head = current.getNext();
                    current.setNext(null);
                }
            }
            logicalSize--;
            return result;
        }

        public int size() {
            return logicalSize;
        }

        public Ticket[] toArray() {
            Ticket[] tickets = new Ticket[size()];
            Node current = head;
            for (int i = 0; i < size(); i++) {
                tickets[i] = current.getElement();
                current = current.getNext();
            }
            return tickets;
        }


    }

    public static class Node {
        public Node() {
        }

        public void setElement(Ticket element) {
            this.element = element;
        }

        private Ticket element;
        private Node next;
        private Node prev;


        public Node(Ticket element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

        public Node getPrev() {
            return prev;
        }

        public Ticket getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    /**
     * Add current number of ticket in arraylist
     *
     * @param a the first term
     * @cpu 0(1)
     * @ram 0(1)
     */

    public QueueManagementSystem(String a) {
        queue = new Queue();
        this.place = a;
        arrayList = new ArrayList();
        arrayList.add(currentNumberOfTicket);
    }

    /**
     * Create new ticket
     *
     * @return new ticket
     * @cpu 0(1)
     * @ram 0(1)
     */
    public Ticket getNextTicket() {
        currentNumberOfTicket++;
        Ticket ticket = new Ticket(currentNumberOfTicket - numberOfTicketsTheLastDays, this.place);
        queue.offer(ticket);
        arrayList.set(arrayList.size() - 1, currentNumberOfTicket - numberOfTicketsTheLastDays);
        return ticket;
    }

    /**
     * Get information of tickets
     *
     * @return current number
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int getTotalTickets() {
        return currentNumberOfTicket;
    }

    /**
     * Made next work day
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void toNextWorkDay() {
        queue = new Queue();
        numberOfTicketsTheLastDays = currentNumberOfTicket;
        arrayList.add(0);
    }

    public Ticket[] getCurrentQueue() {
        return queue.toArray();
    }

    public Ticket callNext() {
        return queue.poll();
    }

    /**
     * Get visits day
     *
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     */
    public ArrayList getVisitsByDay() {
        return ArrayList.of(arrayList.toArray());
    }
}
