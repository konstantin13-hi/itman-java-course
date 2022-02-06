package collections;

import collections.ArrayList;

public class Stack {
    private ArrayList arrayList;

    /**
     * Create arraylist
     *
     * @cpu 0(1)
     * @ram O(1)
     *
     */
    public Stack() {
        arrayList = new ArrayList();
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
        arrayList.add(element);
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
        return arrayList.get(arrayList.size() - 1);
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
        return arrayList.remove(arrayList.size() - 1);

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
        return arrayList.size();
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
        return arrayList.size() == 0;
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
        return arrayList.toArray();

    }
}
