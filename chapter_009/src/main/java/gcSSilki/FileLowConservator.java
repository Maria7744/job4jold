package gcSSilki;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
public class FileLowConservator {

        /**
         * inner logger
         */
        private static final Logger LOG = LogManager.getLogger(FileLowConservator.class.getName());

        private final String path;

        /**
         * collection for keeping cache of used files
         * коллекция для хранения кеша используемых файлов
         */
        private final HashLowMap<String, String> cache = new HashLowMap<>();

        /**
         * Constructor for file keeper, requared url for folder where stored files for caching
         *Конструктор для хранителя файлов, требуемый URL для папки,
         * в которой хранятся файлы для кеширования
         *  url - link to folder where stored files for caching
         *            ссылка на папку, где хранятся файлы для кеширования
         */
        FileLowConservator(String url) {
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
        return temp == null ? "file не найден" : temp;
    }

        private String load(String key) {
        if (Files.exists(Paths.get(path + key))) {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(path + key))) {
                return reader.lines().collect(Collectors.joining());
            } catch (IOException e) {
                LOG.error("ошибка загрузки файла", e);
            }
        }
        return null;
    }
    }

