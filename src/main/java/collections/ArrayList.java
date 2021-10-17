package collections;

import utils.StringBuilder;

public class ArrayList {
    private int logicalSize;
    private int[] Elements;

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
        System.arraycopy(that.Elements, 0, arraySecond, 0, that.logicalSize);
        Elements = arraySecond;
    }

    /**
     * Create array with length 16
     *
     * @cpu 0(1)
     * @ram 0(1)
     */
    public ArrayList() {
        Elements = new int[16];
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
        Elements = new int[capacity];
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
        if (logicalSize ==Elements.length) {
            int capacity = Elements.length * 2;
            int[] secondarray = new int[capacity];
            System.arraycopy(Elements, 0, secondarray, 0, logicalSize);
            Elements = secondarray;
        }
        Elements[logicalSize] = element;
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
        Elements[index] = element;
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
        return Elements[index];
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
     * @ram 0(1)                     //
     *
     * @param index the first term
     * @return new array without one element
     */
    public int remove(int index) { // 1 2 3 4 5
        int remove = Elements[index];
        for (int i = index+1; i < Elements.length; i++) {
            Elements[i - 1] = Elements[i];
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
        Elements = toArray();
        for (int i = 0; i < Elements.length; i++) {
            for (int j = 1; j < Elements.length; j++) {
                if (Elements[j - 1] > Elements[j]) {
                    int temp = toArray()[j - 1];
                    Elements[j - 1] = Elements[j];
                    Elements[j] = temp;
                }
            }
        }
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
        System.arraycopy(Elements, 0, newArray, 0, newArray.length);
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
        StringBuilder stringBuilder = new StringBuilder(1);
        if(logicalSize!=0){
            stringBuilder.append("[");
            for (int i = 0; i<logicalSize;i++){
                stringBuilder.append(Elements[i]);
                if(i!=logicalSize-1){
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");

        }
        else {
            stringBuilder.append("[]");
        }

        return stringBuilder.toString();
    }


}


