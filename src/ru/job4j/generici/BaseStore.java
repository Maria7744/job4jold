package ru.job4j.generici;

public class BaseStore <T extends Base> implements Store<T> {


        private SimpleArray<T> elements;

        private int index;
        private int pos;

        /**
         * Конструктор инициализирующий хранилище.
         */
        public BaseStore(SimpleArray<T> elements) {
                this.elements = elements;
        }

        /**
         * Добавление объекта в хранилище.
         *
         * @param model - объект типа Base
         */
        public void add(T model) {



        }


        @Override
        public boolean replace(String id, T model) {
                return false;
        }

        @Override
        public boolean delete(String id) {
                return false;
        }


        /**
 * Метод для замены одного объекта хранилища на другой.

 */
public boolean set(String id, T model) {
        boolean flag = false;
        T base = this.findById(id);
        if (base != null) {
        this.elements.update(this.pos, model);
        flag = true;
        }
        return flag;
        }

/**
 * Метод для удаления объекта из хранилища.
 *
 * @param id - ID обекта
 * @return - true если все прошло успешно.
 */
public boolean remove(String id) {
        boolean flag = false;
        T base = this.findById(id);
        if (base != null) {
        this.elements.remove(this.pos);
        flag = true;
        }
        return flag;
        }

/**
 * Метод для поиска объекта в хранилище. С помощью итератора
 * проходим по хранилищу, если объект найден возвращаем его
 *
 * @param id - ID обекта
 * @return - найденный объект или null.
 */
public T findById(String id) {
        T result = null;
        this.pos = 0;
        for (T base : this.elements) {
        if (base != null && base.getId().equals(id)) {
        result = base;
        break;
        }
        this.pos++;
        }
        return result;
        }
        }

