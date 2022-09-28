package collections;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class CollectionUtils {
    static <T> T findMin(List<T> list, Comparator<T> comparator) {
        return (T) findResult(list, comparator, x -> x > 0);
    }

    static <T> T findMax(List<T> list, Comparator<T> comparator) {
        return (T) findResult(list, comparator, x -> x < 0);
    }

    static <T> T findResult(List<T> list, Comparator<T> comparator, Predicate<Integer> predicate) {
        ListIterator<T> iterator = list.iterator();
        T result = iterator.next();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (predicate.test(comparator.compare(result, current))) {
                result = current;
            }
        }
        return result;
    }

    /**
     * Makes sort.
     *
     * @param list the first term
     * @param <T>  type
     * @cpu O(log ( n)n)
     * @ram O(n)
     */

    public static <T extends Comparable<T>> void sort(List<Comparable<T>> list) {
        T[] array = (T[]) new Object[list.size()];
        ListIterator<T> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            array[i] = iterator.next();
        }
        ArrayUtils.mergeSort(array, Comparable::compareTo);
    }

    /**
     * Makes reverse.
     *
     * @param list the first term.
     * @param <T> type
     * @cpu O(n)
     * @ram O(n)
     */

    public static <T> void reverse(List<T> list) {
        ListIterator<T> listIterator = list.iterator();
        T[] array = (T[]) new Object[list.size()];
        for (int i = list.size() - 1; 0 < i; i--) {
            array[i] = listIterator.next();
        }
        System.arraycopy(list, 0, array, 0, array.length);


    }
}
