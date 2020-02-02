package list;

public interface SimpleIterable<E> extends Iterable<E> {
    int size();

    void add(E element);

    E get(int index);


    E remove(int index);
}

