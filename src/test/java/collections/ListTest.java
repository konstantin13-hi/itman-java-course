package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class ListTest {

    @Nested
    public class addAll {
        @Test
        public void shouldWhen() {
            List collection = new ArrayList();
            collection.add("1");
            collection.add("13");
            collection.add(3);
            collection.add(2.3);
            collection.add(2, 999);
            Assertions.assertArrayEquals(new Object[]{"1", "13", 999, 3, 2.3}, collection.toArray());
        }

        @Test
        public void shouldWhen1() {
            List collection = new LinkedList();
            collection.add("1");
            collection.add("13");
            collection.add(3);
            collection.add(2.3);
            collection.add(2, 999);
            Assertions.assertArrayEquals(new Object[]{"1", "13", 999, 3, 2.3}, collection.toArray());
        }
    }

    @Nested
    public class addAll2 {
        @Test
        public void shouldWhen() {
            List collection = new ArrayList();
            collection.add("1");
            collection.add("13");
            collection.add(3);
            collection.add(2.3);
            Collection<Integer> collection1 = new ArrayList();
            collection1.add(5);
            collection1.add(5);
            collection1.add(5);
            collection.addAll(1, collection1);
            Assertions.assertArrayEquals(new Object[]{"1", 5, 5, 5, "13", 3, 2.3}, collection.toArray());
            collection.addAll(6, collection1);
            Assertions.assertArrayEquals(new Object[]{"1", 5, 5, 5, "13", 3, 5,5,5,2.3}, collection.toArray());

        }
    }

    public abstract static class AbstractListTests {
        abstract protected List createList();

        abstract protected List of(Object... elements);


        @Nested
        public class Add<T> {
            @Test
            public void shouldAddElementWhenListIsEmpty() {
                List list = createList();
                list.add(1);
                Assertions.assertArrayEquals(new Object[]{1}, list.toArray());
                list.add("5");
                list.add(6);
                Assertions.assertArrayEquals(new Object[]{1, "5", 6}, list.toArray());
            }

            @Test
            public void shouldAddElementWhenListIsEmpty1() {
                List<Object> list = createList();
                list.add(1);
                list.add("5");
                list.add(6);
                list.add(2, 999);
                Assertions.assertArrayEquals(new Object[]{1, "5", 999, 6}, list.toArray());
            }
        }


        @Nested
        public class Get {
            @Test
            public void shouldGetElementWhenListIsEmpty() {
                List list = of("12", 2, 1, new Ticket(1, "sde"));
                Assertions.assertEquals(1, list.get(2));
                Assertions.assertEquals("12", list.get(0));
            }
        }


        @Nested
        public class Remove {
            @Test
            public void shouldRemoveElementWhenListIsEmpty() {
                List list = of("12", 2, 1, new Ticket(1, "sde"));
                Assertions.assertEquals(1, list.remove(2));
                Assertions.assertEquals("12", list.remove(0));
                Assertions.assertArrayEquals(new Object[]{2, new Ticket(1, "sde")}, list.toArray());
            }
        }

    }

    public static class ArrayListTests<T> extends AbstractListTests {
        @Override
        protected List<T> createList() {
            return new ArrayList<>();
        }

        protected List of(final Object... elements) {
            return LinkedList.of(elements);
        }
    }


    public static class LinkedListTests<T> extends AbstractListTests {

        @Override
        protected List<T> createList() {
            return new LinkedList<>();
        }

        protected List of(final Object... elements) {
            return LinkedList.of(elements);
        }
    }

}