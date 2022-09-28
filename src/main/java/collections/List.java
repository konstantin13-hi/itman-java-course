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
     * @cpu O(1)
     * @ram O(1)
     * @return boolean result.If change size then will return true
     */
    boolean add(T element);

    /**
     * Add element in the back of list.
     *
     * @param index   the first term
     * @param element the second term
     * @return boolean result.If change size then will return true.
     * ArrayList and LinkedList:
     * @cpu O(n)
     * @ram O(1)
     */
    boolean add(int index, T element);


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
    void set(int index, T element);

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
    T get(int index);

    /**
     * Adds elements in the back of list.
     *
     * @param collection the first term
     * @return boolean result.If change size then will return true.
     * ArrayList and
     * @cpu O(n)
     * @ram O(n)
     */
    boolean addAll(Collection<T> collection);

    /**
     * Adds element in index position.
     *
     * @param index      the first term
     * @param collection the second term
     * @return boolean result.If change size then will return true.
     * ArrayList and LinkedList:
     * m=collection's size
     * n=logical size
     * @cpu O(n+m)
     * @ram O(m)
     */

    boolean addAll(int index, Collection<T> collection);

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
    T[] toArray();

    /**
     * Removes element.
     *
     * @param element the first term
     * @return boolean result.If change size then will return true.
     * ArrayList:@cpu O(n)
     * LinkedList:@cpu O(1)
     * @ram O(1)
     */
    boolean remove(T element);

    /**
     * Remove element.
     *
     * @param index the first term
     * @return deleted element from list
     * ArrayList @cpu O(1)
     * LinkedList @cpu 0(n)
     * @ram O(1)
     */
    T remove(int index);

    /**
     * Returns iterator.
     *
     * @return iterator
     * @cpu O(1)
     * @ram O(1)
     */
    ListIterator iterator();

    /**
     * Sorts element.
     *
     * @param comparator the first term
     * n=logical size
     * @cpu O(log ( n)*n)
     * @ram O(n)
     */
    void sort(Comparator<T> comparator);


}
