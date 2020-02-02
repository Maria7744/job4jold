package list;


import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayListTest {


    @Test
    public void whenAddIntegerToArrayContainerThenGetItIn() {
        SimpleIterable<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        int result = arr.get(1);
        assertThat(result, is(2));
    }

    /**
     * Test add String to container and get it.
     */
    @Test
    public void whenAddStringToArrayContainerThenGetItIn() {
        SimpleIterable<String> arr = new ArrayList<>();
        arr.add(new String("one"));
        arr.add(new String("two"));
        arr.add(new String("three"));

        String result = arr.get(2);
        assertThat(result, is("three"));
    }

    /**
     * Test remove String element from container.
     */
    @Test
    public void whenRemoveElementFromArrayContainerThenItIsRemoved() {
        SimpleIterable<String> arr = new ArrayList<>();
        arr.add(new String("one"));
        arr.add(new String("two"));
        arr.add(new String("three"));

        arr.remove(1);
        String result = arr.get(1);
        assertThat(result, is("three"));
    }

    /**
     * Test remove String element from container.
     */
    @Test
    public void whenRemoveLastElementFromArrayContainerThenArrayIsEmpty() {
        SimpleIterable<String> arr = new ArrayList<>();
        arr.add(new String("one"));
        arr.remove(0);

        Exception result = null;
        try {
            arr.get(0);
        } catch (Exception e) {
            result = e;
        }
        assertThat(result, instanceOf(ArrayIndexOutOfBoundsException.class));
    }


    /**
     * Test that ArrayContainer is iterable with foreach.
     */
    @Test
    public void whenGetIteratorThenCanForEachContainer() {
        SimpleIterable<String> arr = new ArrayList<>();
        arr.add(new String("one"));
        arr.add(new String("two"));
        arr.add(new String("three"));

        String result = "";
        for (String str : arr) {
            result += str + ":";
        }
        assertThat(result, is("one:two:three:"));
    }

    /**
     * Test that next after last element will cause NoSuchElementException.
     */
    @Test
    public void whenNoElementsLeftInArrayContainerThenNextCauseNoSuchElementException() {
        SimpleIterable<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        Iterator<Integer> it = arr.iterator();

        Exception result = null;
        try {
            it.next();
            it.next();
            it.next();
            it.next();
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(NoSuchElementException.class));
    }

    /**
     * Test that get with wrong index cause ArrayIndexOutOfBoundsException.
     */
    @Test
    public void whenTryToGetNotExistingElementThenGetArrayIndexOutOfBoundsException() {
        SimpleIterable<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        Exception result = null;
        try {
            arr.get(5);
        } catch (Exception e) {
            result = e;
        }

        assertThat(result, instanceOf(ArrayIndexOutOfBoundsException.class));
    }


    @Test
    public void whenAddMoreElementsThanDefaultCapacityThenContainerIsDynamicallyGrown() {
        SimpleIterable<String> arr = new ArrayList<>();
        arr.add(new String("one"));
        arr.add(new String("two"));
        arr.add(new String("three"));
        arr.add(new String("four"));
        arr.add(new String("five"));
        arr.add(new String("six"));
        arr.add(new String("seven"));
        arr.add(new String("eight"));
        arr.add(new String("nine"));
        arr.add(new String("ten"));

        String result = arr.get(9);
        assertThat(result, is("ten"));
    }

    @Test
    public void whenAddFiveElementsAndRemoveTwoThenSizeIsThree() {
        SimpleIterable<String> arr = new ArrayList<>();
        arr.add(new String("one"));
        arr.add(new String("two"));
        arr.add(new String("three"));
        arr.add(new String("four"));
        arr.add(new String("five"));
        arr.remove(4);
        arr.remove(3);

        assertThat(arr.size(), is(3));
    }
}



