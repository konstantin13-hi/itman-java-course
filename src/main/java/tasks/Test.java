package tasks;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ListIterator<Integer> iterator = arrayList.listIterator();

        iterator.hasNext();
        iterator.next();
        iterator.next();


        arrayList.add(4);
        iterator.hasNext();
        iterator.hasNext();
        iterator.hasNext();
        iterator.hasNext();


        System.out.println(arrayList);


    }
}
