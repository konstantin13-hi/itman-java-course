package collections;

import java.util.Objects;

public class ArrayList implements List {
    private Object[] objects;
    private int logicalSize;

    /**
     * Create array with length 16.
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public ArrayList() {
        objects = new Object[16];
    }

    /**
     * Create array.
     *
     * @param capacity the first term
     * @cpu 0(1)
     * @ram 0(n)
     */
    public ArrayList(int capacity) {
        objects = new Object[capacity];
    }

    /**
     * Add element.
     *
     * @param element the term
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void add(Object element) {
        if (logicalSize == objects.length) {
            Object[] newObject = new Object[logicalSize * 2];
            System.arraycopy(objects, 0, newObject, 0, objects.length);
            objects = newObject;
        }
        objects[logicalSize] = element;
        logicalSize++;
    }

    /**
     * Set element.
     *
     * @param index   the first term
     * @param element the second term
     * @cpu 0(1)
     * @ram 0(1)
     */

    public void set(int index, Object element) {
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

    public Object get(int index) {
        return objects[index];
    }

    /**
     * Find size.
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     */

    public int size() {
        return logicalSize;
    }

    /**
     * Create array of numbers.
     * n=logicalSize
     *
     * @return new array
     * @cpu 0(n)
     * @ram 0(n)
     */

    public Object[] toArray() {
        Object[] newObject = new Object[logicalSize];
        System.arraycopy(objects, 0, newObject, 0, logicalSize);
        return newObject;
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

    public Object remove(int index) {
        Object object = get(index);
        for (int i = index + 1; i < objects.length; i++) {
            objects[i - 1] = objects[i];
        }
        logicalSize--;
        return object;
    }

    /**
     * Create an arraylist.
     *
     * @param elements the first term
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     */

    public static ArrayList of(Object... elements) {
        ArrayList arrayList;
        if (elements.length == 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList(elements.length);
        }
        for (Object i : elements) {
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
        if (that == null || this.getClass() != that.getClass() || this.logicalSize != ((ArrayList) that).logicalSize) {
            return false;
        }
        for (int i = 0; i < logicalSize; i++) {
            if (((ArrayList) that).get(i) != this.get(i)) {
                return false;
            }
        }
        return true;
    }

}
