package set;

public interface SimpleSet<T> extends Iterable<T> {

    int size();


    boolean add(T element);
    boolean contains(Object value);

}


