package collections;

import utils.ArrayUtils;

import java.util.Comparator;
import java.util.function.IntFunction;
import java.util.function.Predicate;


public class ArrayList<T> extends AbstractList<T> implements List<T> {
    private T[] objects;


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
     * {@inheritDoc}
     */
    public ArrayList(int capacity) {
        objects = (T[]) new Object[capacity];
    }

    /**
     * Create an arraylist.
     *
     * @param elements the first term
     * @param <T>      type of objects
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     * {@inheritDoc}
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
     * Add element in the back of list.
     *
     * @param index   the first term
     * @param element the second term
     * @return boolean result.If change size then will return true
     * @cpu O(n)
     * @ram O(1)
     * {@inheritDoc}
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

    /**
     * Add element in the back of list.
     *
     * @return boolean result.If change size then will return true
     * @cpu O(1)
     * @ram O(1)
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     *
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public ListIterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * Sorts element.
     * //* @param comparator the first term
     * n=logical size
     *
     * @cpu O(log ( n)*n)
     * @ram O(n)
     * {@inheritDoc}
     */


    private class ArrayListIterator implements ListIterator<T> {
        private int current;

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        public boolean hasNext() {
            return logicalSize > current;
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        public T next() {
            return objects[current++];
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        public T current() {
            return objects[current];
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        @Override
        public void set(T element) {
            objects[current] = element;
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        @Override
        public void insertBefore(T element) {
            add(current, element);
        }

        /**
         * {@inheritDoc}
         *
         * @cpu O(1)
         * @ram O(1)
         */
        @Override
        public void remove() {
            ArrayList.this.remove(current);

        }
    }




    /**
     * Adds element in index position.
     *
     * @param index      the first term
     * @param collection the second term
     * @return boolean result.If change size then will return true
     * m=collection's size
     * n=logical size
     * @cpu O(n + m)
     * @ram O(m)
     * {@inheritDoc}
     */
    @Override
    public boolean addAll(int index, Collection<? extends T> collection) {
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
    public boolean addAll(Collection<? extends T> collection) {
        return super.addAll(collection);
    }


    /**
     * Remove element.
     * n=size
     *
     * @param index the first term
     * @return new array without one element
     * @cpu 0(n)
     * @ram 0(1)
     * {@inheritDoc}
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
    public T remove(Object element) {
        return super.remove(element);
    }


    /**
     * Set element.
     *
     * @param index   the first term
     * @param element the second term
     * @cpu 0(1)
     * @ram 0(1)
     * {@inheritDoc}
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
     * {@inheritDoc}
     */
    @Override
    public T get(int index) {
        return objects[index];
    }

    /**
     * {@inheritDoc}
     *
     * @cpu O(1)
     * @ram O(1)
     */
    @Override
    public int size() {
        return super.size();
    }

    /**
     * {@inheritDoc}
     * n=logical size
     *
     * @cpu O(n)
     * @ram O(1)
     */
    @Override
    public void removeIf(Predicate<? super T> predicate) {
        super.removeIf(predicate);
    }

    /**
     * {@inheritDoc}
     *
     * @cpu O(n)
     * @ram O(1)
     */
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    /**
     * {@inheritDoc}
     *
     * @cpu O(n*m)
     * @ram O(1)
     */
    @Override
    public void removeAll(Collection<? extends T> collection) {
        super.removeAll(collection);
    }

    /**
     * {@inheritDoc}
     * n = logical size
     * m = collection's size
     *
     * @cpu O(n * m)
     * @ram O(1)
     */
    @Override
    public boolean containsAll(Collection<? extends T> collection) {
        return super.containsAll(collection);
    }

    /**
     * {@inheritDoc}
     * n = logical size
     *
     * @cpu O(n)
     * @ram O(1)
     */
    @Override
    public boolean contains(T element) {
        return super.contains(element);
    }

    /**
     * {@inheritDoc}
     * n = logical size
     *
     * @cpu O(n)
     * @ram O(1)
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * {@inheritDoc}
     *
     * @cpu O(n*log(n))
     * @ram O(n)
     */
    @Override
    public void sort(Comparator<T> comparator) {
        super.sort(comparator);
    }

    /**
     * {@inheritDoc}
     * n = logical size
     *
     * @cpu O(n)
     * @ram O(n)
     */
    @Override
    public Object[] toArray() {
        return super.toArray();
    }

    /**
     * {@inheritDoc}
     * n = factory's size
     *
     * @cpu O(n)
     * @ram O(n)
     */
    @Override
    public T[] toArray(IntFunction<T[]> factory) {
        return super.toArray(factory);
    }

}