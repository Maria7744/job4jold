package gcSSilki;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
public class FileCache {
    private static final Logger LOG = LogManager.getLogger(FileCache.class.getName());

    private final String path;

    /**
     * collection for keeping cache of used files
     */
    private CMap<String, String> cache = new CMap<String, String>() {

        /**
         * переопределить метод empy AbstractCacheMap для работы со строкой
         */
        @Override
        public String load(String key) {
            if (Files.exists(Paths.get(path + key))) {
                try (BufferedReader reader = Files.newBufferedReader(Paths.get(path + key))) {
                    return reader.lines().collect(Collectors.joining());
                } catch (IOException e) {
                    LOG.error("ошибка загрузки", e);
                }
            }
            return null;
        }
    };

    /**
     * Constructor for file keeper, requared url for folder where stored files for caching
     *
     * @param url - link to folder where stored files for caching
     */
    FileCache(String url) {
        if (!(url.endsWith("\\") || url.endsWith("/"))) {
            url = url + "/";
        }
        this.path = url;
    }

    public String get(String key) {
        return cache.get(key);
    }
}

