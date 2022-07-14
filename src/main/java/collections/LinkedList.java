package collections;


public class LinkedList {
    private Node head;
    private Node prev;
    private int logicalSize;


    private static class Node {
        private int element;
        private Node next;
        private Node prev;

        public void setElement(int element) {
            this.element = element;
        }


        public Node() {
        }
        public Node(int element, Node next, Node prev) {
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

        public int getElement() {
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
     *
     * n=logicalSize of that list
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param that the first term
     */
    public LinkedList(LinkedList that) {
        if (that.head != null) {
            int element = that.head.getElement();
            Node node;
            head = new Node(element, null, null);
            prev = head;
            that.head = that.head.getNext();
            logicalSize++;

            while (that.head != null) {
                element = that.head.getElement();
                node = new Node(element, null, prev);
                prev.setNext(node);
                prev = node;
                that.head = that.head.getNext();
                logicalSize++;

            }
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
    public void addFirst(int element) {
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

    public int getFirst() {
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
    public int removeFirst() {
        int result = head.getElement();
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
    public void addLast(int element) {
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

    public int getLast() {
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

    public int removeLast() {
        int result = 0;
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
    public int[] toArray() {
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
    public static LinkedList of(int... elements) {
        LinkedList linkedList = new LinkedList();
        for (int element : elements) {
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
     * @param that the first term
     *
     * @return result
     */
    public boolean equals(LinkedList that) {
        // вопрос про нулл this . вызов будет нул поинт
        if (that == null) {
            return false;
        }
        boolean result = true;
        Node currentThis = this.head;
        Node currentThat = that.head;
        while (currentThat != null) {

            if (currentThat.getElement() != currentThis.getElement()) {
                result = false;
                break;
            }
            currentThis = currentThis.getNext();
            currentThat = currentThat.getNext();
            if ((currentThat == null && currentThis != null) || (currentThat != null && currentThis == null)) {
                result = false;
                break;
            }

        }
        return result;
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
    public void set(int index, int element) {
        Node current = head;
        int c = 0;
        while (current != null && c != index) {
            current = current.getNext();
            c++;
        }
        current.setElement(element);
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
    public int get(int index) {
        Node current = head;
        int c = 0;
        while (current != null && c != index) {
            current = current.getNext();
            c++;
        }
        return current.getElement();
    }

    /**
     * Remove element
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param index the first term
     * @return deleted element from list
     */
    public int remove(int index) {
        Node current = head;
        int c = 0;
        while (current != null && c != index) {
            current = current.getNext();
            c++;
        }
        int result = current.getElement();
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
