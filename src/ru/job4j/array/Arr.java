package ru.job4j.array;

public class Arr {
    Arr matrix = new Arr();
    int[][] value = {
            {1, 2},
            {3, 4}
    };
    public Arr(final int[][] numbers) {


        public class Iterator<T> {
        private  Node current;
            Iterator it = new Arr(new int[][] {4, 2, 1, 1});

        public Iterator(Node  head) {
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
