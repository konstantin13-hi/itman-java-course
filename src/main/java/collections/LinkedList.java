package collections;


import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public class LinkedList<T> extends AbstractList<T> implements List<T>, Queue<T> {


    private Node head;
    private Node prev;

    /**
     * {@inheritDoc}
     *
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public ListIterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements ListIterator<T> {
        private Node currentObject = head;
        private Node priveosObject;
        private boolean removeAllowed = false;
        private int countModify = modify;

        private void checkForComodification() {
            if (countModify != modify) {
                throw new ConcurrentModificationException("object is attempted " +
                        "to be modified concurrently without permission");
            }
        }


        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        @Override
        public boolean hasNext() {
            checkForComodification();
            return currentObject != null;
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        @Override
        public T next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException("No next element");
            }
            final T result = currentObject.element;
            priveosObject = currentObject;
            currentObject = currentObject.getNext();
            removeAllowed = true;

            return result;
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        @Override
        public void set(T element) {
            checkForComodification();
            if (!removeAllowed) {
                throw new IllegalStateException("set() method can only be called after a call to next()");
            }
            priveosObject.setElement(element);
            modify++;
            countModify++;

        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        //0 2 1
        @Override
        public void insertBefore(T element) {
            checkForComodification();
            if (!removeAllowed) {
                throw new IllegalStateException("insertBefore() method can only be called after a call to next()");
            }
            Node node = new Node(element, priveosObject, priveosObject.prev);

            if (priveosObject.prev != null) {
                priveosObject.prev.setNext(node);
            } else {
                head = node;
            }
            priveosObject.setPrev(node);
            logicalSize++;
            countModify++;
            modify++;
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        public void remove() {
            if (!removeAllowed) {
                throw new IllegalStateException("remove() method can only be called once after a call to next()");
            }

            if (head == priveosObject) {
                removeFirst();
            } else if (prev == priveosObject) {
                removeLast();
            } else {
                Node node = currentObject;
                currentObject.prev.prev.setNext(currentObject);
                currentObject.setPrev(currentObject.prev.prev);
                logicalSize--;
                modify++;
            }
            countModify++;

            removeAllowed = false;
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
        if (that == null) {
            throw new NullPointerException("LinkedList is Null");
        }
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
        modify++;
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
        final T result = head.getElement();
        Node node = head;
        if (logicalSize == 1) {
            head = null;
        } else {
            head = head.getNext();
            head.prev = null;
            node.setNext(null);
        }
        logicalSize--;
        modify++;
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
        modify++;

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
            current.setPrev(null);
        } else {
            prev = null;
            head = null;
        }
        logicalSize--;
        modify++;
        return result;
    }

    /**
     * {@inheritDoc}
     * n=logical size
     * m=Object's toString
     *
     * @cpu O(n * m)
     * @ram O(n)
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * {@inheritDoc}
     * m=collection's size
     * n=logical size
     *
     * @cpu O(n * m)
     * @ram O(m)
     */
    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection is Null");
        }
        if (this == collection) {
            throw new IllegalArgumentException("Collection cannot be passed to itself");
        }
        return super.addAll(collection);
    }

    /**
     * Adds element in index position.
     *
     * @param index      the first term
     * @param collection the second term
     * @return boolean result.If change size then will return true
     * m=collection's size
     * n=logical size
     * @cpu O(n * m)
     * @ram O(m)
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
        if (index < 0 || index > logicalSize) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + logicalSize);
        }
        if (collection == null) {
            throw new NullPointerException("Collection is Null");
        }
        if (this == collection) {
            throw new IllegalArgumentException("Collection cannot be passed to itself");
        }
        for (T i : collection) {
            add(index++, i);
        }
        modify++;
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * {@inheritDoc}
     * n=logical size
     * t=test's mothod
     *
     * @cpu O(n * t)
     * @ram O(1)
     */
    @Override
    public void removeIf(Predicate<? super T> predicate) {
        super.removeIf(predicate);
    }

    /**
     * {@inheritDoc}
     *
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * {@inheritDoc}
     * n=logical size
     * m= collection's size
     * k= method equal
     *
     * @param collection first term
     * @cpu O(n * m * k)
     * @ram O(1)
     */
    @Override
    public void removeAll(Collection<?> collection) {
        super.removeAll(collection);
    }

    /**
     * {@inheritDoc}
     *
     * @cpu O(n)
     * @ram O(1)
     */
    @Override
    public T remove(Object element) {
        return super.remove(element);
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
        if (index < 0 || index > logicalSize) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + logicalSize);
        }
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
        modify++;
        return result;
    }

    /**
     * {@inheritDoc}
     * n = logical size
     * m = collection's size
     * k = method equal
     *
     * @cpu O(n * m * k)
     * @ram O(1)
     */
    @Override
    public boolean containsAll(Collection<? extends T> collection) {
        return super.containsAll(collection);
    }

    /**
     * {@inheritDoc}
     * n = logical size
     * k=method equal
     *
     * @cpu O(n * k)
     * @ram O(1)
     */
    @Override
    public boolean contains(Object element) {
        return super.contains(element);
    }

    /**
     * {@inheritDoc}
     * n=logicalSize
     * k= method equal
     *
     * @cpu 0(n * k)
     * @ram 0(1)
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * {@inheritDoc}
     * k=comparator
     *
     * @cpu O(n * log ( n)*k)
     * @ram O(n)
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        super.sort(comparator);
    }

    /**
     * {@inheritDoc}
     * n = logical size
     *
     * @cpu O(n)
     * @ram O(n)
     */
    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    /**
     * {@inheritDoc}
     * n = logical size
     * m = method apply
     *
     * @cpu O(n * m)
     * @ram O(n)
     */
    @Override
    public T[] toArray(IntFunction<T[]> factory) {
        return super.toArray(factory);
    }

    /**
     * Create a list.
     * n=number of elements
     *
     * @param elements the first term
     * @param <T>      This describes my type parameter
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
     * @param index   the first term
     * @param element the second term
     * @return boolean result.If change size then will return true.
     * {@inheritDoc}
     * @cpu O(n)
     * @ram O(1)
     */
    @Override
    public boolean add(int index, T element) {
        if (index < 0 || index > logicalSize) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + logicalSize);
        }
        if (index == logicalSize) {
            addLast(element);
        } else if (index == 0) {
            addFirst(element);
        } else {
            Node node = findNode(index);
            Node newNode = new Node(element, node, node.getPrev());
            node.getPrev().setNext(newNode);
            node.setPrev(newNode);
            logicalSize++;
        }

        return true;
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
        if (index < 0 || index >= logicalSize) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + logicalSize);

        }
        findNode(index).setElement(element);
        modify++;
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
        if (index < 0 || index >= logicalSize) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + logicalSize);

        }
        return findNode(index).element;
    }


    private Node findNode(int index) {
        if (index < 0 || index >= logicalSize) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + logicalSize);
        }
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

}
