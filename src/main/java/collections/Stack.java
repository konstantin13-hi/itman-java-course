package collections;

public class Stack {
    private IntArrayList intArrayList;

    /**
     * Create arraylist
     *
     * @cpu 0(1)
     * @ram O(1)
     *
     */
    public Stack() {
        intArrayList = new IntArrayList();
    }

    /**
     * Add element in the stack
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @param element the first term
     */
    public void push(int element) {
        intArrayList.add(element);
    }

    /**
     * Get element from stack
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return Get element from stack
     */
    public int peek() {
        return intArrayList.get(intArrayList.size() - 1);
    }

    /**
     * Delete element from stack
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return
     */
    public int pop() {
        return intArrayList.remove(intArrayList.size() - 1);

    }

    /**
     * Check size of stack
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return size of stack
     */
    public int size() {
        return intArrayList.size();
    }

    /**
     * Check stack empty or not
     *
     * @cpu 0(1)
     * @ram 0(1)
     *
     * @return of checking
     */
    public boolean isEmpty() {
        return intArrayList.size() == 0;
    }

    /**
     * Create array of elements
     *
     * @cpu 0(n)
     * @ram 0(n)
     *
     * @return array of elements
     */
    public int[] toArray() {
        return intArrayList.toArray();

    }
}
