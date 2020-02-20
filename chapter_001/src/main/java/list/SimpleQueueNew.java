package list;

import java.util.NoSuchElementException;

public class SimpleQueueNew <T>{



        public SimpleStack<T> list1 = new SimpleStack<>();


        public SimpleStack<T> list2 = new SimpleStack<>();


        private int size = 0;


        public T poll() {


            migrate(list2, list1);


            if (list1.isEmpty()) {

                if (list2.isEmpty()) {

                    throw new NoSuchElementException("No elements present in Queue");
                }

                while (!list1.isEmpty()) {

                    list2.push(list1.poll());
                }
            }
            return list2.poll();
        }

//добавляет элемент


        public void push(T value) {

            list1.push(value);

            size++;

        }

        public boolean isEmpty() {

            if (list2.isEmpty() && list1.isEmpty()) {

                return true;

            }

            return false;

        }


        private void migrate(SimpleStack<T> stack1, SimpleStack<T> stack2) {


            int length = stack2.size();

            if (length != 0) {


                for (int i = 0; i < length; i++) {


                    stack1.push(stack2.poll());

                }
            }
        }
    }

