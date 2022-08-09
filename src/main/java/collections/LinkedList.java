package collections;


import utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class LinkedList<T> implements List<T>, Queue<T> {

    private Node head;
    private Node prev;
    private int logicalSize;


    private class LinkedListIterator implements ListIterator<T> {
        private int current;
        private Node currentObject = head;

        @Override
        public boolean hasNext() {
            return logicalSize > current;
        }

        @Override
        public T next() {
            current++;
            T result = currentObject.element;
            currentObject = currentObject.getNext();
            return result;
        }

        @Override
        public void set(T element) {
            currentObject.setElement(element);

        }

        @Override
        public void insertBefore(T element) {
            add(current - 1, element);
        }
    }

    private class Node {
        private T element;
        private Node next;
        private Node prev;

        public void setElement(T element) {
            this.element = element;
        }

        public Node(T element, Node next, Node prev) {
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

        public T getElement() {
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
    public LinkedList(LinkedList<T> that) {
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
    public void addFirst(T element) {
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

    public T getFirst() {
        return head.getElement();
    }

    /**
     * Return first element and delete him from list
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */
    public T removeFirst() {
        T result = head.getElement();
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
    public void addLast(T element) {
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

    public T getLast() {
        return prev.getElement();
    }

    /**
     * Return last element and delete him from list
     *
     * @return last element
     * @cpu O(1)
     * @ram O(1)
     */

    public T removeLast() {
        T result;
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
        return this.toString();
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
    public T[] toArray() {
        ArrayList<T> arrayList = new ArrayList();
        Node current = head;
        while (current != null) {
            arrayList.add(current.getElement());
            current = current.getNext();
        }
        return arrayList.toArray();
    }

    @Override
    public void removeIf(Predicate predicate) {

    }

    @Override
    public T[] toArray(IntFunction<T> factory) {

        T[] array = (T[]) factory.apply(logicalSize);
        return array;
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
    public static <T> List of(T... elements) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T element : elements) {
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
    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass() || this.logicalSize != ((LinkedList<?>) obj).logicalSize) {
            return false;
        }
        LinkedList<?> list = (LinkedList<?>) obj;
        Iterator<T> iterator = this.iterator();
        Iterator<?> iteratorSecond = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() != iteratorSecond.next()) {
                return false;
            }

        }
        return true;
    }


    /**
     * Add element in the back of list
     *
     * @param element the first term
     * @return true
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public boolean add(T element) {
        addLast(element);
        return true;
    }

    @Override
    public boolean addAll(Collection<T> collection) {
        for (T t : collection) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean contains(T element) {
        T[] array = toArray();
        for (T i : array) {
            if (i.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T element) {
        Iterator<T> i = this.iterator();
        int index = 0;
        while (i.hasNext()) {
            if (i.next().equals(element)) {
                remove(index);
                return true;
            }
            index++;
        }

        return false;
    }

    @Override
    public boolean add(int index, T element) {
        Node node = findNode(index);
        Node newNode = new Node(element, node, node.getPrev());
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<T> collection) {
        for (T i : collection) {
            add(index++, i);
        }
        return true;
    }

    @Override
    public ListIterator<T> iterator() {
        return new LinkedListIterator();
    }

    @Override
    public void sort(Comparator<T> comparator) {
        ArrayUtils.mergeSort(toArray(), comparator);
    }

    @Override
    public boolean containsAll(Collection<T> collection) {
        for (T t : collection) {
            if (!contains(t)) {
                return false;
            }

        }
        return true;
    }

    @Override
    public void removeAll(Collection<T> collection) {
        for (T t : collection) {
            remove(t);
        }
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
    public void set(int index, T element) {
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
    public T get(int index) {
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
    public T remove(int index) {
        T result;
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
            logicalSize--;
        }
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
    public void offer(T element) {
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
    public T peek() {
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
    public T poll() {
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
