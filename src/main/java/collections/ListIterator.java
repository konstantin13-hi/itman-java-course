package collections;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator<T> {
    void set(T element);

    void insertBefore(T element);
}
