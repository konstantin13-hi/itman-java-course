package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addFirst(){
        LinkedList linkedList =new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(13);
        linkedList.addFirst(3);
        Assertions.assertEquals(3,linkedList.getFirst());
        linkedList.removeFirst();
        Assertions.assertEquals(13,linkedList.getFirst());
    }

    @Test
    void String(){
            LinkedList linkedList =new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals("[3, 13, 10]",linkedList.toString());

        }


}