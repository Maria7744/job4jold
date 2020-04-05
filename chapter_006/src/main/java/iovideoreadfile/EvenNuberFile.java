package iovideoreadfile;

import java.io.FileInputStream;

public class EvenNuberFile {

        public static void main(String[] args) {
            try (FileInputStream in = new FileInputStream("even.txt")) {
                StringBuilder text = new StringBuilder();
                int lines = text.toString().split(System.lineSeparator());
                for (String line : lines) {
                    System.out.println(line);
                }
                //int read;
                int num = rsl;
                boolean rsl = num % 2 == 0;
                while ((num = in.read()) != -1) {
                    text.append((char) num);
                }
                if(rsl){
                    System.out.println("chet");
                }else {
                    System.out.println("nechet");
                }
                System.out.println(text);

            } catch (Exception e) {
                e.printStackTrace();
//splean();

            }

    }
}

