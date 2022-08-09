package collections;

public interface Queue<T> {
    void offer(T element);

    T peek();

    T poll();

    int size();

    boolean isEmpty();

    T[] toArray();
}
