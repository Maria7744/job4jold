package condition;

public class MultiMax {


    public int max(int first, int second, int third) {


        int result ;

        if (first > second && first > third) {
            result = first;
        } else if (third > second && third > first) {
            result = third;
        } else {
            result = second;
        }
        return result;
    }

    public static void main(String[] args) {
        int first = 2;
        int second = 3;
        int third = 7;



    }
}






