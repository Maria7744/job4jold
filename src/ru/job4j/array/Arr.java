package ru.job4j.array;

/*public class Arr {
    Arr matrix = new Arr();
    int[][] value = {
            {1, 2},
            {3, 4}
    };
    int [][] value = new int []iter;
    public class IterIterator<N> implements Iterator<N> {

        private Iterator<Iterator<N>> iters;
        private Iterator<N> ptr;

        public IterIterator(Iterator<N>... iters) {
            reset(iters);
        }

        public void reset(Iterator<N>... iters) {
            this.iters = Arrays.asList(iters).iterator();
            ptr = this.iters.hasNext() ? this.iters.next() : null;
        }

        @Override
        public boolean hasNext() {
            return ptr != null;
        }

        @Override
        public N next() {
            N n = ptr.next();

            while (ptr != null && !ptr.hasNext()) {
                ptr = this.iters.hasNext() ? this.iters.next() : null;
            }

            return n;
    public Arr(final int[][] numbers) {
        public List<Integer> convert(List<int[]> list) {
            //Результирующая коллекция
            List<Integer> value = new ArrayList<>();
            //Итератор по входящей коллекции
            Iterator<int[]> it = list.iterator();
            //Цикл по входящей коллекции для перербора всех масисвов
            while (it.hasNext()) {
                //Цикл для перебора элементов массивов
                for (int number : it.next()) {
                    value.add(number);

                }
            }
            return value;
        }

    }




    class MyLinkedList<T> {
        // Класс который пишется внутри другого - вложенный
        //Вложенные классы могут быть статическими. Если вложенный класс нестатический, то он называется внутренним

        private Node head;
        private int size = 0;

        //null - пустота. Нет объекта
        public void add(T e) {
            Node newNode = new Node();
            newNode.element = e;
            if (head == null) {
                head = newNode;
            } else {
                //Голову нельзя терять. Она одна
                Node tmp = head;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = newNode;
            }
            size++;
        }

      /*  public T getAt(int i) {//Это очень плохой метод
            Node tmp = head;
            for (int k = 0; k < i; k++) {
                tmp = tmp.next;
            }
            return tmp.element;
        }

        public int size() {
            return size;
        }

        public Iterator<T> getIterator() {
            return new Iterator<>(head);
        }


        public class Iterator<T> {
            private Node current;

            public Iterator(Node head) {
                this.current = head;
            }

        public boolean hasNext() {
            return  current != null;
        }
        public T next(){
            Node tmp = current;
            current = current.next;//Переходим к следуюему элементу
            return (T)tmp.element;//привести к типу Т
        }
    }
}
