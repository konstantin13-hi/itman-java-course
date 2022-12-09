package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

class CollectionTest<T> {

    @Nested
    public class AddAll {
        @Test
        public void shouldAddWhenDifferentObjects() {
            LinkedList linkedList = new LinkedList();
            linkedList.add("1");
            linkedList.add("1");
            linkedList.addLast(3);
            LinkedList linkedList1 = new LinkedList();
            linkedList1.addAll(linkedList);
            Assertions.assertArrayEquals(new Object[]{"1", "1", 3}, linkedList1.toArray());
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveWhenIsNotEmpty() {
            Collection collection = new LinkedList();
            collection.add(1);
            collection.add(1);
            collection.remove(1);
            Assertions.assertArrayEquals(new Object[]{1}, collection.toArray());

        }

        @Test
        public void shouldRemoveFromDifferentPositionWhenIsNotEmpty() {
            Collection collection = new LinkedList();
            collection.add(1);
            collection.add(15);
            collection.add(13);
            collection.add(12);
            collection.add(11);
            collection.add(16);
            collection.remove(12);
            Assertions.assertArrayEquals(new Object[]{1, 15, 13, 11, 16}, collection.toArray());
            collection.remove(1);
            Assertions.assertArrayEquals(new Object[]{15, 13, 11, 16}, collection.toArray());
            collection.remove(16);
            Assertions.assertArrayEquals(new Object[]{15, 13, 11}, collection.toArray());

        }
    }

    @Nested
    public class Contain {
        @Test
        public void shouldCheckElementWhenIsNotEmpty() {
            Collection collection = new LinkedList();
            collection.add("1");
            Assertions.assertTrue(collection.contains("1"));

        }
    }

    @Nested
    public class ContainsAll {
        @Test
        public void shouldCheckElementWhenIsNotEmpty() {
            Collection collection = new LinkedList();
            collection.add("1");
            collection.add("13");
            collection.add(3);
            collection.add(2.3);
            Collection collection1 = new LinkedList();
            collection1.add("1");
            collection1.add(2.3);
            Assertions.assertTrue(collection.containsAll(collection1));

        }
    }

    @Nested
    public class RemoveAll {
        @Test
        public void shouldRemoveElementsWhenIsNotEmpty() {
            Collection collection = new LinkedList();
            collection.add("1");
            collection.add("13");
            collection.add(3);
            collection.add(2.3);
            Collection collection1 = new LinkedList();
            collection1.add("1");
            collection1.add(3);
            collection.removeAll(collection1);
            Assertions.assertArrayEquals(new Object[]{"13", 2.3}, collection.toArray());


        }
    }

}


