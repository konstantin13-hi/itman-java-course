package collections;

/**
 * List.java
 * Interface class that has the following methods.
 *
 * @author MyName
 * @since mm-dd-yyyy
 */
public interface List {
    /**
     * Add element in the back of list.
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     */
    void add(Object element);

    /**
     * Set element.
     * n=index
     *
     * @param index   the first term
     * @param element the second term
     * ArrayList @cpu O(n)
     * LinkedList @cpu O(1)
     * @ram 0(1)
     */
    void set(int index, Object element);

    /**
     * Get index.
     * n=index
     *
     * @param index the first term
     * @return number from array list
     * ArrayList @cpu O(1)
     * LinkedList @cpu 0(n)
     * @ram 0(1)
     */
    Object get(int index);

    /**
     * Return size.
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     */
    int size();

    /**
     * Return array containing elements.
     * n=logicalSize
     *
     * @return array
     * @cpu O(n)
     * @ram O(n)
     */
    Object[] toArray();

    /**
     * Remove element.
     *
     * @param index the first term
     * @return deleted element from list
     * ArrayList @cpu O(1)
     * LinkedList @cpu 0(n)
     * @ram O(1)
     */
    Object remove(int index);
}
