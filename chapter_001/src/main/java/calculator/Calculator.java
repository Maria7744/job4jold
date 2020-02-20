package calculator;

public class Calculator {


    public static void add(double first, double second) {
        double result = first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    public static void div(double first, double second) {
        double result = first / second;
        System.out.println(first + "/" + second + " = " + result);
    }

    public static void multipli(double first, double second) {
        double result = first * second;
        System.out.println(first + "*" + second + " = " + result);
    }

    public static void substrat(double first, double second) {
        double result = first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

    public static void main(String[] args) {
        add(1, 1);
        div(4, 2);
        multipli(2, 1);
        substrat(10, 5);


    }
}

