package list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class SimpleNewQueueTest {





        private SimpleNewQueue<Integer> list;

        @Before
        public void before() {
            list = new SimpleNewQueue<>();
            list.push(1);
            list.push(2);
            list.push(3);
        }


        @Test
        public void whenPollShouldFIFO() {
            int[] actual = new int[3];
            actual[0] = list.poll();
            actual[1] = list.poll();
            actual[2] = list.poll();
            assertThat(actual, is(new int[]{1, 2, 3}));
        }

        @Test
        public void whenFIFOShouldFIFO() {
            assertThat(list.poll(), is(1));
            assertThat(list.poll(), is(2));
            list.push(4);
            list.push(5);
            assertThat(list.poll(), is(3));
            assertThat(list.poll(), is(3));
            assertThat(list.poll(), is(4));
            assertThat(list.poll(), is(5));
            list.push(8);
            list.push(9);
            assertThat(list.poll(), is(8));
            assertThat(list.poll(), is(9));
        }

        @Test
        public void whenPollEmptyQueueShouldNull() {
            list = new SimpleNewQueue<>();
            assertNull(list.poll());
        }

    }

