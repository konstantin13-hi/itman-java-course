package collections;

/**
 * Queue.java
 * Interface class that has the following methods.
 *
 * @author MyName
 * @since mm-dd-yyyy
 */

public interface Queue<T> {

    /**
     * Inserts the specified element into the queue.
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     */
    void offer(T element);

    /**
     * Returns the head of the queue.
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */
    T peek();

    /**
     * Returns and removes the head of the queue.
     *
     * @return first element
     * @cpu O(1)
     * @ram O(1)
     */
    T poll();

    /**
     * Return size.
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     */
    int size();

    /**
     * Check list empty or not.
     *
     * @return result
     * @cpu 0(1)
     * @ram 0(1)
     */
    boolean isEmpty();

    /**
     * Return array containing elements.
     * n=logicalSize;
     *
     * @return array
     * @cpu O(n)
     * @ram O(n)
     */
    T[] toArray();
}
