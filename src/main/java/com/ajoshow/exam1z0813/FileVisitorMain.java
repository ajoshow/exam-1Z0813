package com.ajoshow.exam1z0813;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorMain {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources");
        Files.walkFileTree(path, new Search());

    }

    private static class Search implements FileVisitor<Path> {

        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.txt");

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            System.out.println("preVisitDirectory >> " + dir.toString());

            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println("Visit >> " + file.toString());
            if(matcher.matches(file)){
                System.out.println("Matched >> " + file.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println("postVisitDirectory >> " + dir.toString());

            return FileVisitResult.CONTINUE;
        }
    }

}
