package src.ru.iterrator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt <T> implements Iterator<Integer> {


    private int pos;

    private final int[] numbers;


    public EventIt(final int[] numbers) {
        this.numbers = numbers;
        this.pos = 0;
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
        if (this.numbers != null) {
            while (this.numbers.length > this.pos) {
                if (this.numbers[this.pos] % 2 == 0) {
                    result = true;
                    break;
                }
                this.pos++;
            }
        }
        return result;
    }


    @Override
    public Integer next() throws NoSuchElementException {
        if (this.hasNext()) {
            return this.numbers[this.pos++];
        } else {
            throw new NoSuchElementException("Больше нет четных элементов");
        }
    }




}




