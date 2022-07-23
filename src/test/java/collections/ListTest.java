package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ListTest {

    public abstract static class AbstractListTests {
        abstract protected List of(Object... elements);

        @Nested
        public class Add {
            @Test
            public void shouldAddElementWhenListIsEmpty() {
                List list = of();
                list.add(1);
                Assertions.assertArrayEquals(new Object[]{1}, list.toArray());
            }
        }
    }
    public static class ArrayListTests extends AbstractListTests {
        @Override
        protected List of(final Object... elements) {
            return ArrayList.of(elements);
        }
    }

    public static class LinkedListTests extends AbstractListTests {
        @Override
        protected List of(final Object... elements) {
            return LinkedList.of(elements);
        }
    }

}