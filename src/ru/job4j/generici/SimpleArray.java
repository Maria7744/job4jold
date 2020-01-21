package ru.job4j.generici;

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

    /**
     * Удаление элемента из массива по индексу. Удаление
     * элемента осуществляется за счет копирования всех
     * элементов текущего массива с позиции index + 1 в
     * этот же массив начиная с index (другими словами
     * смещение всех элементов массива на единицу влево),
     * при этом последний элемент затирается.
     *
     * @param index - индекс ячейки для удаления.
     */
    public void remove(int index) {
        System.arraycopy(this.array, index + 1, this.array, index, this.array.length - index - 1);
        this.array[--this.index] = null;
    }

    /**
     * Изменяет значение элемента в ячейке под индексом
     * index.
     *
     * @param index - номер ячейки для обновления
     *
     */
    public void set(int index, T model) {
        this.array[index] = model;
    }

    /**
     * Возвращает значение из указанной ячейки.
   */

    public T get(int index) {
        return (T) this.array[index];
    }

    /**
     * Итератор для итерации элементов контейнера. Реализз
     *
     * @return итератор по элементам.
     */
    @Override
    public Iterator<T> iterator() {

        Iterator<T> iterator = new Iterator<>() {
            /**
             * Позиция указателя в при переборе
             * элементов контейнера
             */
            private int pos = 0;

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean hasNext() {
                return pos != array.length;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public T next() {
                return (T) array[pos++];
            }
        }
        //return iterator;
    }
}

/*<T>implements Iterable<T> {
    private Object[] elements;
    // private int count = 0;
    private int index;//Индекс текущей ячейки
//Конструктор, инициализирущий массив с размером

    public SimpleArray(int size) {
        this.elements = (T[]) new Object[size];
    }


    //add(T model) - добавляет указанный элемент (model) в первую свободную ячейку;
    public void add(T model) {

        if (index > elements.length) {
            throw new UnsupportedOperationException("ошибка");
        }
        this.elements[this.index++] = model;
    }
    ////remove(int index) - удаляет элемент по указанному индексу, все находящиеся справа элементы при этом необходимо сдвинуть на единицу влево (в середине массива не должно быть пустых ячеек);


    public void remove(int index) {
        System.arraycopy(this.elements, index + 1, this.elements, index, this.elements.length - index - 1);
        this.elements[--this.index] = null;
    }

    public int size() {
        return index;

    }


    // get(int index) - возвращает элемент, расположенный по указанному индексу;
    public T get(int index) {
        return (T) this.elements[index];//возврат элемента с индексом index
    }

    //заменяет указанным элементом (model) элемент, находящийся по индексу index;
////model -новое значение элемента
    public void set(int index, T model) {
        this.elements[index] = model;
    }
}
    // public static void main(String[] args) {
       /* int T;
        T[][] elements = {{1, 2}, {3, 4}};
        Iterator<Integer> iter = new SimpleArray<>(elements);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

    }*/
//
//



  /*  @Override
    public Iterator<T> iterator() {
         Iterator<T>iterator = new SimpleArray<>();



            @Override
             public iterator.hasNext() {
            int pos = 0;
                 return pos != elements.length;
             }

             @Override
             public T next() {
            int pos =0;
            return (T) elements[pos++];
             }


         }*/


    public void update(int pos, T model) {
    }
}
 
 
