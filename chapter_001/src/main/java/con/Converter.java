package con;


public class Converter {


    public static int rubleToEuro(int value) {
        return value / 70;
    }

    public static int rubleToDollar(int value) {
        return value / 60;
    }

    public static int dollarTORuble(int value) {
        return value * 60;
    }

    public static int evroToRuble(int value) {
        return value * 70;
    }

    public static void main(String[] args) {
        int euro = rubleToEuro(420);
        int dollar = rubleToDollar(420);
        int ruble = dollarTORuble(5);
        int ruble2 = evroToRuble(7);


        System.out.println("140 rubles are " + euro + " euro.");
        System.out.println("140 rubles are " + dollar + " dollar.");
        System.out.println("5 dollar are " + ruble + " ruble");
        System.out.println("7 evro are " + ruble2 + " ruble");
        int in = 420;
        int expected = 6;
        int out = rubleToEuro(in);
        boolean passed = expected == out;
        System.out.println("420 rubles are 6. Test result : " + passed);
        int in1 = 420;
        int expected1 = 7;
        int out1 = rubleToDollar(in1);
        boolean passed1 = expected1 == out1;
        System.out.println("420 rubles are 7 dollar. Test result : " + passed1);
        int in2 = 5;
        int expected2 = 300;
        int out2 = dollarTORuble(in2);
        boolean passed2 = expected2 == out2;
        System.out.println("5 dollar are 300 rubles. Test result : " + passed2);
        int in3 = 7;
        int expected3 = 490;
        int out3 = evroToRuble(in3);
        boolean passed3 = expected3 == out3;
        System.out.println("7 evro are 490rubles. Test result : " + passed3);
    }
}


