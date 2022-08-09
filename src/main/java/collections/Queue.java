package collections;

public interface Queue {
    /**
     *
     * Inserts the specified element into the queue
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element the first term
     */
    void offer(Object element);

    /**
     * Returns the head of the queue
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return first element
     */
    Object peek();

    /**
     * Returns and removes the head of the queue
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @return first element
     */
    Object poll();

    /**
     * Return size
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return size
     */
    int size();

    /**
     * Check list empty or not
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return result
     */
    boolean isEmpty();

    /**
     * Return array containing elements
     *
     * n=logicalSize;
     * @cpu O(n)
     * @ram O(n)
     *
     * @return array
     */
    Object[] toArray();
}
