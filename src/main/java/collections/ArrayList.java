package collections;

import java.util.Objects;

public class ArrayList {
    private Object[] objects;
    private int logicalSize;


    public ArrayList() {
        objects = new Object[16];
    }

    public ArrayList(int capacity) {
        objects = new Object[capacity];
    }

    public void add(Object element) {
        if (logicalSize == objects.length) {
            Object[] newObject = new Object[logicalSize * 2];
            System.arraycopy(objects, 0, newObject, 0, objects.length);
            objects = newObject;
        }
        objects[logicalSize] = element;
        logicalSize++;
    }

    public void set(int index, Object element) {
        objects[index] = element;
    }

    public Object get(int index) {
        return objects[index];
    }

    public int size() {
        return logicalSize;
    }

    public Object[] toArray() {
        Object[] newObject = new Object[logicalSize];
        System.arraycopy(objects, 0, newObject, 0, logicalSize);
        return newObject;
    }

    public Object remove(int index) {
        Object object = get(index);
        for (int i = index + 1; i < objects.length; i++) {
            objects[i - 1] = objects[i];
        }
        logicalSize--;
        return object;
    }

    public static ArrayList of(Object... elements) {
        ArrayList arrayList = new ArrayList(elements.length);
        for (Object i : elements) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (int i = 0; i < logicalSize; i++) {
            stringBuilder.append(objects[i].toString());
            if (i + 1 != logicalSize) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public boolean equals(Object that) {
        if (that == null) {
            return false;
        }
        return Objects.equals(this.toString(), that.toString()) && that.getClass() == ArrayList.class;
    }

}
