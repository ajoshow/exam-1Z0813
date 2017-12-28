package com.ajoshow.exam1z0813;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class ListRootDirectoriesMain {

    public static void main(String[] args) {

        FileSystem fs = FileSystems.getDefault();
        Iterable<Path> roots = fs.getRootDirectories();
        for (Path p : roots) {
            System.out.println(p);
        }

        Iterator<Path> it = roots.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        File[] files = File.listRoots();
        for (Path p : roots) {
            System.out.println(p);
        }

        // get file system through path
        roots = Paths.get("src/resources/file2.txt").getFileSystem().getRootDirectories();
    }
}
