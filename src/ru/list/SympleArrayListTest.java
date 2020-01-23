package src.ru.list;
package ru.job4j;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static sun.nio.cs.Surrogate.is;

public class SympleArrayListTest {


        private SimpleArrayList<Integer> list;

        @Before
        public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

        @Test
        public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

        @Test
        public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }


        @Test
        public void deleteTest(){
        assertThat(list.delete(),is(1));
    }
    }


