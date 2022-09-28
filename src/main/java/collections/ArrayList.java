package collections;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.Predicate;


public class ArrayList<T> implements List<T> {
    private T[] objects;
    private int logicalSize;

    /**
     * Create array with length 16.
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public ArrayList() {
        objects = (T[]) new Object[16];
    }

    /**
     * Create array.
     *
     * @param capacity the first term
     * @cpu 0(1)
     * @ram 0(n)
     */
    public ArrayList(int capacity) {
        objects = (T[]) new Object[capacity];
    }

    /**
     * Add element.
     *
     * @param element the term
     * @return boolean result
     * @cpu 0(1)
     * @ram 0(1)
     */

    @Override
    public boolean add(int index, T element) {
        if (logicalSize == 0) {
            add(element);
        } else {
            T[] t = (T[]) new Object[objects.length + 1];
            t[index] = element;
            System.arraycopy(objects, 0, t, 0, index);
            System.arraycopy(objects, index, t, index + 1, objects.length - index);
            logicalSize++;
            objects = t;

        }

        return true;
    }

    @Override
    public boolean add(T element) {
        if (logicalSize == objects.length) {
            T[] newObject = (T[]) new Object[logicalSize * 2];
            System.arraycopy(objects, 0, newObject, 0, objects.length);
            objects = newObject;
        }
        objects[logicalSize] = element;
        logicalSize++;
        return false;
    }

    @Override
    public ListIterator<T> iterator() {
        return new ArrayListIterator();
    }

    @Override
    public void sort(Comparator<T> comparator) {
        ArrayUtils.mergeSort(toArray(), comparator);
    }

    private class ArrayListIterator implements ListIterator<T> {
        private int current;

        public boolean hasNext() {
            return logicalSize > current;
        }

        public T next() {
            return objects[current++];
        }

        @Override
        public void set(T element) {
            objects[current] = element;
        }

        @Override
        public void insertBefore(T element) {
            add(current - 1, element);
        }
    }


    @Override
    public boolean addAll(Collection<T> collection) {
        for (T i : collection) {
            add(i);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<T> collection) {
        if (logicalSize == 0 || index + 1 == logicalSize) {
            int indexSecond = index;
            for (T i : collection) {
                add(indexSecond++, i);
            }
        } else {
            T[] t = (T[]) new Object[objects.length + collection.size()];
            System.arraycopy(objects, 0, t, 0, index);
            System.arraycopy(objects, index, t, index + collection.size(), objects.length - index);
            int indexSecond = index;
            for (T i : collection) {
                logicalSize++;
                t[indexSecond++] = i;
            }
            objects = t;
        }
        return true;
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < logicalSize; i++) {
            if (element.equals(objects[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < logicalSize; i++) {
            if (element.equals(objects[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Remove element.
     * n=size
     *
     * @param index the first term
     * @return new array without one element
     * @cpu 0(n)
     * @ram 0(1)
     */
    @Override
    public T remove(int index) {
        T object = get(index);
        for (int i = index + 1; i < objects.length; i++) {
            objects[i - 1] = objects[i];
        }
        logicalSize--;
        return object;
    }

    @Override
    public boolean containsAll(Collection<T> collection) {
        for (T i : collection) {
            if (!contains(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void removeAll(Collection<T> collection) {
        for (T i : collection) {
            remove(i);
        }

    }

    /**
     * Set element.
     *
     * @param index   the first term
     * @param element the second term
     * @cpu 0(1)
     * @ram 0(1)
     */
    @Override
    public void set(int index, T element) {
        objects[index] = element;
    }

    /**
     * Get index.
     *
     * @param index the first term
     * @return number from arraylist
     * @cpu 0(1)
     * @ram 0(1)
     */
    @Override
    public T get(int index) {
        return objects[index];
    }

    /**
     * Find size.
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     */
    @Override
    public int size() {
        return logicalSize;
    }

    @Override
    public boolean isEmpty() {
        return logicalSize == 0;
    }

    /**
     * Create array of numbers.
     * n=logicalSize
     *
     * @return new array
     * @cpu 0(n)
     * @ram 0(n)
     */
    @Override
    public T[] toArray() {
        T[] newObject = (T[]) new Object[logicalSize];
        System.arraycopy(objects, 0, newObject, 0, logicalSize);
        return newObject;
    }

    @Override
    public T[] toArray(IntFunction<T> factory) {
        T[] array = (T[]) factory.apply(logicalSize);
        for (int i = 0; i < array.length; i++) {
            array[i] = objects[i];
        }
        return array;
    }

    @Override
    public void removeIf(Predicate<T> predicate) {
        T t;
        ListIterator<T> listIterator = iterator();
        while (listIterator.hasNext()) {
            t = listIterator.next();
            if (predicate.test(t)) {
                remove(t);
            }
        }
    }

    /**
     * Create an arraylist.
     *
     * @param elements the first term
     * @param <T> type of objects
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     */

    public static <T> ArrayList<T> of(T... elements) {
        ArrayList<T> arrayList;
        if (elements.length == 0) {
            arrayList = new ArrayList<>();
        } else {
            arrayList = new ArrayList<>(elements.length);
        }
        for (T i : elements) {
            arrayList.add(i);

        }
        return arrayList;
    }

    /**
     * Create array of numbers.
     * n=logicalSize
     *
     * @return new array
     * @cpu 0(n)
     * @ram 0(n)
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < logicalSize; i++) {
            if (objects[i] != null) {
                stringBuilder.append(objects[i].toString());
            } else {
                stringBuilder.append("null");
            }
            if (i + 1 != logicalSize) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    /**
     * Make a compare between of two arraylists.
     * n=logicalSize
     *
     * @param that the first term
     * @return result
     * @cpu 0(n)
     * @ram 0(1)
     */
    public boolean equals(Object that) {
        if (this.getClass() != that.getClass()) {
            return false;
        }
        ArrayList<T> array = (ArrayList<T>) that;
        if (this.logicalSize != array.logicalSize) {
            return false;
        }
        for (int i = 0; i < array.logicalSize; i++) {
            if (!Objects.equals(array.get(i), this.get(i))) {
                return false;
            }
        }
        return true;

    }
}