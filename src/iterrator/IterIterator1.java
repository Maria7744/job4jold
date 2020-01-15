package iterrator;
import java.util.Iterator;



    public class IterIterator1 implements IterIterator
    {
        @Override
        public Iterator<Integer> convert(Iterator<Iterator<Integer>> it)
        {
            return new CompIterator< >(it);
        }
    }

