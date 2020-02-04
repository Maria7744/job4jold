package list;


import java.util.Stack;

public class ArrayStack<T> extends Stack {
    private final int capacity;
    private int headPointer;
    private final int[] data;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public void push(int a) {
        data[headPointer] = a;
        headPointer = (headPointer + 1) % capacity;
    }

    public Object peek() {
        return data[headPointer];

    }

    public Object pop() {
        headPointer = (headPointer + 1) % capacity;
        return null;
    }

    public int getSize() {
        int size = (headPointer + 1) % capacity;
        if (size < 0) {
            size += capacity;
        }
        return size;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public boolean isFull() {
        return getSize() == capacity;
    }

}

