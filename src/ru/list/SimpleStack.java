package src.ru.list;


import java.util.EmptyStackException;

public class SimpleStack<T> {

    public ListContainer<T> list = new ListContainer<>();

    /**
     * Stack poll removes and return element added most recently.
     *
     * @return Element added most recently.
     */
    public T poll() {
        T element = null;
        try {
            element = list.remove(list.size() - 1);
        } catch (IndexOutOfBoundsException ie) {
            throw new EmptyStackException();
        }
        return element;
    }

    /**
     * Stack push adds element.
     *
     * @param value Element to add.
     */
    public void push(T value) {
        this.list.add(value);
    }
}


