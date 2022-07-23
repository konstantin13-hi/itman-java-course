package collections;

public interface List {
    void add(Object element);

    void set(int index, Object element);

    Object get(int index);

    int size();

    Object[] toArray();

    Object remove(int index);
}
