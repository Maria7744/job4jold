package gcSSilki;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
public class ReadToWriteFileText {

    private static final Logger LOG = LogManager.getLogger(ReadToWriteFileText.class.getName());

    private final String path;


    private final HashLowMap<String, String> cache = new HashLowMap<>();


    ReadToWriteFileText(String url) {
        if (!(url.endsWith("\\") || url.endsWith("/"))) {
            url = url + "/";
        }
        this.path = url;
    }

    public String get(String key) {
        String temp = cache.get(key);
        if (temp == null) {
            temp = load(key);
        }
        if (temp != null) {
            cache.insert(key, temp);
        }
        return temp == null ? "file isn't found" : temp;
    }

    private String load(String key) {
        if (Files.exists(Paths.get(path + key))) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(path + key))) {
                return reader.lines().collect(Collectors.joining());
            } catch (IOException e) {
                LOG.error("load file error", e);
            }
        }
        return null;
    }
}

