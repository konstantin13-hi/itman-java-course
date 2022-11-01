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
     * @return int
     */
    int size();

    /**
     * Cheeks array length.
     *
     * @return boolean result
     */
    boolean isEmpty();

    /**
     * Adds element.
     *
     * @param element the first term
     * @return boolean result.If change length, then will return true
     */
    boolean add(T element);

    /**
     * Adds elements.
     *
     * @param collection the first term
     * @return boolean result.If change length, then will return true
     */
    boolean addAll(Collection<?extends T> collection);

    /**
     * Cheeks if an array contains element.
     *
     * @param element the first term
     * @return boolean result.If current object has same element then will return true
     */
    boolean contains(T element);

    /**
     * Removes the passed element.
     *
     * @param element the first term
     * @return boolean result.If find it then will return true
     */
    T remove(Object element);

    /**
     * Cheeks if an array contains element.
     *
     * @param collection the first term
     * @return boolean result.If current object has same elements then will return true
     */
    boolean containsAll(Collection<?extends T> collection);

    /**
     * Cheeks if an array contains collection's elements.
     *
     * @param collection the first term
     */
    void removeAll(Collection<?extends T> collection);

    /**
     * Returns array.
     *
     * @return array
     */
    Object[] toArray();

    /**
     * Returns an array with a size depending on the input data.
     *
     * @param factory the first term
     * @return array
     */
    T[] toArray(IntFunction<T[]> factory);

    /**
     * Removes elements matching predicate.
     *
     * @param predicate the first date
     */
    void removeIf(Predicate<? super T> predicate);
}
