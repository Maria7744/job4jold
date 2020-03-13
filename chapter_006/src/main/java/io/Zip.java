package io;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class Zip {
    List<File> seekBy(String root, List<String> exts) {
        File directoreFile = new File(root);
        LinkedList<File> base = new LinkedList<>();
        LinkedList<File> ans = new LinkedList<>();
        if (directoreFile.isDirectory()) {
            base.addAll(Arrays.asList(directoreFile.listFiles()));
            while (!base.isEmpty()) {
                directoreFile = base.removeFirst();
                if (directoreFile.isDirectory()) {
                    base.addAll(Arrays.asList(directoreFile.listFiles()));
                }
                if (directoreFile.isFile()) {
                    if (!(exts.contains(directoreFile.getName().substring(directoreFile.getName().lastIndexOf(".") + 1)))) {
                        ans.add(directoreFile);
                    }
                }
            }
        }
        return ans;
    }
        public void pack(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
        new Zip().pack(new File("./chapter_005/pom.xml"), new File("./chapter_005/pom.zip"));
    }
    }

