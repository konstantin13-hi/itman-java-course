package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Nested
    public class Push {
        @Test
        public void shouldAddElementsWhenStackIsEmpty() {
            int a = 3;
            Stack stack = new Stack();
            stack.push(a);
            stack.push(a);
            stack.push(a);
            stack.push(a);
            stack.push(a);
            stack.push(a);
            Assertions.assertArrayEquals(new int[]{3, 3, 3, 3, 3, 3}, stack.toArray());
        }
    }

    @Nested
    public class Peak {
        @Test
        public void shouldGetFirstElementWhenStackIsNotEmpty() {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(3);
            stack.push(2);
            stack.push(5);
            stack.push(6);
            stack.push(7);
            Assertions.assertEquals(7, stack.peek());
            Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 6, 7}, stack.toArray());
        }
    }

    @Nested

    public class Pop {

        @Test
        public void shouldRemoveFirstElementWhenStackIsNotEmpty() {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(3);
            stack.push(2);
            stack.push(5);
            stack.push(6);
            stack.push(7);
            Assertions.assertEquals(7, stack.pop());
            Assertions.assertArrayEquals(new int[]{1, 3, 2, 5, 6}, stack.toArray());
        }
    }

    @Nested
    public class Size {
        @Test
        public void shouldReturnSizeWhenStackIsNotEmpty() {
            Stack stack = new Stack();
            stack.push(1);
            stack.push(3);
            stack.push(2);
            stack.push(5);
            stack.push(6);
            stack.push(7);
            Assertions.assertEquals(6, stack.size());
        }

        @Test
        public void shouldReturnSizeWhenStackIsEmpty() {
            Stack stack = new Stack();
            Assertions.assertEquals(0, stack.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void shouldReturnTrueWhenStackIsEmpty() {
            Stack stack = new Stack();
            Assertions.assertTrue(stack.isEmpty());

        }

        @Test
        public void shouldReturnFalseWhenStackIsNotEmpty() {
            Stack stack = new Stack();
            stack.push(523);
            Assertions.assertFalse(stack.isEmpty());

        }
    }
}