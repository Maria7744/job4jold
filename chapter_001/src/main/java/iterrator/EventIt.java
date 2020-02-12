package iterrator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt<T> implements Iterator<Integer> {
    private final int[] numbers;
    private int index=0;






    public EventIt(final int[] numbers) {

        this.numbers = numbers;
    }

    public static void main(String[] args) {

        Iterator it = new EventIt(new int[]{4, 2, 1, 1});
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Override

    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                index = i;
                result = true;
                break;
            }
        }
        return result;
    }

        @Override
        public Integer next () {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return numbers[index++];
        }


    }






