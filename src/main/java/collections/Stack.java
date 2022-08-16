package collections;

public class Stack {
    private IntArrayList intArrayList;

    /**
     * Create arraylist
     *
     * @cpu 0(1)
     * @ram O(1)
     */
    public Stack() {
        intArrayList = new IntArrayList();
    }

    /**
     * Add element in the stack
     *
     * @param element the first term
     * @cpu 0(1)
     * @ram 0(1)
     */
    public void push(int element) {
        intArrayList.add(element);
    }

    /**
     * Get element from stack
     *
     * @return Get element from stack
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int peek() {
        return intArrayList.get(intArrayList.size() - 1);
    }

    /**
     * Delete element from stack
     *
     * @return
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int pop() {
        return intArrayList.remove(intArrayList.size() - 1);

    }

    /**
     * Check size of stack
     *
     * @return size of stack
     * @cpu 0(1)
     * @ram 0(1)
     */
    public int size() {
        return intArrayList.size();
    }

    /**
     * Check stack empty or not
     *
     * @return of checking
     * @cpu 0(1)
     * @ram 0(1)
     */
    public boolean isEmpty() {
        return intArrayList.size() == 0;
    }

    /**
     * Create array of elements
     *
     * @return array of elements
     * @cpu 0(n)
     * @ram 0(n)
     */
    public int[] toArray() {
        return intArrayList.toArray();
    }
}
