package src.ru.job4j.tree;

public class InvalidRootException extends RuntimeException {


public InvalidRootException() {
        }

/**
 * Конструктор, позволяющий передавать пользователю
 * информационную строку об ошибке.
 *
 * @param message - информация об ошибке.
 */
public InvalidRootException(String message) {
        super(message);
        }
        }