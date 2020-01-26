package src.ru.iterrator;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static sun.nio.cs.Surrogate.is;

public class ConvertIterTest {
    Iterator<Integer> it;

    @Before
    public void setUp() {
        Iterator<Integer> it1 = Arrays.asList(4 ,2 ,0, 4 ,6 ,4 ,9).iterator();
        Iterator<Integer> it2 = Arrays.asList(0 ,9 ,8, 7 ,5).iterator();
        Iterator<Integer> it3 = Arrays.asList(1 ,3 ,5, 6, 7 ,0 ,9, 8 ,4).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        ConvertIterator converter = new ConvertIterator();
        it = converter.convert(its);
    }

    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(7));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(9));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(8));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation() {
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(4));
        it.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        assertThat(it.next(), is(7));
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(9));
        assertThat(it.next(), is(8));
        assertThat(it.next(), is(4));
        it.next();
    }
}

