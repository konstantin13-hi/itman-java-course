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
import java.util.Comparator;
import java.util.Iterator;

public interface List<T> extends Collection<T> {

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
    boolean add(T element);

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
    boolean addAll(Collection<T> collection);

    void set(int index, T element);

    T get(int index);

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
    T[] toArray();

    T remove(int index);

    boolean remove(T element);

    boolean add(int index, T element);

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
    boolean addAll(int index,Collection <T> collection);

    ListIterator iterator();

    void sort(Comparator<T> comparator);


}
