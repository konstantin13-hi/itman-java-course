package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public class ListTest {

    public abstract static class AbstractListTests {
        abstract protected List createList();

        abstract protected List of(Object... elements);


        @Nested
        public class Add {
            @Test
            public void shouldAddElementWhenListIsEmpty() {
                List list = createList();
                list.add(1);
                Assertions.assertArrayEquals(new Object[]{1}, list.toArray());
                list.add("5");
                list.add(6);
                Assertions.assertArrayEquals(new Object[]{1, "5", 6}, list.toArray());
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

    public static class ArrayListTests extends AbstractListTests {
        @Override
        protected List createList() {
            return new ArrayList();
        }

        @Override
        protected List of(final Object... elements) {
            return ArrayList.of(elements);
        }
    }


    public static class LinkedListTests extends AbstractListTests {
        @Override
        protected List createList() {
            return new LinkedList();
        }

        @Override
        protected List of(final Object... elements) {
            return LinkedList.of(elements);
        }
    }

}