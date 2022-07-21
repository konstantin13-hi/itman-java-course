package collections;

import utils.ArrayUtils;
import utils.StringBuilder;

import java.util.Objects;

public class ArrayList {
    private int logicalSize;
    private int[] elements;

    /**
     * Create array with special length
     *
     * n=that.size
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param that the first term
     */
    public ArrayList(ArrayList that) {
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
    public ArrayList() {
        elements = new int[16];
    }

    /**
     * Create array
     *
     * @cpu 0(1)
     * @ram 0(n)
     *
     * @param capacity the first term
     */
    public ArrayList(int capacity) {
        elements = new int[capacity];
    }

    /**
     * Create a arraylist
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @param elements the first term
     * @return new arraylist
     */
    public static ArrayList of(int... elements) {
        ArrayList arrayList = new ArrayList(elements.length);
        for (int element : elements) {
            arrayList.add(element);
        }
        return arrayList;
    }

    /**
     * Add element
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param element the term
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
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param index the first term
     * @param element the second term
     */
    public void set(int index, int element) {
        elements[index] = element;
    }

    /**
     * Get index
     *
     * @cpu 0(1)
     * @ram 0(1)
     * @param index the first term
     * @return number from arraylist
     */
    public int get(int index) {
        return elements[index];
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
     *
     * n=that.size
     *
     * @cpu 0(n)
     * @ram 0(1)
     *
     * @param obj the first term
     *
     * @return result
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
     * @cpu 0(nlog(n))
     * @ram 0(n)
     */
    public void sort() {
        ArrayUtils.mergeSort(elements,0,logicalSize);
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

    public int[] toArray() {
        int[] newArray = new int[logicalSize];
        System.arraycopy(elements, 0, newArray, 0, newArray.length);
        return newArray;
    }

    /**
     * Create a string
     *
     * n=logicalSize
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return new string
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


