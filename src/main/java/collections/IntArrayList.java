package collections;

import utils.ArrayUtils;
import utils.StringBuilder;

import java.util.Objects;

public class IntArrayList {
    private int logicalSize;
    private int[] elements;

    /**
     * Create array with special length
     * <p>
     * n=that.size
     *
     * @param that the first term
     * @cpu 0(n)
     * @ram 0(n)
     */
    public IntArrayList(IntArrayList that) {
        logicalSize = that.logicalSize;
        int[] arraySecond = new int[that.logicalSize];
        System.arraycopy(that.elements, 0, arraySecond, 0, that.logicalSize);
        elements = arraySecond;
    }

    /**
     * Create array with length 16
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public IntArrayList() {
        elements = new int[16];
    }

    /**
     * Create array
     *
     * @param capacity the first term
     * @cpu 0(1)
     * @ram 0(n)
     */
    public IntArrayList(int capacity) {
        elements = new int[capacity];
    }

    /**
     * Create a arraylist
     *
     * @param elements the first term
     * @return new arraylist
     * @cpu 0(n)
     * @ram 0(n)
     */
    public static IntArrayList of(int... elements) {
        IntArrayList intArrayList = new IntArrayList(elements.length);
        for (int element : elements) {
            intArrayList.add(element);
        }
        return intArrayList;
    }

    /**
     * Add element
     *
     * @param element the term
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void add(int element) { //метод add 10 в 9 раз выполняется/ в иф попадаем 30 раз и всего операций происходит 2 *10 в 9 /в среднем один вызов метода выполняется 2 раза
        if (logicalSize == elements.length) {
            int capacity = elements.length * 2;
            int[] secondArray = new int[capacity];
            System.arraycopy(elements, 0, secondArray, 0, logicalSize);
            elements = secondArray;
        }
        elements[logicalSize] = element;
        logicalSize++;
    }

    /**
     * Set element
     *
     * @param index   the first term
     * @param element the second term
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void set(int index, int element) {
        elements[index] = element;
    }

    /**
     * Get index
     *
     * @param index the first term
     * @return number from arraylist
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int get(int index) {
        return elements[index];
    }

    /**
     * Find size
     *
     * @return size
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int size() {
        return logicalSize;
    }

    /**
     * Remove element
     * <p>
     * n=size
     *
     * @param index the first term
     * @return new array without one element
     * @cpu 0(n)
     * @ram 0(1)
     */
    public int remove(int index) {
        int remove = elements[index];
        for (int i = index + 1; i < elements.length; i++) {
            elements[i - 1] = elements[i];
        }
        logicalSize--;

        return remove;
    }

    /**
     * Make a compare between of two arraylists
     * <p>
     * n=logicalSize
     *
     * @param obj the first term
     * @return result
     * @cpu 0(n)
     * @ram 0(n)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return Objects.equals(this.toString(), obj.toString());
    }

    /**
     * Make a sort of array
     *
     * @cpu 0(nlog ( n))
     * @ram 0(n)
     */
    public void sort() {
        ArrayUtils.mergeSort(elements, 0, logicalSize);
    }

    /**
     * Create array of numbers
     * <p>
     * n=logicalSize
     *
     * @return new array
     * @cpu 0(n)
     * @ram 0(n)
     */

    public int[] toArray() {
        int[] newArray = new int[logicalSize];
        System.arraycopy(elements, 0, newArray, 0, newArray.length);
        return newArray;
    }

    /**
     * Create a string
     * <p>
     * n=logicalSize
     *
     * @return new string
     * @cpu 0(n)
     * @ram 0(n)
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (logicalSize != 0) {
            stringBuilder.append("[");
            for (int i = 0; i < logicalSize; i++) {
                stringBuilder.append(elements[i]);
                if (i != logicalSize - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");

        } else {
            stringBuilder.append("[]");
        }
        return stringBuilder.toString();
    }
}


