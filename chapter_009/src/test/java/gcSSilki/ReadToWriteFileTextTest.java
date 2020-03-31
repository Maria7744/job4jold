package gcSSilki;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class ReadToWriteFileTextTest {

    @Test
    public void ifIHaveFileInCacheNullButHaveInFolderThenWeGETFile() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        if (!Files.exists(Paths.get(path + "/Names.txt"))) {
            var file = Files.createFile(Paths.get(path + "/Names.txt"));
            BufferedWriter temp = Files.newBufferedWriter(file);
            temp.write("123123123123");
            temp.flush();
        }
        ReadToWriteFileText testconservator = new ReadToWriteFileText(path);

        String expected = "123123123123";

        String actual = testconservator.get("Names.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ifelseIDontHaveFileInCacheNullAnDontHaveInFolderThenWeGetPysto() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        ReadToWriteFileText testconservator = new ReadToWriteFileText(path);

        String expected = null;

        String actual = testconservator.get("unrealfile.txt");

        Assert.assertEquals(expected, actual);
    }
}

