package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tasks.MyString;

class LinkedListTest extends AbstractListTest {

    @Override
    protected List createList() {
        return new LinkedList();
    }

    @Override
    protected List of(final Object... elements) {
        return LinkedList.of(elements);
    }

    @Nested
    public class AddFirst {
        @Test
        void shouldAddElementWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals(3, linkedList.getFirst());
            linkedList.removeFirst();
            Assertions.assertEquals(13, linkedList.getFirst());
        }

        @Test
        void s() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.removeFirst();
            linkedList.addFirst(4);
            Assertions.assertArrayEquals(new Integer[]{4}, linkedList.toArray());

        }
    }

    @Nested
    public class RemoveFirst {
        @Test
        void shouldWhen2() {
            LinkedList linkedList = new LinkedList();
            Ticket ticket = new Ticket(1, "A");
            linkedList.addLast(ticket);
            Assertions.assertEquals(ticket, linkedList.removeFirst());

        }
    }

    @Nested
    public class RemoveLast {
        @Test
        void shouldDeleteElementWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(3);
            Assertions.assertEquals(3, linkedList.removeLast());
        }

        @Test
        void shouldDeleteFirstAndLastElementsWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals(10, linkedList.removeLast());
        }

        @Test
        void shouldDeleteAllElementsWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals(10, linkedList.removeLast());
            Assertions.assertEquals(13, linkedList.removeLast());
            Assertions.assertEquals(3, linkedList.removeLast());
        }

        @Test
        void shouldWhen2() {
            LinkedList linkedList = new LinkedList();
            Ticket ticket = new Ticket(1, "A");
            linkedList.addLast(ticket);
            Assertions.assertEquals(ticket, linkedList.removeLast());

        }
    }

    @Nested
    public class GetLast {
        @Test
        void shouldGetLastElementWhenListHasSeveralElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(555);
            linkedList.addFirst(621);
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals(555, linkedList.getLast());
        }

        @Test
        void shouldGetLastElementWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(555);
            Assertions.assertEquals(555, linkedList.getLast());
        }
    }

    @Nested
    public class AddLast {
        @Test
        void shouldAddLastWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            linkedList.addLast(7);
            linkedList.addLast(6);
            linkedList.addLast(5);
            linkedList.addLast(4);
            Assertions.assertEquals("[10, 9, 8, 7, 6, 5, 4]", linkedList.toString());
        }
    }

    @Nested
    public class CreateLinkedList {

        @Test
        void shouldCreateSecondListWhenFirstIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            final LinkedList linkedList1 = new LinkedList(linkedList);
            linkedList.removeLast();
            linkedList.removeLast();
            linkedList.removeLast();
            Assertions.assertEquals("[10, 9, 8]", linkedList1.toString());
        }
    }

    @Nested
    public class Equals {
        @Test
        void shouldReturnTrueWhenTwoListsAreDifferent() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            LinkedList linkedListSecond = new LinkedList();
            linkedListSecond.addFirst(11);
            linkedListSecond.addFirst(1);
            linkedListSecond.addFirst(51);
            Assertions.assertNotEquals(linkedList, linkedListSecond);
        }

        @Test
        void shouldReturnTrueWhenListsHaveSameElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            LinkedList linkedListSecond = new LinkedList();
            linkedListSecond.addFirst(8);
            linkedListSecond.addFirst(9);
            linkedListSecond.addFirst(10);
            Assertions.assertEquals(linkedList, linkedListSecond);
        }

        @Test
        void shouldReturnFalseWhenFirstElementsAreSameInListsWithDifferentLength() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            LinkedList linkedListSecond = new LinkedList();
            linkedListSecond.addFirst(8);
            linkedListSecond.addFirst(9);
            Assertions.assertNotEquals(linkedList, linkedListSecond);
        }
    }
}