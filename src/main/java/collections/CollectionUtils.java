package collections;

import java.util.Comparator;
import java.util.ConcurrentModificationException;

public class CollectionUtils {

    /**
     * Finds min element.
     * n=logical size
     *
     * @param list       the first term
     * @param comparator the second term
     * @param <T>        type
     * @return min element
     * @cpu O(n)
     * @ram O(1)
     */
    public static <T> T findMin(List<? extends T> list, Comparator<? super T> comparator) {
        if (list == null) {
            throw new NullPointerException("List is Null");
        }

        if (comparator == null) {
            throw new NullPointerException("Comparator is Null");
        }
        ListIterator<? extends T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (comparator.compare(result, current) > 0) {
                result = current;
            }
        }
        return result;
    }

    /**
     * Finds max element.
     * n=logical size
     *
     * @param list       the first term
     * @param comparator the second term
     * @param <T>        type
     * @return max element
     * @cpu O(n)
     * @ram O(1)
     */
    public static <T> T findMax(List<? extends T> list, Comparator<? super T> comparator) {
        if (list == null) {
            throw new NullPointerException("List is Null");
        }
        if (comparator == null) {
            throw new NullPointerException("Comparator is Null");
        }
        return findMin(list, (o1, o2) -> comparator.compare(o2, o1)
        );
    }


    /**
     * Sorts list.
     *
     * @param list the first term
     * @param <T>  my type
     * @cpu O(n * log ( n))
     * @ram O(n)
     */
    public static <T extends Comparable<T>> void sort(List<? extends T> list) {
        if (list == null) {
            throw new NullPointerException("List is Null");
        }
        list.sort(Comparable::compareTo);

    }

    /**
     * Makes reverse.
     *
     * @param list the first term.
     * @param <T>  type
     * @cpu O(n)
     * @ram O(n)
     */
    public static <T> void reverse(List<T> list) {
        if (list == null) {
            throw new NullPointerException("List is Null");
        }
        T[] array = (T[]) list.toArray();
        int index = list.size() - 1;
        ListIterator<T> listIteratorSecond = list.iterator();
        while (listIteratorSecond.hasNext()) {
            listIteratorSecond.next();
            listIteratorSecond.set(array[index--]);
        }
    }
}
