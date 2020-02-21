package iterator;


import java.util.Iterator;

public class MatrixIteratorN<T> implements Iterable<T> {

    private T[][] values;
    private int row;
    private int col;

    public MatrixIteratorN(T[][] values) {
        this.values = values;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return row < values.length && col < values[row].length;
            }

            @Override
            public T next() {
                T value;
                if (this.hasNext()) {
                    value = values[row][col++];
                    if (col <= values[row].length) {
                        row++;
                        col = 0;
                    }
                }
                return values[row][col++];
            }
        };
    }
}



