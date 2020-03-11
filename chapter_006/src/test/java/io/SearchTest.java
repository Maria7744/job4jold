package io;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SearchTest {
    @Test
    public void whenWeTryFindTXT() throws Exception {
        File parent = new File(System.getProperty("java.io.tmpdir") + "/parent");
        parent.mkdir();
        File sun = new File(parent.getAbsolutePath() + "/sun");
        sun.mkdir();

        new File(parent.getAbsolutePath() + "r/text.java").createNewFile();
        new File(parent.getAbsolutePath() + "r/text.exe").createNewFile();
        new File(parent.getAbsolutePath() + "r/text.data").createNewFile();
        new File(sun.getAbsolutePath() + "h/text.sql").createNewFile();
        new File(sun.getAbsolutePath() + "h/text.exe").createNewFile();
        new File(sun.getAbsolutePath() + "j/text.data").createNewFile();
        List<File> files1 = new Search().files(parent.getAbsolutePath(), new ArrayList<>(List.of("java", "sql")));
        assertEquals(2, files1.size());

    }


}






