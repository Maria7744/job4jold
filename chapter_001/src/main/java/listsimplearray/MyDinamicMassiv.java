package listsimplearray;

public class MyDinamicMassiv<E> {


    private E[] elements;
    private int count = 0;

    public MyDinamicMassiv() {
        elements = (E[]) new Object[1];
    }

    public void add(E value) {
        if (count < elements.length) {
            elements[count] = value;

        } else {
            E[] newArray = (E[]) new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newArray[i] = elements[i];
            }
            newArray[count] = value;
            this.elements = newArray;
        }
        count++;

    }

    public int size() {
        return count;
    }

    public E getAt(int index) {
        return elements[index]; //возврат элемента с индексом i

    }

}


