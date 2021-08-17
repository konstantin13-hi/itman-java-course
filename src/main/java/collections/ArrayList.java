package collections;

public class ArrayList {
    private int capacity;
    private int logicalsize;
    int[] array;
    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
    }
    public void add(int element){
        if (logicalsize==capacity){
            capacity=capacity*2;
            int [] secondarray=new int[capacity];
            if (logicalsize >= 0) System.arraycopy(array, 0, secondarray, 0, logicalsize);
            array=secondarray;

        }
        array[logicalsize]=element;
        logicalsize++;

    }
    public void set(int index, int element) {


        array[index] = element;
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        int realsize=capacity-logicalsize;
        return capacity-realsize;
    }
    public int[] toArray(){
        int [] newArray = new int[size()];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        return newArray;
    }
}


