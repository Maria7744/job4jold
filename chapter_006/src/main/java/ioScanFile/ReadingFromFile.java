package ioScanFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        //выбирает сам разделитель какой слэш нужен
        String separator = File.separator;
        //Здесь изменим вид строки контенируем ее
       // String path = "/Users/mariaob/Desktop/input.txt";
        String path = separator +"Users"+ separator+"mariaob" +separator+"Desktop"+ separator+"input.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

    }

}
