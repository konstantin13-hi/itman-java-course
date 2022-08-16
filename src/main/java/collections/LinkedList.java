package collections;


import java.util.Objects;

public class LinkedList implements List, Queue {

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

    public LinkedList() {
    }

    /**
     * Create an arraylist
     * <p>
     * n=logicalSize of that list
     *
     * @param that the first term
     * @cpu 0(n)
     * @ram 0(n)
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
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
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
     * @return element
     * @cpu O(1)
     * @ram O(1)
     */

    public Object getFirst() {
        return head.getElement();
    }

    /**
     * Return first element and delete him from list
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
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
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
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
     * @return last element
     * @cpu O(1)
     * @ram O(1)
     */

    public Object getLast() {
        return prev.getElement();
    }

    /**
     * Return last element and delete him from list
     *
     * @return last element
     * @cpu O(1)
     * @ram O(1)
     */

    public Object removeLast() {
        Object result;
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
     * <p>
     * n=logicalSize
     *
     * @return new string
     * @cpu 0(n)
     * @ram 0(n)
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
     * <p>
     * n=logicalSize;
     *
     * @return array
     * @cpu O(n)
     * @ram O(n)
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
     * <p>
     * n=number of elements
     *
     * @param elements the first term
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
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
     * <p>
     * n=logicalSize
     *
     * @param obj the first term
     * @return result
     * @cpu 0(n)
     * @ram 0(1)
     */
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass() || this.logicalSize != ((LinkedList) obj).logicalSize) {
            return false;
        }
        Node nodeObj = ((LinkedList) obj).head;
        Node node = this.head;
        for (int i = 0; i < logicalSize; i++) {
            if (node.element != nodeObj.element) {
                return false;
            }
            nodeObj = nodeObj.next;
            node = node.next;
        }

        return true;
    }

    /**
     * Add element in the back of list
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public void add(Object element) {
        addLast(element);
    }

    /**
     * Set element
     * <p>
     * n=index
     *
     * @param index   the first term
     * @param element the second term
     * @cpu 0(n)
     * @ram 0(1)
     */
    public void set(int index, Object element) {
        findNode(index).setElement(element);
    }

    /**
     * Get index
     * <p>
     * n=index
     *
     * @param index the first term
     * @return number from arraylist
     * @cpu 0(n)
     * @ram 0(1)
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
     * @param index the first term
     * @return deleted element from list
     * @cpu O(n)
     * @ram O(1)
     */
    public Object remove(int index) {
        Object result;
        if (logicalSize == 1) {
            result = head.element;
            removeFirst();
        } else if (index == 0) {
            result = getFirst();
            removeFirst();
        } else if (index + 1 == logicalSize) {
            result = getLast();
            removeLast();

        } else {
            Node current = findNode(index);
            result = current.element;
            current.getNext().setPrev(current.getPrev());
            current.getPrev().setNext(current.getNext());
        }
        logicalSize--;
        return result;
    }

    /**
     * Inserts the specified element into the queue
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public void offer(Object element) {
        addLast(element);

    }

    /**
     * Returns the head of the queue
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public Object peek() {
        return getFirst();
    }

    /**
     * Returns and removes the head of the queue
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public Object poll() {
        return removeFirst();
    }

    /**
     * Return size
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int size() {
        return logicalSize;
    }


    /**
     * Check list empty or not
     *
     * @return result
     * @cpu 0(1)
     * @ram 0(1)
     */
    @Override
    public boolean isEmpty() {
        return logicalSize == 0;
    }

}
