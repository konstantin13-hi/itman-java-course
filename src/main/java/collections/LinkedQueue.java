package collections;


public class LinkedQueue implements Queue {
    LinkedList linkedList = new LinkedList();

    /**
     * Inserts the specified element into the queue
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     */
    public void offer(Object element) {
        linkedList.addLast(element);
    }

    /**
     * Returns the head of the queue
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */
    public Object peek() {
        return linkedList.getFirst();
    }

    /**
     * Returns and removes the head of the queue
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */

    public Object poll() {
        return linkedList.removeFirst();
    }

    /**
     * @return size
     * @cpu O(1)
     * @ram O(1)
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Check list for elements
     *
     * @return true or false
     * @cpu O(1)
     * @ram O(1)
     */

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    /**
     * Returns an array containing elements
     * <p>
     * n= size of Queue
     *
     * @return array consists of elements
     * @cpu O(n)
     * @ram O(n)
     */

    public Object[] toArray() {
        return linkedList.toArray();
    }
}
