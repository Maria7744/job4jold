package io;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AnalizyTest {
    private List<String> time;
    private File where;
    private File ans;

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();


    @Before
    public void setUp() throws Exception {
        where = tempFolder.newFile("test.check");
        time = new ArrayList<>(List.of(
                "200 10:56:01",
                "500 10:57:01",
                "400 10:58:01",
                "200 10:59:01",
                "500 11:01:02",
                "200 11:02:02"
        ));
        try (BufferedWriter out =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(where)))) {
            for (String s : time) {
                out.write(s);
                out.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("иногда неправильно");
        }
    }

    @Test
    public void wheWeTryWithTemp() throws IOException {
        ans = tempFolder.newFile("answer.check");
        Deque<String> test = new LinkedList<>();
        Analizy an = new Analizy();
        //an.unavailable(where, ans);
        try (BufferedReader out =
                     new BufferedReader(new FileReader(
                             ans))) {
            out.lines().forEach(test::add);
        } catch (
                IOException e) {
            e.printStackTrace();
            System.out.println("Something reading incorrectly");
        }
        assertEquals(test.removeFirst(), "10:57:01;10:59:01;");
        assertEquals(test.removeFirst(), "11:01:02;11:02:02;");
    }

    private void assertEquals(String removeFirst, String s) {
    }
}

