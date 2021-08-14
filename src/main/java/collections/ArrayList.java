package collections;

public class ArrayList {
    private int capacity;
    int[] array;
    public ArrayList(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
    }




    public void set(int index, int element) {


        array[index] = element;
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return capacity;
    }
}
