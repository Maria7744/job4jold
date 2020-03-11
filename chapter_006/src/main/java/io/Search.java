package io;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Search {
    public List<File> files(String parent, List<String> condition) {
        File file = new File(parent);
        LinkedList<File> files = new LinkedList<>();
        LinkedList<File> files1 = new LinkedList<>();
        file.mkdir();




        file.isDirectory();
        file.getName();


        if (file.isDirectory()) {
            files.add(file);
        }
        while (!files.isEmpty()) {
            file = files.removeFirst();
            if (file.isDirectory()) {
                files1.addAll(Arrays.asList(file
                        .listFiles(e -> condition.contains(e.getName().substring(e.getName().lastIndexOf(".") + 1)))));
                files.addAll(Arrays.asList(file.listFiles()));
            }
        }
        return files1;

    }

   // public String trimExts(File file) {
    //    return file.getName().substring(file.getName().lastIndexOf(".") + 1);
   // }

    }




