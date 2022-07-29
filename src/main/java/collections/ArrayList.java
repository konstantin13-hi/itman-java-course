package collections;

import java.util.Objects;

public class ArrayList implements List {
    private Object[] objects;
    private int logicalSize;


    public ArrayList() {
        objects = new Object[16];
    }

    public ArrayList(int capacity) {
        objects = new Object[capacity];
    }
    /**
     * Add element
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param element the term
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
     * Set element
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param index the first term
     * @param element the second term
     */

    public void set(int index, Object element) {
        objects[index] = element;
    }
    /**
     * Get index
     *
     * @cpu 0(1)
     * @ram 0(1)
     * @param index the first term
     * @return number from arraylist
     */

    public Object get(int index) {
        return objects[index];
    }
    /**
     * Find size
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return size
     */

    public int size() {
        return logicalSize;
    }
    /**
     * Create array of numbers
     *
     * n=logicalSize
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return new array
     */

    public Object[] toArray() {
        Object[] newObject = new Object[logicalSize];
        System.arraycopy(objects, 0, newObject, 0, logicalSize);
        return newObject;
    }
    /**
     * Remove element
     *
     * n=size
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param index the first term
     * @return new array without one element
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
     * Create an arraylist
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param elements the first term
     * @return new arraylist
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
     * Create array of numbers
     *
     * n=logicalSize
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return new array
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
     * Make a compare between of two arraylists
     *
     * n=logicalSize
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param that the first term
     *
     * @return result
     */
    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        return Objects.equals(this.toString(), that.toString()) && that.getClass() == ArrayList.class;
    }

}
