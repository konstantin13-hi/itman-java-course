package collections;

import java.util.Comparator;

public class CollectionUtils {

    /**
     * Finds min element.
     * n=logical size
     *
     * @cpu O(n)
     * @ram O(1)
     * @param list the first term
     * @param comparator the second term
     * @param <T> type
     * @return min element
     */
    public static <T> T findMin(List<? extends T> list, Comparator<? super T> comparator) {
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
     * @cpu O(n)
     *
     * @ram O(1)
     * @param list the first term
     * @param comparator the second term
     * @param <T> type
     * @return max element
     */
    public static <T> T findMax(List<? extends T> list, Comparator<? super T> comparator) {
        return findMin(list, comparator.reversed());
    }



    /**
     * Sorts list.
     *
     * @cpu O(n*log(n))
     * @ram O(n)
     * @param list the first term
     * @param <T> my type
     */
    public static <T extends Comparable<T>> void sort(List<? extends T> list) {
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
        T[] array = (T[]) list.toArray();
        int index = list.size() - 1;
        ListIterator<T> listIteratorSecond = list.iterator();
        while (listIteratorSecond.hasNext()) {
            listIteratorSecond.set(array[index--]);
            listIteratorSecond.next();
        }
    }
}
