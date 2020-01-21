package ru.job4j.list;
//5.3.4
public class SimpleQueue <E> extends LinkedContainer<E> {
    /**
     * Количество элементов в очереди.
     */
    private int size;

    /**
     * Пустой конструктор
     */
    public SimpleQueue() {
    }

    /**
     * Добавляет новый элемент в конец списка.
     *
     * @param value - новый элемент.
     */
    public void push(E value) {
        super.add(value);
        this.size++;
    }

    /**
     * Возвращает значение первого элемента в списке и
     * удаляет ссылку на него (другими словами удаляет его из списка)
     *
     * @return - значение первого элемента в списке
     */
    public E poll() {
        E element = null;
        if (super.searchNode(0) != null) {
            element = super.unlinkFirst();
        }
        this.size--;
        return element;
    }

    /**
     * Возвращает размер списка.
     *
     * @return - размер списка
     */
    @Override
    public int size() {
        return this.size;
    }
}

