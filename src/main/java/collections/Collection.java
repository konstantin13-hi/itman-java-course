package collections;


import java.util.function.IntFunction;
import java.util.function.Predicate;

/**
 * Interface class that has the following methods.
 *
 * @param <T> This describes my type parameter
 */
public interface Collection<T> extends Iterable<T> {
    /**
     * Returns size.
     *
     * @cpu O(1)
     * @ram O(1)
     * @return int
     */
    int size();

    /**
     * Cheeks array length.
     *
     * @cpu O(1)
     * @ram O(1)
     * @return boolean result
     */
    boolean isEmpty();

    /**
     * Adds element.
     *
     * @param element the first term
     * @return boolean result.If change length, then will return true
     * LinkedList and ArrayList:
     * @cpu O(1)
     * @ram O(1)
     */
    boolean add(T element);

    /**
     * Adds elements.
     *
     * @param collection the first term
     * @return boolean result.If change length, then will return true
     * LinkedList and ArrayList:
     * @cpu O(n)
     * @ram O(n)
     */
    boolean addAll(Collection<T> collection);

    /**
     * Cheeks if an array contains element.
     *
     * @param element the first term
     * @return boolean result.If current object has same element then will return true
     * LinkedList and ArrayList:
     * n = logicalSize
     * @cpu O(n)
     * @ram O(1)
     */
    boolean contains(T element);

    /**
     * Removes the passed element.
     *
     * @param element the first term
     * @return boolean result.If find it then will return true
     * LinkedList and ArrayList:
     * @cpu O(n)
     * @ram O(1)
     */
    boolean remove(T element);

    /**
     * Cheeks if an array contains element.
     *
     * @param collection the first term
     * @return boolean result.If current object has same elements then will return true
     * LinkedList and ArrayList:
     * n = logicalSize
     * m = size of collection
     * @cpu O(n*m)
     * @ram O(1)
     */
    boolean containsAll(Collection<T> collection);

    /**
     * Cheeks if an array contains collection's elements.
     *
     * @param collection the first term
     * LinkedList and ArrayList:
     * n = logicalSize
     * m = size of collection
     * @cpu O(n*m)
     * @ram O(1)
     */
    void removeAll(Collection<T> collection);

    /**
     * Returns array.
     * n=logical size
     *
     * @return array
     * @cpu O(n)
     * @ram O(n)
     */
    T[] toArray();

    /**
     * Returns an array with a size depending on the input data.
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param factory the first term
     * @return array
     */
    T[] toArray(IntFunction<T> factory);

    /**
     * Removes elements matching predicate.
     * n=logical size
     *
     * @param predicate the first date
     * @cpu O(n)
     * @ram O(1)
     */
    void removeIf(Predicate<T> predicate);
}
