package collections;

public interface List {

    /**
     * Add element in the back of list
     *
     * @cpu O(1)
     * @ram O(1)
     *
     * @param element the first term
     */
    void add(Object element);

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
    void set(int index, Object element);

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
    Object get(int index);

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
     * Return array containing elements
     *
     * n=logicalSize;
     * @cpu O(n)
     * @ram O(n)
     *
     * @return array
     */
    Object[] toArray();

    /**
     * Remove element
     *
     * @cpu O(n)
     * @ram O(1)
     *
     * @param index the first term
     * @return deleted element from list
     */
    Object remove(int index);
}
