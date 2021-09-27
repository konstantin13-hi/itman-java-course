package collections;

import utils.StringBuilder;

public class ArrayList {
    private int capacity;
    private int logicalsize;
    private int[] array;

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
        logicalsize = that.logicalsize;
        capacity = that.capacity;
        int[] arraySecond = new int[that.capacity];
        System.arraycopy(that.array, 0, arraySecond, 0, that.capacity);
        array = arraySecond;
    }

    /**
     * Create array with length 16
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public ArrayList() {
        this.capacity = 16;
        array = new int[this.capacity];
    }

    /**
     * Create array
     *
     * @cpu 0(1)
     * @ram 0(n)
     *
     * @param capacity the first termin
     */
    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
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
        if (logicalsize == capacity) {
            capacity = capacity * 2;
            int[] secondarray = new int[capacity];
            System.arraycopy(array, 0, secondarray, 0, logicalsize);
            array = secondarray;
        }
        array[logicalsize] = element;
        logicalsize++;

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
        array[index] = element;
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
        return array[index];
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
        return logicalsize;
    }

    /**
     * Remove element
     *
     * n=size-1
     *
     * @cpu 0(1)
     * @ram 0(n)                     //
     *
     * @param index the first term
     * @return new array without one element
     */
    public int remove(int index) {
        int remove = array[index];
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, newArray.length - index);
        array = newArray;
        logicalsize--;
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
     * @param that the first term
     *
     * @return result
     */
    public boolean equals(ArrayList that) {
        if (that == null) {
            return false;
        }
        boolean result = that.size() == this.size();
        for (int i = 0; i < that.size(); i++) {
            if (that.get(i) != this.get(i)) {
                result = false;

            }
        }
        return result;
    }

    /**
     * Make a sort of array
     *
     * @cpu 0(n^2)
     * @ram 0(1)
     */
    public void sort() {
        array = toArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j - 1] > array[j]) {
                    int temp = toArray()[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * Create array of numbers
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return new array
     */

    public int[] toArray() {
        int[] newArray = new int[size()];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        return newArray;
    }

    /**
     * Create a string
     *
     * @cpu 0(n^2)
     * @ram 0(n)
     *
     * @return new string
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(1);
        if (toArray().length != 0) {
            stringBuilder.append("[");
            for (int i = 0; i < toArray().length; i++) {
                stringBuilder.append(toArray()[i]);
                if (i != toArray().length - 1) {
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


