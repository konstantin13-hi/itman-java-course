package collections;

public interface Queue {
    void offer(Object element);

    Object peek();

    Object poll();

    int size();

    boolean isEmpty();

    Object[] toArray();
}
