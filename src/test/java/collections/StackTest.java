package collections;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    public void push() {
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

    @Test
    public void peek() {
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

    @Test
    public void pop() {
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

    @Test
    public void size() {
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
    public void isEmpty() {
        Stack stack = new Stack();
        Assertions.assertTrue(stack.isEmpty());

    }

}