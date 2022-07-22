package collections;


import java.util.Objects;

public class LinkedList {
    private Node head;
    private Node prev;
    private int logicalSize;

    private static class Node {
        private Object element;
        private Node next;
        private Node prev;

        public void setElement(Object element) {
            this.element = element;
        }

        public Node(Object element, Node next, Node prev) {
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

        public Object getElement() {
            return element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

    public LinkedList() {}

    /**
     * Create an arraylist
     *
     * n=logicalSize of that list
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param that the first term
     */
    public LinkedList(LinkedList that) {
        Node current = that.head;
        while (current != null) {
            addLast(current.getElement());
            current = current.getNext();
        }
    }

    /**
     * Add element in the front of list
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element the first term
     */
    public void addFirst(Object element) {
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

    /**
     * Return first element
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return element
     */

    public Object getFirst() {
        return head.getElement();
    }

    /**
     * Return first element and delete him from list
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return first element
     */
    public Object removeFirst() {
        Object result = head.getElement();
        head = head.getNext();
        logicalSize--;
        return result;
    }

    /**
     * Add element in the back of list
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element the first term
     */
    public void addLast(Object element) {
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

    /**
     * Return last element from list
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return last element
     */

    public Object getLast() {
        return prev.getElement();
    }

    /**
     * Return last element and delete him from list
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return last element
     */

    public Object removeLast() {
        Object result ;
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

    /**
     * Create a string
     *
     * n=logicalSize
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return new string
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node current = head;
        while (current != null) {
            stringBuilder.append(current.getElement());
            if (current.getNext() != null) {
                stringBuilder.append(", ");
                current = current.getNext();
            } else {
                current = current.getNext();
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * Return array containing elements
     *
     * n=logicalSize;
     * @cpu O(n)
     * @ram O(n)
     *
     * @return array
     */
    public Object[] toArray() {
        ArrayList arrayList = new ArrayList();
        Node current = head;
        while (current != null) {
            arrayList.add(current.getElement());
            current = current.getNext();
        }
        return arrayList.toArray();
    }

    /**
     * Create a list
     *
     * n=number of elements
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param elements the first term
     * @return new arraylist
     */
    public static LinkedList of(Object... elements) {
        LinkedList linkedList = new LinkedList();
        for (Object element : elements) {
            linkedList.addLast(element);
        }
        return linkedList;
    }

    /**
     * Make a compare between of two lists
     *
     * n=that.size
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param obj the first term
     *
     * @return result
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return Objects.equals(this.toString(), obj.toString()) && this.getClass() == obj.getClass();
    }

    /**
     * Set element
     *
     * n=index
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param index the first term
     * @param element the second term
     */
    public void set(int index, Object element) {
        findNode(index).setElement(element);
    }

    /**
     * Get index
     *
     * n=index
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param index the first term
     * @return number from arraylist
     */
    public Object get(int index) {
        return findNode(index).element;
    }

    private Node findNode(int index) {
        Node current = head;
        int c = 0;
        while (current != null && c != index) {
            current = current.getNext();
            c++;
        }
        return current;
    }



    /**
     * Remove element
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param index the first term
     * @return deleted element from list
     */
    public Object remove(int index) {
        Object result ;
        if (logicalSize==1) {
            result=head.element;
            removeFirst();
        }
        else if (index==0) {
            result=getFirst();
            removeFirst();
        } else if (index+1==logicalSize) {
            result=getLast();
            removeLast();

        } else {
            Node current = findNode(index);
            result=current.element;
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
        }
        logicalSize--;
        return result;
    }

    /**
     * Return size
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return size
     */
    public int size() {
        return logicalSize;
    }

}
