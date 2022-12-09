package collections;


public class LinkedQueue<T>  implements Queue<T> {
    LinkedList<T> linkedList = new LinkedList<T>();

    /**
     * Inserts the specified element into the queue.
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     */
    public void offer(T element) {
        linkedList.addLast(element);
    }

    /**
     * Returns the head of the queue.
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */
    public T peek() {
        return linkedList.getFirst();
    }

    /**
     * Returns and removes the head of the queue.
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */

    public T poll() {
        return linkedList.removeFirst();
    }

    /**
     * Returns the size.
     *
     * @return size
     * @cpu O(1)
     * @ram O(1)
     */
    public int size() {
        return linkedList.size();
    }

    /**
     * Check list for elements.
     *
     * @return true or false
     * @cpu O(1)
     * @ram O(1)
     */

    public boolean isEmpty() {
        return linkedList.size() == 0;
    }

    /**
     * Returns an array containing elements.
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
