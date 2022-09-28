package collections;

import java.util.Iterator;

/**
 * Interface class that has the following methods.
 *
 * @param <T> This describes my type parameter
 */
public interface ListIterator<T> extends Iterator<T> {

    /**
     * Sets element.
     *
     * @param element the second term
     * @cpu O(1)
     * @ram O(1)
     */
    void set(T element);

    /**
     * Inserts before.
     *
     * @param element the first term
     * @cpu O(1)
     * @ram O(1)
     */
    void insertBefore(T element);
}
