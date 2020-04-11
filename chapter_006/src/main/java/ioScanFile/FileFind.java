package ioScanFile;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileFind {

    public static void main(String[] args) throws IOException {
        Path directory = Paths.get(".");
        String fileNameToFind = "js";

        try {

            Files.walkFileTree(directory, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes fileAttributes) {
                    if (path.toFile().getName().equals(fileNameToFind)) {
                        System.out.println("Found: " + path.toString());
                        return FileVisitResult.TERMINATE;
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}