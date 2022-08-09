package collections;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

public class CollectionUtils {
    static <T> T  findMin(List<T> list, Comparator<T> comparator) {
        return (T) findResult(list,comparator, x->x>0);
    }

    static <T> T  findMax(List<T> list, Comparator<T> comparator) {
        return (T) findResult(list,comparator, x->x<0);
    }

    static <T> T findResult(List<T> list, Comparator<T> comparator, Predicate<Integer>predicate) {
        ListIterator<T> iterator = list.iterator();
        T result= iterator.next();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (predicate.test(comparator.compare(result, current))) {
                result  = current;
            }
        }
        return result;
    }
   static<T> void sort(List<T> list){

       //ArrayUtils.mergeSort((T[])list,Comparable<T>::compareTo);

   }
}
