package com.ajoshow.exam1z0813;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class FileCopyMain {

    public static void main(String[] args) throws Exception {
        test1();
    }

    public static void test() throws Exception{
        Path path1 = Paths.get("src/main/resources/file.txt");
        Path path2 = Paths.get("src/main/resources/file2.txt");

        Files.copy(path1, path2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);

        if(Files.isSameFile(path1, path2)){
            System.out.println("The Same.");
        }else{
            System.out.println("Not the same.");
        }
    }

    public static void test1() throws Exception{
        Path path1 = Paths.get("src/main/resources/file.txt");

        Files.copy(path1, path1.resolveSibling("file3.txt"), StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);

        // if file3.txt is exist, and no REPLACE_EXIST option is in, then FileAlreadyExistsException is thrown.
//        Files.copy(path1, path1.resolveSibling("file3.txt"), StandardCopyOption.COPY_ATTRIBUTES);


    }


}
