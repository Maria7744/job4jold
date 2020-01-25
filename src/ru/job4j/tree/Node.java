package src.ru.job4j.tree;

import java.util.*;

/**
 * @author Maria7744
 * @version $I
 * @since 0.1
 */
public class Node <E extends Comparable<E>> {



    private final List<Node<E>> children = new ArrayList<>();
    private final E value;
    //private Node<E> root;

    public Node(final E value) {
        this.value = value;
    }

    public void add(Node<E> child) {
        this.children.add(child);
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;

    }

    public E getValue() {
        return value;
    }
}



