package ru.job4jj.list;

//import org.w3c.dom.Node;

public class SimpleArrayList<E> {

    /*private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
   /* public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /** public void addAtIndex(int index, T element) {
     if (index < 0 || index > size)
     throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);

     if (index == 0) {
     addToHead(element);
     } else {
     Node<T> nodeBefore = node(index - 1);
     Node<T> nodeAfter = node(index);
     Node<T> newNode = new Node<T>(element, nodeAfter);

     nodeBefore.setNext(newNode);
     size++;
     }
     * Реализовать метод удаления первого элемент в списке.
     */
    /*public E delete()
        (Object element) {
            Node<E> copy = head;
            int index = 0;
            while (copy != null) {
                if (copy.getValue().equals(element)) {
                    removeAtIndex(index);
                    break;
                } else {
                    index++;
                    copy = copy.getNext();
        return null;
    }

    /**
     * Метод получения элемента по индексу.
     */
  /*  public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;*/
    }

   /* /**
     * Метод получения размера коллекции.
     */
   /* public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
   /* private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}*/


