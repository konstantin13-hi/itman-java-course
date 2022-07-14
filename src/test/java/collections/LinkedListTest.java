package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    @Nested
    public class AddFirst {
        @Test
        void addFirstShouldAddElementWhenListIsEmpty() {
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
    public class ReturnString {
        @Test
        void stringShouldReturnStringWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals("[3, 13, 10]", linkedList.toString());

        }

        @Test
        void stringShouldReturnStringWhenListIsEmpty() {
            LinkedList linkedList = new LinkedList();
            Assertions.assertEquals("[]", linkedList.toString());
        }

        @Test
        void stringShouldReturnStringWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(13);
            Assertions.assertEquals("[13]", linkedList.toString());
        }
    }

    @Nested
    public class Delete {
        @Test
        void deleteShouldDeleteElementWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(3);
            Assertions.assertEquals(3, linkedList.removeLast());
        }

        @Test
        void deleteShouldDeleteFirstAndLastElementsWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals(10, linkedList.removeLast());
        }

        @Test
        void deleteShouldDeleteAllElementsWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals(10, linkedList.removeLast());
            Assertions.assertEquals(13, linkedList.removeLast());
            Assertions.assertEquals(3, linkedList.removeLast());
        }
    }

    @Nested
    public class GetLast {
        @Test
        void getLastShouldGetLastElementWhenListHasSeveralElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(555);
            linkedList.addFirst(621);
            linkedList.addFirst(10);
            linkedList.addFirst(13);
            linkedList.addFirst(3);
            Assertions.assertEquals(555, linkedList.getLast());
        }

        @Test
        void getLastShouldGetLastElementWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(555);
            Assertions.assertEquals(555, linkedList.getLast());
        }
    }

    @Nested
    public class AddLast {
        @Test
        void addLastShouldAddLastWhenListIsEmpty() {
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
    public class MakeCopy {

        @Test
        void LinkedListShouldCreateSecondListWhenFirstIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            LinkedList linkedList1 = new LinkedList(linkedList);
            linkedList.removeLast();
            linkedList.removeLast();
            linkedList.removeLast();
            Assertions.assertEquals("[10, 9, 8]", linkedList1.toString());
        }
    }

    @Nested
    public class Bool {
        @Test
        void boolShouldReturnTrueWhenTwoListsAreDifferent() {
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
        void boolShouldReturnTrueWhenListsHaveSameElements() {
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
        void boolShouldReturnFalseWhenFirstElementsAreSameInListsWithDifferentLength() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            LinkedList linkedListSecond = new LinkedList();
            linkedListSecond.addFirst(8);
            linkedListSecond.addFirst(9);
            Assertions.assertFalse(linkedList.equals(linkedListSecond));
        }

    }

    @Nested
    public class ReturnArray {
        @Test
        void arrayShouldReturnArrayWhenListIsNotEmpty() {
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(10);
            linkedList.addLast(9);
            linkedList.addLast(8);
            Assertions.assertArrayEquals(new int[]{10, 9, 8}, linkedList.toArray());
            Assertions.assertEquals(10, linkedList.removeFirst());
            Assertions.assertEquals(8, linkedList.removeLast());
        }
    }

    @Nested
    public class Set {

        @Test
        void setShouldSetElementInAllIndexInListWhenListHasThreeElements() {
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
    }

    @Nested
    public class Get {
        @Test
        void getShouldGetMiddleElementWhenListHasMoreWhenTwoElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(9, linkedList.get(1));
        }

        @Test
        void getShouldGetFirstElementWhenListHasMoreWhenTwoElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(8, linkedList.get(0));

        }

        @Test
        void getShouldGetLastElementWhenListHasMoreWhenTwoElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(10, linkedList.get(2));
        }

        @Test
        void getShouldGetFirstElementWhenListHasOneElement() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            Assertions.assertEquals(10, linkedList.get(0));
        }


    }

    @Nested
    public class Remove {
        @Test
        void removeShouldRemoveAllElementWhenListHasThreeElements() {
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(10);
            linkedList.addFirst(9);
            linkedList.addFirst(8);
            Assertions.assertEquals(9, linkedList.remove(1));
            Assertions.assertArrayEquals(new int[]{8, 10}, linkedList.toArray());
            Assertions.assertEquals(10, linkedList.remove(1));
            Assertions.assertArrayEquals(new int[]{8}, linkedList.toArray());
            Assertions.assertEquals(8, linkedList.remove(0));
        }

    }

}