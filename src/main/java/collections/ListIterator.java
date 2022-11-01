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
     * @param element the first term
     */
    void set(T element);

    /**
     * Inserts before.
     *
     * @param element the first term
     */
    void insertBefore(T element);

    /**
     * Returns current element.
     *
     * @return element
     */
    T current();

}
