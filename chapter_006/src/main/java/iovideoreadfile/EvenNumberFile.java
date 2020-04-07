package iovideoreadfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class EvenNumberFile {

       public static void main(String[] args) throws FileNotFoundException {
           File file = new File("even.txt");
           Scanner scanner = new Scanner(file);
           String line = scanner.nextLine();
           String[] numbersString = line.split(System.lineSeparator());
           int[] numbers = new int[4];
           int counter = 0;
           for (String number : numbersString) {
               numbers[counter++] = Integer.parseInt(number);
               if (counter %2 ==0) {
                   System.out.println(Arrays.toString(numbers) + " четное");
               }else {
                   System.out.println(Arrays.toString(numbers) + "нечетное");
               }
                }


            }
}

