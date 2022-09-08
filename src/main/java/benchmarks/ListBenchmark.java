package benchmarks;

import collections.ArrayList;
import collections.IntArrayList;
import collections.LinkedList;

public class ListBenchmark {

    /**
     * Create array list with capacity.
     * n=length
     *
     * @param length the first term
     * @return array list
     * @cpu O(n)
     * @ram O(n)
     */
    // 30 ms
    public static IntArrayList createIntArrayListWithCapacity(int length) {
        IntArrayList intArrayList = new IntArrayList(length);
        for (int i = 0; i < length; i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     * Create array list.
     * n = length
     *
     * @param length the first term
     * @return array list
     * @cpu O(n)
     * @ram O(n)
     */
    //65 ms
    public static IntArrayList createIntArrayList(int length) {
        IntArrayList intArrayList = new IntArrayList();
        for (int i = 0; i < length; i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     * Create linked list.
     * n = length
     *
     * @param length the first term
     * @return linked list
     * @cpu O(n)
     * @ram O(n)
     */
    // 439 ms
    public static LinkedList createLinkedList(int length) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < length; i++) {
            linkedList.addLast(i);
        }
        return linkedList;

    }

    /**
     * Create array list.
     *
     * @param length the first term
     * @return the first term
     * @cpu O(n)
     * @ram O(n)
     */

    //350
    public static ArrayList createArrayList(int length) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    // 30 ms create IntArrayList With Capacity
    // 65 ms create IntArrayList
    // 439 ms create LinkedList
    // 350 ms create ArrayList
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
