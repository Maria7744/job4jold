package list;


import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements SimpleIterable<E> {


    private static final int DEFAULT_CAPACITY = 8;

    private Object[] container = {

    };

    private int pointer = 0;
    /**
     * Capacity.
     */
    private int capacity;


    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }


    public ArrayList(int capacity) {
        this.capacity = (capacity > DEFAULT_CAPACITY) ? capacity : DEFAULT_CAPACITY;
        this.container = new Object[this.capacity];
    }



    private void ensureCapacity() {
        if (this.pointer == this.capacity) {
            int newCapacity = this.capacity + (this.capacity >> 1);
            Object[] arr = Arrays.copyOf(this.container, newCapacity);
            this.capacity = newCapacity;
            this.container = arr;
        }
    }


    @Override
    public int size() {
        return this.pointer;
    }

    @Override
    public void add(E element) {
        this.ensureCapacity();
        this.container[this.pointer++] = element;
    }



    @Override

    public E get(int index) {
        if (index < 0 || index >= this.pointer) {
            throw new ArrayIndexOutOfBoundsException("Out of bound.");
        }
        return (E) (this.container[index]);
    }


    @Override
    public E remove(int index) {
        E result = this.get(index);
        if (index < this.size() - 1) {
            System.arraycopy(this.container, index + 1, this.container, index, this.size() - (index + 1));
        }
        this.container[--this.pointer] = null;
        return result;
    }



    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int next = 0;

            /**
             * hasNext implementation.
             *
             * @return True, if next element exists.
             */
            @Override
            public boolean hasNext() {

                return next < size();
            }

            /**
             * Returns next element.
             *
             * @return Next element.
             */
            @Override

            public E next() {
                if (next == size()) {
                    throw new NoSuchElementException("No element left");
                }
                return (E) (container[next++]);
            }
        };
    }
}




