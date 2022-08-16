package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedListTest {
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
    }

    @Nested
    public class ToString {
        @Test
        void shouldReturnStringWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals("[3, 13, 10]", linkedList.toString());

        }

        @Test
        void shouldReturnStringWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList();
            Assertions.assertEquals("[]", linkedList.toString());
        }

        @Test
        void shouldReturnStringWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(13);
            Assertions.assertEquals("[13]", linkedList.toString());
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

        @Test
        void shouldReturnTrueWhenArrayAndLinkedListsHaveSameElements() {
            LinkedList linkedList = LinkedList.of(10, 20, 30);
            IntArrayList intArrayList = IntArrayList.of(10, 20, 30);
            Assertions.assertNotEquals(linkedList, intArrayList);

        }

    }

    @Nested
    public class ToArray {
        @Test
        void shouldReturnArrayWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            Assertions.assertArrayEquals(new Object[]{10, 9, 8}, linkedList.toArray());
            Assertions.assertEquals(10, linkedList.removeFirst());
            Assertions.assertEquals(8, linkedList.removeLast());
        }
    }

    @Nested
    public class Set {

        @Test
        void shouldSetElementInAllIndexInListWhenListHasThreeElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            linkedList.set(1, 2);
            Assertions.assertArrayEquals(new Object[]{8, 2, 10}, linkedList.toArray());
            linkedList.set(0, 5);
            Assertions.assertArrayEquals(new Object[]{5, 2, 10}, linkedList.toArray());
            linkedList.set(2, 4);
            Assertions.assertArrayEquals(new Object[]{5, 2, 4}, linkedList.toArray());
        }
    }

    @Nested
    public class Get {
        @Test
        void shouldGetMiddleElementWhenListHasMoreWhenTwoElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(9, linkedList.get(1));
        }

        @Test
        void shouldGetFirstElementWhenListHasMoreWhenTwoElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(8, linkedList.get(0));

        }

        @Test
        void shouldGetLastElementWhenListHasMoreWhenTwoElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(10, linkedList.get(2));
        }

        @Test
        void shouldGetFirstElementWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            Assertions.assertEquals(10, linkedList.get(0));
        }


    }

    @Nested
    public class Remove {
        @Test
        void shouldRemoveAllElementWhenListHasThreeElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(9, linkedList.remove(1));
            Assertions.assertArrayEquals(new Object[]{8, 10}, linkedList.toArray());
            Assertions.assertEquals(10, linkedList.remove(1));
            Assertions.assertArrayEquals(new Object[]{8}, linkedList.toArray());
            Assertions.assertEquals(8, linkedList.remove(0));
        }

    }


}