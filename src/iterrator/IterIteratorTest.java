package iterrator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class IterIteratorTest {
   public static void main(String[] args) {
        Iterator<Integer> i1 = Arrays.asList(4, 2, 0, 4, 6, 4, 9).iterator();
        Iterator<Integer> i2 = Arrays.asList(0, 9, 8, 7, 5).iterator();
        Iterator<Integer> i4 = new ArrayList<Integer>().iterator();
        Iterator<Integer> i3 = Arrays.asList(1, 3, 5, 6, 7, 0, 9, 8, 4).iterator();
        Iterator<Iterator<Integer>> iterator = Arrays.asList(i1, i2, i4, i3).iterator();
        IterIterator iterIterator = new IterIterator() {
            @Override
            public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
                return null;
            }
        };

        Iterator<Integer> convertedIterator = iterIterator.convert(iterator);
        while (convertedIterator.hasNext()) {
            System.out.print(convertedIterator.next() + " ");
        }
    }
}
