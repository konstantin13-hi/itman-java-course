package tasks;

import collections.Stack;

public class Task514 {

    /**
     * Solve how many books are left
     *
     * @param books the first term
     * @param queue the second term
     * @return result how many books are left
     * @cpu n+m
     * @ram 0(1)
     */
    public static int solve(int[] books, int[] queue) {
        Stack stack = new Stack();
        for (int i = 0; i < books.length; i++) {
            stack.push(books[i]);
        }
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] < 0) {
                stack.pop();
            } else {
                stack.push(queue[i]);
            }

        }

        return stack.size();
    }


}
