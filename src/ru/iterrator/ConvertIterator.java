package src.ru.iterrator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ConvertIterator {


        public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            /**
             * Текущий итератор.
             */
            private Iterator<Integer> current = it.next();

            /**
             * Проверка наличия следующего итератора.
             *
             * @return - true если есть очередной итератор
             */
            @Override
            public boolean hasNext() {
                boolean flag = false;
                if (this.current.hasNext()) {
                    flag = true;
                } else {
                    if (it.hasNext()) {
                        this.current = it.next();
                        flag = this.hasNext();
                    }
                }
                return flag;
            }


            @Override
            public Integer next() throws NoSuchElementException {
                int value;
                if (this.current.hasNext()) {
                    value = this.current.next();
                } else {
                    if (it.hasNext()) {
                        this.current = it.next();
                        value = this.next();
                    } else {
                        throw new NoSuchElementException("Больше нет элементов");
                    }
                }
                return value;
            }
        };
    }

    }


