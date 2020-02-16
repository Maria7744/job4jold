package set;

import list.ListContainer;

import java.util.Iterator;
import java.util.Objects;

public class SimpleListSet<T> implements SimpleSet<T> {

    private ListContainer<T> list;

    public SimpleListSet() {
        this.list = new ListContainer<>() {
            @Override
            public Iterator<T> iterator() {
                return null;
            }

            @Override
            public T remove(int i) {
                return null;
            }
        };
    }


    @Override
    public int size() {

        return this.list.size();
    }

    public boolean contains(Object value) {
        boolean result = false;
        int size = list.size();
        if (size != 0) {
            for (Object temp : list) {
                if (Objects.equals(temp, value)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


    @Override
    public boolean add(T elem) {

        boolean result = false;
        if (!contains(elem)) {
            this.list.add(elem);
            result = true;
        }

        return result;
    }


    /**/


    @Override
    public Iterator<T> iterator() {
        return this.list.iterator();
    }
}

