package benchmarks;

import collections.IntArrayList;
import collections.LinkedList;

public class ListBenchmark {

    /**
     * Create array list with capacity
     *
     * n=length
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param length the first term
     * @return array list
     */
    public static IntArrayList createArrayListWithCapacity(int length) {
        IntArrayList intArrayList = new IntArrayList(length);
        for (int i = 0; i < length; i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     * Create array list
     *
     * n = length
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param length the first term
     * @return array list
     */

    public static IntArrayList createArrayList(int length) {
        IntArrayList intArrayList = new IntArrayList();
        for (int i = 0; i < length; i++) {
            intArrayList.add(i);
        }
        return intArrayList;
    }

    /**
     *Create linked list
     *
     * n = length
     *
     * @cpu O(n)
     * @ram O(n)
     *
     * @param length the first term
     * @return linked list
     */

    public static LinkedList createLinkedList(int length) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < length; i++) {
            linkedList.addLast(i);
        }
        return linkedList;

    }

    public static void main(String[] args) {
        int length = 10_000_000;
        // 30 ms
        long timeArrayWithCapacity = System.currentTimeMillis();
        createArrayListWithCapacity(length);
        System.out.println(System.currentTimeMillis() - timeArrayWithCapacity);

        //65 ms
        long timeArrayList = System.currentTimeMillis();
        createArrayList(length);
        System.out.println(System.currentTimeMillis() - timeArrayList);


        // 439 ms
        long timeLinkedList = System.currentTimeMillis();
        createLinkedList(length);
        System.out.println(System.currentTimeMillis() - timeLinkedList);

    }
}
