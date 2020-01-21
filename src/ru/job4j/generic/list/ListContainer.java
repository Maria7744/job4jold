package ru.job4j.generic.list;

public abstract class ListContainer<E> implements Iterable<E> {
        /**
         * Добавление нового элемента в контейнер
         *
         * @param value - значение элемента
         */
        void add(E value) {

        }

        /**
         * Возвращает значение элемента по указанному индексу
         *
         * @param index - индекс ячейки контейнера.
         * @return - значение элемента.
         */
        E get(int index) {
                return null;
        }

        /**
         * Возвращает размер контейнера.
         *
         * @return - размер контейнеар.
         */
        int size() {
                return 0;
        }

        /**
         * Возвращает true если контейнер содержит указанный элемент.
         *
         * @param value - элемент для проверки наличия его в контейнере
         * @return - true если контейнер содержит указанный элемент
         */
        boolean contains(E value) {
                return false;
        }
}
