package collections;

import entities.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


public abstract class AbstractListTest {
    protected abstract List createList();

    protected abstract List of(Object... elements);


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
}