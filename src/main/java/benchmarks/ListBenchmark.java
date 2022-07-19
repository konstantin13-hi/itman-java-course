package benchmarks;

import collections.ArrayList;
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
    public static ArrayList createArrayListWithCapacity(int length) {
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        return arrayList;
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

    public static ArrayList createArrayList(int length) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        return arrayList;
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
