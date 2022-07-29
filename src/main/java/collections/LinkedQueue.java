package collections;


public class LinkedQueue implements Queue {
    LinkedList linkedList = new LinkedList();

    /**
     *
     * Inserts the specified element into the queue
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element the first term
     */
    public void offer(Object element) {
        linkedList.addLast(element);
    }

    /**
     * Returns the head of the queue
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return first element
     */
    public Object peek() {
        return linkedList.getFirst();
    }

    /**
     * Returns and removes the head of the queue
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return first element
     */

    public Object poll() {
        return linkedList.removeFirst();
    }

    /**
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return size
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Check list for elements
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return true or false
     */

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    /**
     * Returns an array containing elements
     *
     * n= size of Queue
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @return array consists of elements
     */

    public Object[] toArray() {
        return linkedList.toArray();
    }
}
