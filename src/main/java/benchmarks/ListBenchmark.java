package benchmarks;

import collections.ArrayList;
import collections.LinkedList;

public class ListBenchmark {

    public static ArrayList createArrayListWithCapacity(int length) {
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static ArrayList createArrayList(int length) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < length; i++) {
            arrayList.add(i);
        }
        return arrayList;
    }

    public static LinkedList createLinkedList(int length) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < length; i++) {
            linkedList.addLast(i);
        }
        return linkedList;

    }

    public static void main(String[] args) {
        int length = 10_000_000;
        // 1 sec 401 ms
        ArrayList arrayListWithCapacity =createArrayListWithCapacity(length);
        //2 sec 427 ms
        ArrayList arrayList =createArrayList(length);
        // 1 sec 220 ms
        LinkedList linkedList =createLinkedList(length);

    }
}
