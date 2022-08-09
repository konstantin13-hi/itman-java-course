package collections;

import java.util.Comparator;
import java.util.Iterator;

public interface List<T> extends Collection<T> {

    boolean add(T element);

    boolean addAll(Collection<T> collection);

    void set(int index, T element);

    T get(int index);

    int size();

    T[] toArray();

    T remove(int index);

    boolean remove(T element);

    boolean add(int index, T element);

    boolean addAll(int index,Collection <T> collection);

    ListIterator iterator();

    void sort(Comparator<T> comparator);


}
