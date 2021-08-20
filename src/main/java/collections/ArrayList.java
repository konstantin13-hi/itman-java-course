package collections;

public class ArrayList {
    private int capacity;
    private int logicalsize;
    int[] array;



    public ArrayList(ArrayList that){
        logicalsize=that.logicalsize;

        array= that.array;


    }

    public ArrayList(){
        this.capacity=16;
        array =new int[this.capacity];



    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
    }

    public void add(int element) {
        if (logicalsize == capacity) {
            capacity = capacity * 2;
            int[] secondarray = new int[capacity];
            if (logicalsize >= 0) System.arraycopy(array, 0, secondarray, 0, logicalsize);
            array = secondarray;

        }
        array[logicalsize] = element;
        logicalsize++;

    }

    public void set(int index, int element) {


        array[index] = element;
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        int realsize = capacity - logicalsize;
        return capacity - realsize;
    }

    public int remove(int index) {
        int remove = array[index];
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, newArray.length - index);
        array = newArray;
        logicalsize--;
        return remove;
    }

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

    public void sort() {
        array=toArray();
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

    public int[] toArray() {
        int[] newArray = new int[size()];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        return newArray;
    }
}


