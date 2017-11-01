package com.ajoshow.exam1z0813;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class StreamFlatMapMain {

    public static void main(String[] args) {
        List<String> a = Arrays.asList("a", "b", "c");
        List<Integer> b = Arrays.asList(1,2,3);

        Stream.of(a, b).flatMap(x -> Stream.of(x)).forEach(System.out::print);
        System.out.println();
        Stream.of(a, b).flatMap(x -> x.stream()).forEach(System.out::print);
    }

}
