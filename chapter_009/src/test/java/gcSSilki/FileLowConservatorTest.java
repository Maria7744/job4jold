package gcSSilki;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class FileLowConservatorTest {
    @Test
    //если у нас нет файла в кеше, а есть в папке, то мы получаем файл
    public void whenIHaveFileInCacheNullButHaveInFolderThenWeGetFile() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        if (!Files.exists(Paths.get(path + "/Address.txt"))) {
            var file = Files.createFile(Paths.get(path + "/Address.txt"));
            BufferedWriter temp = Files.newBufferedWriter(file);
            temp.write("1212121212");
            temp.flush();
        }
        FileLowConservator testconservator = new FileLowConservator(path);

        String expected = "1212121212";

        String actual = testconservator.get("Address.txt");

        Assert.assertEquals(expected, actual);
    }
//когда у нас нет файла в кеше, а у нас нет в папке, то мы получаем Null
    @Test
    public void ifIHaveFileInCacheNullAnDontHaveInFolderThenWeGetNull() throws IOException {
        String path = System.getProperty("java.io.tmpdir");
        FileLowConservator testconservator = new FileLowConservator(path);

        String expected = "file не обнаружен";

        String actual = testconservator.get("unrealfile.txt");

        Assert.assertEquals(expected, actual);
    }
}

