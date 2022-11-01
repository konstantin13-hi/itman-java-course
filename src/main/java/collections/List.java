package collections;

import java.util.Comparator;

/**
 * List.java
 * Interface class that has the following methods.
 *
 * @author Kanstantsin
 * @since 13-09-2022
 */
public interface List<T> extends Collection<T> {
    /**
     * Add element in the back of list.
     *
     * @param element the first term
     * @return boolean result.If change size then will return true
     */
    boolean add(T element);

    /**
     * Add element in the back of list.
     *
     * @param index   the first term
     * @param element the second term
     * @return boolean result.If change size then will return true.
     */
    boolean add(int index, T element);


    /**
     * Set element.
     * n=index
     *
     * @param index   the first term
     * @param element the second term
     */
    void set(int index, T element);

    /**
     * Get index.
     * n=index
     *
     * @param index the first term
     * @return number from array list
     */
    T get(int index);

    /**
     * Adds elements in the back of list.
     *
     * @param collection the first term
     * @return boolean result.If change size then will return true.
     */
    boolean addAll(Collection<? extends T> collection);

    /**
     * Adds element in index position.
     *
     * @param index      the first term
     * @param collection the second term
     * @return boolean result.If change size then will return true.
     */

    boolean addAll(int index, Collection<? extends T> collection);

    /**
     * Return size.
     *
     * @return size
     */
    int size();

    /**
     * Return array containing elements.
     *
     * @return array
     */
    Object[] toArray();

    /**
     * Removes element.
     *
     * @param element the first term
     * @return boolean result.If change size then will return true.
     */

    T remove(Object element);

    /**
     * Remove element.
     *
     * @param index the first term
     * @return deleted element from list
     */
    T remove(int index);

    /**
     * Returns iterator.
     *
     * @return iterator
     */
    ListIterator<T> iterator();

    /**
     * Sorts element.
     *
     * @param comparator the first term
     */
    void sort(Comparator<T> comparator);


}
