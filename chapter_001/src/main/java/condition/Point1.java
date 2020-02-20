package condition;

public class Point1 {
    public static double distance(int x1, int y1, int x2, int y2) {

        double x = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,
                2));
        return x;
    }


    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);

        System.out.println("расстояние (0, 0) to (2, 0) " + result);
    }
}
