package ru.job4j.generic;

public class UserStore extends BaseStore <User> {
    /**
     * Конструктор, вызывающий конструктор суперкласса.
     *
     * @param users - контейнер для хранения.
     */
    public UserStore(SimpleArray<User> users) {
        super(users);
    }
}