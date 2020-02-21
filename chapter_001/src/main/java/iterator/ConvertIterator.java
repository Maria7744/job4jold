package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConvertIterator implements Iterator{

    private Iterator<Iterator<Integer>> it;
    private Iterator<Integer> it1;

    public ConvertIterator(Iterator<Iterator<Integer>> it) {
        this.it = it;
        this.it1 = it.hasNext() ? it.next() : null;
    }

public ConvertIterator convert(Iterator<Iterator<Integer>> it) {
    return new ConvertIterator(it);
}

    @Override
    public boolean hasNext() {
        boolean hasNext = false;
        if (it1 != null) {
            hasNext = it1.hasNext();
            while (!hasNext && it.hasNext()) {
                it1 = it.next();
                hasNext = it1.hasNext();
            }
        }
        return hasNext;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("no iterators");
        }
        if (!it1.hasNext()) {
            it1 = it.next();
        }
        return it1.next();
    }
}