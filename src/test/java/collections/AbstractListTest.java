package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import tasks.MyString;


public abstract class AbstractListTest {
    protected abstract <T> List<T> createList();

    protected abstract <T> List<T> of(Object... elements);


    @Nested
    public class Add {
        @Test
        public void shouldAddElementWhenListIsNotEmpty() {
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
        public void shouldGetElementWhenListIsNotEmpty() {
            List list = of("12", 2, 1, new Ticket(1, "sde"));
            Assertions.assertEquals(1, list.get(2));
            Assertions.assertEquals("12", list.get(0));
        }
    }

    @Nested
    public class Remove {
        @Test
        public void shouldRemoveElementWhenListIsNotEmpty() {
            List list = of("12", 2, 1, new Ticket(1, "sde"));
            Assertions.assertEquals(1, list.remove(2));
            Assertions.assertEquals("12", list.remove(0));
            Assertions.assertArrayEquals(new Object[]{2, new Ticket(1, "sde")}, list.toArray());
        }
    }

    @Nested
    public class Set {
        @Test
        public void shouldSetElementWhenListIsNotEmpty() {
            List list = of(1, 2, 3, 4, 5);
            list.set(4, "1");
            list.set(3, "2");
            list.set(2, "3");
            list.set(1, "4");
            list.set(0, "5");
            Assertions.assertArrayEquals(new Object[]{"5", "4", "3", "2", "1"}, list.toArray());

        }

    }

    @Nested
    public class ToString {
        @Test
        public void shouldToStringWhenListIsNotEmpty() {
            List list = of(1, 2, 3, 4, 5);
            Assertions.assertEquals("[1, 2, 3, 4, 5]", list.toString());

        }

        @Test
        public void shouldToStringWhenListIsEmpty() {
            List list = of();
            Assertions.assertEquals("[]", list.toString());

        }
    }


    @Nested
    public class ToArray {
        @Test
        public void shouldToStringWhenListIsNotEmpty() {
            List list = of(1, 2, 3, 4, 5);
            Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.toArray());

        }

        @Test
        public void shouldToStringWhenListIsEmpty() {
            List list = of();
            Assertions.assertArrayEquals(new Object[]{}, list.toArray());

        }
    }

    @Nested
    public class Of {
        @Test
        public void shouldAddElementsWhenListIsEmpty() {
            List list = of(1, 2, 3, 4, 5);
            Assertions.assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.toArray());

        }

        @Test
        public void shouldAddZeroElementsWhenListIsEmpty() {
            List list = of();
            Assertions.assertArrayEquals(new Object[]{}, list.toArray());

        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldEqualsWhenSecondArrayHasNull() {
            List list = createList();
            list.add("A");
            list.add("B");
            list.add("C");
            list.add("D");
            list.add(null);
            List arrayListSecond = of("A", "B", "C", "D", "E");
            Assertions.assertNotEquals(list, arrayListSecond);
        }

        @Test
        public void shouldEqualsWhenAddEmptyString() {
            List list = of(new MyString(new char[]{}));
            Assertions.assertEquals(list,
                    of(new MyString(new char[]{})));
        }

        @Test
        public void shouldEqualsWhenDifferentTypes() {
            List list = of(new MyString(new char[]{}));
            Assertions.assertNotEquals(list,
                    of((Object) new Integer[]{1, 3, 3}));
        }
    }
}