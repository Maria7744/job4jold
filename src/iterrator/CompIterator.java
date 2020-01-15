package iterrator;
import java.util.*;



    public class CompIterator<T> implements Iterator {
        private final Iterator<Iterator<T>> iterator;
        private Iterator<T> currentIterator = null;

        public CompIterator(Iterator<Iterator<T>> iterator) {
            this.iterator = iterator;
        }

        @Override
        public boolean hasNext() {
            selectCurrentIterator();
            return (currentIterator != null && currentIterator.hasNext());
        }

        @Override
        public T next() {
            selectCurrentIterator();
            if (currentIterator == null) {
                throw new NoSuchElementException();
            }
            return currentIterator.next();
        }

        private void selectCurrentIterator() {
            if (currentIterator != null && currentIterator.hasNext()) {
                return;
            }
            currentIterator = null;
            while (iterator.hasNext()) {
                Iterator<T> nextIterator = iterator.next();
                if (nextIterator.hasNext()) {
                    currentIterator = nextIterator;
                    break;
                }


            }

        }
    }





