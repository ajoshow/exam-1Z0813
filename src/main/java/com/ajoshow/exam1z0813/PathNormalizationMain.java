package com.ajoshow.exam1z0813;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathNormalizationMain {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./dir/..");
        System.out.println(path.normalize());

        path = Paths.get("../src/main/../../resources/file2.txt");
        System.out.println(path.normalize());

        path = Paths.get("../src/main/././resources/file2.txt");
        System.out.println(path.normalize());

        path = Paths.get("../src/main/./../resources/file2.txt");
        System.out.println(path.normalize());

        path = Paths.get("../src/main/.././resources/file2.txt");
        System.out.println(path.normalize());

        path = Paths.get("/root/src/main/../../resources/file2.txt");
        System.out.println(path.normalize());

        path = Paths.get("/root/src/main/../../resources/../dir/./..//./andy");
        System.out.println(path.normalize());

        path = Paths.get("../dir/./..//./andy");
        System.out.println(path.normalize());

    }


}
