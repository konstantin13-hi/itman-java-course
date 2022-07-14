package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Nested
    public class Push {
        @Test
        public void pushShouldAddElementsWhenStackIsEmpty() {
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
        public void peekShouldGetFirstElementWhenStackIsNotEmpty() {
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
        public void popShouldRemoveFirstElementWhenStackIsNotEmpty() {
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
        public void sizeShouldReturnSizeWhenStackIsNotEmpty() {
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
        public void sizeShouldReturnSizeWhenStackIsEmpty() {
            Stack stack = new Stack();
            Assertions.assertEquals(0, stack.size());
        }
    }

    @Nested
    public class IsEmpty {
        @Test
        public void isEmptyShouldReturnTrueWhenStackIsEmpty() {
            Stack stack = new Stack();
            Assertions.assertTrue(stack.isEmpty());

        }

        @Test
        public void isEmptyShouldReturnFalseWhenStackIsNotEmpty() {
            Stack stack = new Stack();
            stack.push(523);
            Assertions.assertFalse(stack.isEmpty());

        }
    }
}