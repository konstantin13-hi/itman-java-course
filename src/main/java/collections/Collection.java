package collections;


import java.util.function.IntFunction;
import java.util.function.Predicate;

public interface Collection<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    boolean add(T element);

    boolean addAll(Collection<T> collection);

    boolean contains(T element);

    boolean remove(T element);

    boolean containsAll(Collection<T> collection);

    void removeAll(Collection<T> collection);

    Object[] toArray();

    void removeIf(Predicate<T> predicate);

    T[] toArray(IntFunction<T> factory);

}
