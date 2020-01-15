package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class  MassivIt<Integer> implements Iterator<java.lang.Integer> {

    private int size;          //всего элементов в матрице
    private int position = 0;  //номер текущего элемента для "выдачи"
    private int row = 0;       //строка текущего элемента
    private int col = 0;       //столбец текущего элемента
    Integer[][] value = {{1, 2}, {3, 4}};


    public MassivIt(int [][] value) {
        this.value= value;
        this.size = countElements(value);
    }

    private int countElements(int[][] value) {  //считаем количество элементов в матрице
        int count = 0;
        for (int[] row : value) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }
    /* {*/


    @Override
    public java.lang.Integer next() {
        if (position >= size) { //если перебрали все элементы, то бросить исключение
            throw new NoSuchElementException();
        }
        int element = value[row][col];  //запоминаем текущий элемент
        //переходим к следующему элементу
        position++;
        col++;
        while (row < value.length && col >= value[row].length) { //для того, чтоб пропустить возможные "пустые" строки
            col = 0;
            row++;
        }
        return element;
    }
    Integer[][] value = {{1, 2, 3}, {}, {4, 5}, {6}};
    Iterator<Integer> iterator = new MassivIt<>(value);
while (iterator.hasNext());
 System.out.println(iterator.next());

}

