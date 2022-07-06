package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addFirst() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(13);
        linkedList.addFirst(3);
        Assertions.assertEquals(3, linkedList.getFirst());
        linkedList.removeFirst();
        Assertions.assertEquals(13, linkedList.getFirst());
    }

    @Test
    void String() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(13);
        linkedList.addFirst(3);
        Assertions.assertEquals("[3, 13, 10]", linkedList.toString());

    }
    @Test
    void delete(){
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst(3);

        Assertions.assertEquals(3,linkedList.removeLast() );
    }

    @Test
    void delet2e(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(13);
        linkedList.addFirst(3);
        Assertions.assertEquals(10,linkedList.removeLast());
    }

    @Test
    void dele3t2e(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(13);
        linkedList.addFirst(3);
        Assertions.assertEquals(10,linkedList.removeLast());
        Assertions.assertEquals(13,linkedList.removeLast());
        Assertions.assertEquals(3,linkedList.removeLast());
    }

    @Test
    void getLast(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(555);
        linkedList.addFirst(621);
        linkedList.addFirst(10);
        linkedList.addFirst(13);
        linkedList.addFirst(3);
        Assertions.assertEquals(555,linkedList.getLast());
    }
    @Test
    void getLa3st(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(555);

        Assertions.assertEquals(555,linkedList.getLast());
    }
    @Test
    void addLast(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(555);
        linkedList.addLast(31);
        Assertions.assertEquals(31,linkedList.getLast());
    }

    @Test
   void addLaывst(){
       LinkedList linkedList = new LinkedList();
       linkedList.addLast(10);

       Assertions.assertEquals(10,linkedList.getLast());
   }

    @Test
    void addLaыв3st(){
        LinkedList linkedList = new LinkedList();
       linkedList.addLast(10);
      linkedList.addLast(9);
       linkedList.addLast(8);
        linkedList.addLast(7);
      linkedList.addLast(6);
       linkedList.addLast(5);
        linkedList.addLast(4);

        Assertions.assertEquals("[10, 9, 8, 7, 6, 5, 4]",linkedList.toString());
   }

   @Test
    void LinkeddList(){
       LinkedList linkedList = new LinkedList();
       linkedList.addLast(10);
       linkedList.addLast(9);
       linkedList.addLast(8);
       LinkedList linkedList1 = new LinkedList(linkedList);
       linkedList.removeLast();
       linkedList.removeLast();
       linkedList.removeLast();
       Assertions.assertEquals("[10, 9, 8]",linkedList1.toString());

   }
   @Test
    void bool(){
       LinkedList linkedList = new LinkedList();
       linkedList.addLast(10);
       linkedList.addLast(9);
       linkedList.addLast(8);
       LinkedList linkedListSecond = new LinkedList();
       linkedListSecond.addFirst(11);
       linkedListSecond.addFirst(1);
       linkedListSecond.addFirst(51);
       Assertions.assertFalse(linkedList.equals(linkedListSecond));
   }
    @Test
    void boolsda(){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(9);
        linkedList.addLast(8);
        LinkedList linkedListSecond = new LinkedList();
        linkedListSecond.addFirst(8);
        linkedListSecond.addFirst(9);
        linkedListSecond.addFirst(10);
        Assertions.assertTrue(linkedList.equals(linkedListSecond));
    }

    @Test
    void boolsdaDSF(){
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(9);
        linkedList.addLast(8);
        LinkedList linkedListSecond = new LinkedList();
        linkedListSecond.addFirst(8);
        linkedListSecond.addFirst(9);

        Assertions.assertFalse(linkedList.equals(linkedListSecond));
    }

    @Test
    void Array() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(9);
        linkedList.addLast(8);
        Assertions.assertArrayEquals(new int[]{10, 9, 8}, linkedList.toArray());
        Assertions.assertEquals(10, linkedList.removeFirst());
        Assertions.assertEquals(8, linkedList.removeLast());
    }

    @Test
    void seSt() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(9);
        linkedList.addFirst(8);
        linkedList.set(1, 2);
        Assertions.assertArrayEquals(new int[]{8, 2, 10}, linkedList.toArray());
        linkedList.set(0, 5);
        Assertions.assertArrayEquals(new int[]{5, 2, 10}, linkedList.toArray());
        linkedList.set(2, 4);
        Assertions.assertArrayEquals(new int[]{5, 2, 4}, linkedList.toArray());
    }

    @Test
    void get(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(9);
        linkedList.addFirst(8);
       Assertions.assertEquals(9,linkedList.get(1));



    }
    @Test
    void remove(){
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(9);
        linkedList.addFirst(8);
      //  linkedList.remove(1);
        Assertions.assertEquals(9, linkedList.remove(1));
        Assertions.assertArrayEquals(new int []{8,10},linkedList.toArray());
        Assertions.assertEquals(10, linkedList.remove(1));
        Assertions.assertArrayEquals(new int []{8},linkedList.toArray());
        Assertions.assertEquals(8, linkedList.remove(0));
    }

    @Test
    void removesda() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        Assertions.assertArrayEquals(new int[]{10}, linkedList.toArray());
        linkedList.remove(0);
        Assertions.assertArrayEquals(new int[]{}, linkedList.toArray());
    }
}