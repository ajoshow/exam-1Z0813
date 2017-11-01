package com.ajoshow.exam1z0813;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathMain {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/src/main/resources/file2.txt");
        System.out.println(path.getName(0));
        System.out.println(path.subpath(0, 2));

        path = Paths.get("../src/main/resources/file2.txt");
        System.out.println(path.getName(0));
        System.out.println(path.subpath(0, 2));


        // resolve joins the path1 and path2
        // the path2 must be a partial path
        // if the path2 is a full path such as /file2, then path2 is returned.
        Path path1 = Paths.get("/src/main/resources/file1");
        Path path2 = Paths.get("file2");
        System.out.println(path1.resolve(path2));
        path2 = Paths.get("/file2");
        System.out.println(path1.resolve(path2));

        // relative returns the path in which how path1 gets to path2
        // path2 must be full path
        // if path2 is a partial (relative) path such as file2, then exception is thrown.
        System.out.println(path1.relativize(path2));
        path2 = Paths.get("file2");
        // following line throws IllegalArgumentException.
//        System.out.println(path1.relativize(path2));

    }


}
