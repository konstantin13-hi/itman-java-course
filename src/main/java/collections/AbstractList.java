package collections;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Predicate;

public abstract class AbstractList<T> implements List<T> {
    int logicalSize;
    int modify;

    /**
     * Adds element into list.
     *
     * @param collection the first term
     * @return boolean result. If change size then will return true
     */
    public boolean addAll(Collection<? extends T> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection is Null");
        }
        if (this == collection) {
            throw new IllegalArgumentException("Collection cannot be passed to itself");
        }
        modify++;
        return addAll(logicalSize, collection);
    }

    /**
     * Return size.
     *
     * @return size
     */
    public int size() {
        return logicalSize;
    }

    /**
     * Check list empty or not.
     *
     * @return result
     */
    public boolean isEmpty() {
        return logicalSize == 0;
    }

    /**
     * Removes all are contained elements.
     *
     * @param collection the first term
     */
    public void removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection is Null");
        }
        if (this == collection) {
            throw new IllegalArgumentException("Collection cannot be passed to itself");
        }
        for (Object i : collection) {
            Iterator<T> iterator = this.iterator();
            while (iterator.hasNext()) {
                if (Objects.equals(iterator.next(), i)) {
                    iterator.remove();
                }
            }
        }
        modify++;
    }

    /**
     * Removes element.
     *
     * @param element the first term
     * @return boolean result.If change size then will return true
     */
    public T remove(Object element) {
        T t;
        Iterator<T> i = this.iterator();
        while (i.hasNext()) {
            t = i.next();
            if (Objects.equals(t, element)) {
                i.remove();
                modify++;
                return t;
            }
        }
        return null;

    }


    /**
     * Cheeks if an array contains element.
     *
     * @param collection the first term
     * @return boolean result.If current object has same elements then will return true
     */
    @Override
    public boolean containsAll(Collection<? extends T> collection) {
        if (collection == null) {
            throw new NullPointerException("Collection is Null");
        }
        if (this == collection) {
            throw new IllegalArgumentException("Collection cannot be passed to itself");
        }
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
     */
    @Override
    public boolean contains(Object element) {
        T t;
        ListIterator<T> listIterator = iterator();
        for (int i = 0; i < logicalSize; i++) {
            t = listIterator.next();
            if (Objects.equals(t, element)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Removes elements matching predicate.
     *
     * @param predicate the first date
     */
    @Override
    public void removeIf(Predicate<? super T> predicate) {
        if (predicate == null) {
            throw new NullPointerException("Predicate is Null");
        }
        T t;
        ListIterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            t = iterator.next();
            if (predicate.test(t)) {
                iterator.remove();

            }
        }
    }


    /**
     * Make a compare between of two lists.
     *
     * @param obj the first term
     * @return result
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }
        if (obj instanceof List) {
            List<T> list = (List<T>) obj;
            ListIterator<T> listIterator = iterator();
            ListIterator<T> listIteratorSecond = list.iterator();
            if (this.logicalSize != list.size()) {
                return false;
            }
            while (listIterator.hasNext()) {
                if (!Objects.equals(listIteratorSecond.next(), listIterator.next())) {
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
     *
     * @return new array
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
     * Sort elements.
     *
     * @param comparator the first term
     */
    @Override
    public void sort(Comparator<? super T> comparator) {
        if (comparator == null) {
            throw new NullPointerException("Comparator is null");
        }
        T[] array = (T[]) toArray();
        ArrayUtils.mergeSort(array, comparator);
        ListIterator<T> iterator = iterator();
        for (int i = 0; i < logicalSize; i++) {
            iterator.next();
            iterator.set(array[i]);

        }
    }

    /**
     * Return array containing elements.
     *
     * @return array
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
     */

    @Override
    public T[] toArray(IntFunction<T[]> factory) {
        if (factory == null) {
            throw new NullPointerException("IntFunction is null");
        }
        ListIterator<T> listIterator = iterator();
        T[] array = factory.apply(logicalSize);
        for (int i = 0; i < array.length; i++) {
            array[i] = listIterator.next();
        }
        return array;
    }



}
