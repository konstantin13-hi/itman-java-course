package collections;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public abstract class AbstractList<T> implements List<T> {
    int logicalSize;

    /**
     * Adds element into list.
     *
     * @param collection the first term
     * @return boolean result. If change size then will return true
     */
    public boolean addAll(Collection<? extends T> collection) {
        return addAll(logicalSize, collection);
    }

    /**
     * Return size.
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     * {@inheritDoc}
     */
    public int size() {
        return logicalSize;
    }

    /**
     * Check list empty or not.
     *
     * @return result
     * @cpu 0(1)
     * @ram 0(1)
     * {@inheritDoc}
     */
    public boolean isEmpty() {
        return logicalSize == 0;
    }

    /**
     * Removes all are contained elements.
     *
     * @param collection the first term
     */
    public void removeAll(Collection<? extends T> collection) {
        ListIterator<T> listIterator;
        for (T i : collection) {
            listIterator = iterator();
            while (listIterator.hasNext()) {
                if (i.equals(listIterator.current())) {
                    listIterator.remove();
                }
                listIterator.next();
            }
        }

    }

    /**
     * Removes element.
     *
     * @param element the first term
     * @return boolean result.If change size then will return true
     */
    public T remove(Object element) {
        Iterator<T> i = this.iterator();
        int index = 0;
        while (i.hasNext()) {
            if (i.next().equals(element)) {
                return remove(index);
            }
            index++;
        }
        return null;

    }


    /**
     * Cheeks if an array contains element.
     *
     * @param collection the first term
     * @return boolean result.If current object has same elements then will return true
     * n = logicalSize
     * m = size of collection
     */
    @Override
    public boolean containsAll(Collection<? extends T> collection) {
        for (T i : collection) {
            if (!contains(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Cheeks if an array contains element.
     *
     * @param element the first term
     * @return boolean result.If current object has same element then will return true
     * n = logicalSize
     * @cpu O(n)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public boolean contains(T element) {
        T t;
        ListIterator<T> listIterator = iterator();
        for (int i = 0; i < logicalSize; i++) {
            t = listIterator.next();
            if (element.equals(t)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Removes elements matching predicate.
     * n=logical size
     *
     * @param predicate the first date
     * @cpu O(n)
     * @ram O(1)
     * {@inheritDoc}
     */
    @Override
    public void removeIf(Predicate<? super T> predicate) {
        T t;
        for (T value : this) {
            t = value;
            if (predicate.test(t)) {
                remove(t);
            }
        }
    }


    /**
     * Make a compare between of two lists.
     * n=logicalSize
     *
     * @param obj the first term
     * @return result
     * @cpu 0(n)
     * @ram 0(1)
     * {@inheritDoc}
     */
    public boolean equals(Object obj) {
        if (obj instanceof List) {
            List<T> list = (List<T>) obj;
            ListIterator<T> listIterator = iterator();
            ListIterator<T> listIteratorSecond = list.iterator();
            if (this.logicalSize != list.size()) {
                return false;
            }
            while (listIterator.hasNext()) {
                if (!listIteratorSecond.next().equals(listIterator.next())) {
                    return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    /**
     * Create array of numbers.
     * n=logicalSize
     *
     * @return new array
     * @cpu 0(n)
     * @ram 0(n)
     * {@inheritDoc}
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        ListIterator<T> iterator = iterator();
        T t;
        while (iterator.hasNext()) {
            t = iterator.next();
            if (t != null) {
                stringBuilder.append(t);
            } else {
                stringBuilder.append("null");
            }
            if (iterator.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * Sorts element.
     *
     * @param comparator the first term
     *                   n=logical size
     * @cpu O(log ( n)*n)
     * @ram O(n)
     * {@inheritDoc}
     */
    @Override
    public void sort(Comparator<T> comparator) {
        T[] array = (T[]) toArray();
        ArrayUtils.mergeSort(array, comparator);
        ListIterator<T> iterator = iterator();
        for (int i = 0; i < logicalSize; i++) {
            iterator.set(array[i]);
            iterator.next();
        }
    }

    /**
     * Return array containing elements.
     * n=logicalSize;
     *
     * @return array
     * @cpu O(n)
     * @ram O(n)
     */
    public Object[] toArray() {
        Object[] array = new Object[logicalSize];
        int index = 0;
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            array[index++] = iterator.next();
        }
        return array;
    }

    /**
     * Returns an array with a size depending on the input data.
     *
     * @param factory the first term
     * @return array
     * {@inheritDoc}
     * @cpu O(n)
     * @ram O(n)
     */

    @Override
    public T[] toArray(IntFunction<T[]> factory) {
        ListIterator<T> listIterator = iterator();
        T[] array = factory.apply(logicalSize);
        for (int i = 0; i < array.length; i++) {
            array[i] = listIterator.next();
        }
        return array;
    }

}
