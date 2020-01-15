import java.util.Iterator;

public class Evlent implements Iterator {
        private final int[] numbers;
        private int index = 0;

        public Evlent(final int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public boolean hasNext() {
            return index < numbers.length;
        }

        @Override
        public Object next() {
            return numbers[index++];
        }

        private boolean isPrime(int number) {
            if (number <= 0 || number == 1)
                return false;

            if (number == 2)
                return true;

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return true;
                }
            }
            return false;
        }

        public static void main(String[] args) {
            Evlent pi = new Evlent(
                    new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 ,12, 13});

            while (pi.hasNext()) {
                int number = (int) pi.next();
                if (pi.isPrime(number))
                    System.out.println(number);

            }
        }
    }

