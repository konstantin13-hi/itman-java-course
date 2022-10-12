package collections;


import utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
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

    /**
     * Creates Linked list.
     */
    public LinkedList() {
    }

    /**
     * Create an arraylist.
     * n=logicalSize of that list
     *
     * @param that the first term
     * @cpu 0(n)
     * @ram 0(n)
     * {@inheritDoc}
     */
    public LinkedList(LinkedList<T> that) {
        Node current = that.head;
        while (current != null) {
            addLast(current.getElement());
            current = current.getNext();
        }
    }

    /**
     * Add element in the front of list.
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
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
     * Return first element.
     *
     * @return element
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */

    public T getFirst() {
        return head.getElement();
    }

    /**
     * Return first element and delete him from list.
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
    public T removeFirst() {
        T result = head.getElement();
        head = head.getNext();
        logicalSize--;
        return result;
    }

    /**
     * Add element in the back of list.
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
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
     * Return last element from list.
     *
     * @return last element
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
    public T getLast() {
        return prev.getElement();
    }

    /**
     * Return last element and delete him from list.
     *
     * @return last element
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
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
     * Create a string.
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
                current = null;
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * Return array containing elements.
     * n=logicalSize;
     *
     * @return array
     * @cpu O(n)
     * @ram O(n)
     */
    public T[] toArray() {
        ArrayList<T> arrayList = new ArrayList<>();
        Node current = head;
        while (current != null) {
            arrayList.add(current.getElement());
            current = current.getNext();
        }
        return arrayList.toArray();
    }

    @Override
    public T[] toArray(IntFunction<T> factory) {
        Node current = head;
        T[] array = (T[]) factory.apply(logicalSize);
        for (int i = 0; i < array.length; i++) {
            array[i] = current.element;
            current = current.next;
        }
        return array;
    }

    /**
     * Removes elements matching predicate.
     * n=logical size
     *
     * @param predicate the first date
     * @cpu O(n)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public void removeIf(Predicate<T> predicate) {
        T t;
        for (T value : this) {
            t = value;
            if (predicate.test(t)) {
                remove(t);
            }
        }


    }

    /**
     * Create a list.
     * n=number of elements
     *
     * @param elements the first term
     * @param <T> This describes my type parameter
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     * {@inheritDoc}
     */
    @SafeVarargs
    public static <T> List<T> of(T... elements) {
        LinkedList<T> linkedList = new LinkedList<>();
        for (T element : elements) {
            linkedList.addLast(element);
        }
        return linkedList;
    }

    /**
     * Make a compare between of two lists.
     * n=logicalSize
     *
     * @param obj the first term
     * @return result
     * @cpu 0(n)
     * @ram 0(1)
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        LinkedList list = (LinkedList) obj;
        if (this.logicalSize != list.logicalSize) {
            return false;
        }
        Node nodeObj = list.head;
        Node node = this.head;
        for (int i = 0; i < logicalSize; i++) {
            if (!Objects.equals(node.element, nodeObj.element)) {
                return false;
            }
            nodeObj = nodeObj.next;
            node = node.next;
        }
        return true;
    }


    /**
     * Add element in the back of list.
     *
     * @param element the first term
     * @return true
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public boolean add(T element) {
        addLast(element);
        return true;
    }

    /**
     * Add element in the back of list.
     *
     *
     * @param index   the first term
     * @param element the second term
     * @return boolean result.If change size then will return true.
     * {@inheritDoc}
     */
    @Override
    public boolean add(int index, T element) {
        Node node = findNode(index);
        Node newNode = new Node(element, node, node.getPrev());
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
        return true;
    }

    /**
     * Adds elements in the back of list.
     *
     * @param collection the first term
     * @return boolean result.If change size then will return true.
     * ArrayList and
     * @cpu O(n)
     * @ram O(n)
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(Collection<T> collection) {
        for (T t : collection) {
            add(t);
        }
        return true;
    }

    /**
     * Adds element in index position.
     *
     * @param index      the first term
     * @param collection the second term
     * @return boolean result.If change size then will return true
     * m=collection's size
     * n=logical size
     * @cpu O(n+m)
     * @ram O(m)
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<T> collection) {
        for (T i : collection) {
            add(index++, i);
        }
        return true;
    }

    /**
     * Cheeks if an array contains element.
     *
     * @param element the first term
     * @return boolean result.If current object has same element then will return true
     * n = logicalSize
     * @cpu O(n)
     * @ram O(1)
     * {@inheritDoc}
     */
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

    /**
     * Removes element.
     *
     * @param element the first term
     * @return boolean result.If change size then will return true
     * LinkedList:@cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
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

    /**
     * Remove element.
     *
     * @param index the first term
     * @return deleted element from list
     * @cpu O(n)
     * @ram O(1)
     * {@inheritDoc}
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
     * Returns iterator.
     *
     * @return iterator
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public ListIterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Sorts element.
     *
     * @param comparator the first term
     * n=logical size
     * @cpu O(log ( n)*n)
     * @ram O(n)
     * {@inheritDoc}
     */
    @Override
    public void sort(Comparator<T> comparator) {
        ArrayUtils.mergeSort(toArray(), comparator);
    }

    /**
     * Cheeks if an array contains element.
     *
     * @param collection the first term
     * @return boolean result.If current object has same elements then will return true
     * n = logicalSize
     * m = size of collection
     * @cpu O(n*m)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public boolean containsAll(Collection<T> collection) {
        for (T t : collection) {
            if (!contains(t)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Cheeks if an array contains collection's elements.
     *
     * @param collection the first term
     * n = logicalSize
     * m = size of collection
     * @cpu O(n*m)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public void removeAll(Collection<T> collection) {
        for (T t : collection) {
            remove(t);
        }
    }


    /**
     * Set element.
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
     * Get index.
     * n=index
     *
     * @param index the first term
     * @return number from arraylist
     * @cpu 0(n)
     * @ram 0(1)
     * {@inheritDoc}
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
     * Inserts the specified element into the queue.
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public void offer(T element) {
        addLast(element);

    }

    /**
     * Returns the head of the queue.
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public T peek() {
        return getFirst();
    }

    /**
     * Returns and removes the head of the queue.
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public T poll() {
        return removeFirst();
    }

    /**
     * Return size.
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     * {@inheritDoc}
     */
    public int size() {
        return logicalSize;
    }


    /**
     * Check list empty or not.
     *
     * @return result
     * @cpu 0(1)
     * @ram 0(1)
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return logicalSize == 0;
    }

}
