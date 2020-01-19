package ru.job4jj.oop;

public class Baterry {

        private int load;

        public Baterry(int size) {
            this.load = size;
        }

        public void exchange(Baterry another) {
            this.load = this.load + another.load;
            another.load = 0;
        }

        public static void main(String[] args) {
            Baterry first = new Baterry(10);
            Baterry second = new Baterry(5);
            System.out.println("first : " + first.load + ". second : " + second.load);
            first.exchange(second);
            System.out.println("first : " + first.load + ". second : " + second.load);

        }
    }

