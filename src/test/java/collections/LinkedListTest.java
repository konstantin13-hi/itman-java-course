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



}