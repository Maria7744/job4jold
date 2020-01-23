package src.ru.job4j.generici.simplearray;

import java.util.Iterator;

public class SimpleArray <T> implements Iterable<T> {

    private int index;

    private Object[] array;


    public SimpleArray(int size) {
        this.array = new Object[size];
    }


    public void add(T model) {
        this.array[index++] = model;
    }


    public void remove(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.array[--this.index] = null;
    }


    public void set(int index, T model) {
        this.array[index] = model;
    }


    public T get(int index) {
        return (T) this.array[index];
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int pos = 0;


            @Override
            public boolean hasNext() {

                return pos != array.length;
            }

            @Override
            public T next() {

                return (T) array[pos++];
            }
        }

    }


}

 
 
