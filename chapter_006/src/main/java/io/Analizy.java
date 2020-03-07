package io;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = List.of("400", "500");
        List<String> time, ans = new ArrayList<>();
        try {
            time = Files.readAllLines(Paths.get(source));
            var stage = true;
            var i = 0;
            for (String e : time) {
                if (stage && (e.startsWith("400") || e.startsWith("500"))) {
                    ans.add(e.substring(e.indexOf("00") + 3) + ";");
                    stage = false;
                } else if (!stage && !(e.startsWith("400") || e.startsWith("500"))) {
                    ans.set(i, ans.get(i) + e.substring(e.indexOf("00") + 3) + ";");
                    stage = true;
                    i++;
                }
            }
            upload(ans, target);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void upload(List<String> ans, String target) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(target))) {
            for (var e : ans) {
                out.write(e);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //Метод main - записывает текст в файл "unavailable.csv"
    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
