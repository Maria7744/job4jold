package ru.job4j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt<T> implements Iterator<Integer> {


    private int pos;
    /**
     * Массив с числами
     */
    private final int[] numbers;

    /**
     * Конструктор для инициализации массива
     *
     * @param numbers - массив
     */
    public EventIt(final int[] numbers) {
        this.numbers = numbers;
    }
    public static void main(String[] args) {

        Iterator it = new EventIt(new int[]{4, 2, 1, 1});
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * Метод проверяет есть ли в массиве следующее четное значение.
     * Если метод exist возвращает 0 значит значение есть.
     *
     * @return - true если значение есть.
     */
    @Override
    public boolean hasNext() {
        return this.exist() == 0;
    }

    /**
     * Метод возвращает либо очередное четное значение, либо
     * выкидывает exception о его отсутствии
     *
     * @return - очередной четный элемент.
     * @throws NoSuchElementException - выбрасывается если больше четных элементов
     *                                нет
     */
    @Override
    public Integer next() throws NoSuchElementException {
        if (this.hasNext()) {
            return this.numbers[this.pos++];
        } else {
            throw new NoSuchElementException("Больше нет четных элементов");
        }
    }

    /**
     * Метод проводит поиск ячейки в которой находится четное число.
     * При это каждый последующий поиск элемента будет уменьшать
     * количество итераций цикла на pos. Если очередное четное число
     * найдено не будет метод вернет -1.
     *
     * @return - индекс ячейки в массиве где находится четное число.
     */
    private Integer exist() {
        int value = -1;
        for (int index = this.pos; index < this.numbers.length; index++) {
            if (this.numbers[index] % 2 == 0) {
                this.pos = index;
                value++;
                break;
            }
        }
        return value;
    }

}
