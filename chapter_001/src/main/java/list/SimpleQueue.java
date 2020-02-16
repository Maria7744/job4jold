package list;

public class SimpleQueue<T> {
        public SimpleStack<T> list1 = new SimpleStack<>();
        public SimpleStack<T> list2 = new SimpleStack<>();
        private int size = 0;

        public T poll() {
            migrate(list2, list1);
            return list2.poll();
        }
//добавляет элемент
        public void push(T value) {

            list1.push(value);
            size++;
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
