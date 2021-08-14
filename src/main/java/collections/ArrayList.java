package collections;

public class ArrayList {
    private int capacity;

    public ArrayList(int capacity) {
        this.capacity = capacity;
    }

    int[] array;


    public void set(int index, int element) {

        array = new int[this.capacity];
        array[index] = element;
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return capacity;
    }
}
