package ru.job4j.generic.list;
//223221 5.3.4
public class Cycle  {
    public boolean hasCycle(Node first) {
    boolean flag = false;
    Node fast = first;
    Node slow = first;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) {
            flag = true;
            break;
        }
    }
    return flag;
}
}

/**
 * Узел связного списка.
 *
 * @param <T> - тип значание узла.
 */
class Node<T> {
    /**
     * Значение узла.
     */
    T value;

    Node<T> next;

    /**
     * Конструктор.
     *
     * @param value - значение ущла.
     */
    public Node(T value) {
        this.value = value;
    }
}

