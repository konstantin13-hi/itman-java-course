package benchmarks;

import collections.ArrayList;
import collections.IntArrayList;
import collections.LinkedList;

public class ListBenchmark {

    /**
     * Create array list with capacity
     * <p>
     * n=length
     *
     * @param length the first term
     * @return array list
     * @cpu O(n)
     * @ram O(n)
     */
    public static IntArrayList createIntArrayListWithCapacity(int length) {
        IntArrayList intArrayList = new IntArrayList(length);
        for (int i = 0; i < length; i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     * Create array list
     * <p>
     * n = length
     *
     * @param length the first term
     * @return array list
     * @cpu O(n)
     * @ram O(n)
     */

    public static IntArrayList createIntArrayList(int length) {
        IntArrayList intArrayList = new IntArrayList();
        for (int i = 0; i < length; i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     * Create linked list
     * <p>
     * n = length
     *
     * @param length the first term
     * @return linked list
     * @cpu O(n)
     * @ram O(n)
     */

    public static LinkedList createLinkedList(int length) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < length; i++) {
            linkedList.addLast(i);
        }
        return linkedList;

    }

    public static ArrayList createArrayList(int length) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int length = 10_000_000;
        // 30 ms
        long timeArrayWithCapacity = System.currentTimeMillis();
        createIntArrayListWithCapacity(length);
        System.out.println(System.currentTimeMillis() - timeArrayWithCapacity);

        //65 ms
        long timeIntArrayList = System.currentTimeMillis();
        createIntArrayList(length);
        System.out.println(System.currentTimeMillis() - timeIntArrayList);


        // 439 ms
        long timeLinkedList = System.currentTimeMillis();
        createLinkedList(length);
        System.out.println(System.currentTimeMillis() - timeLinkedList);

        //350
        long timeArrayList = System.currentTimeMillis();
        createArrayList(length);
        System.out.println(System.currentTimeMillis() - timeArrayList);

    }
}
