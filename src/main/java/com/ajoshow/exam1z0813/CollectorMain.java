package com.ajoshow.exam1z0813;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;
import static java.util.stream.Collector.Characteristics.UNORDERED;

public class CollectorMain {

    public static void main(String[] args) {
        Integer sum = IntStream.rangeClosed(1,10).boxed().collect(new SumCollector());
        System.out.println(sum);

        Collector sumCollector = Collector.of(
                () -> new int[1],
                (a, i) -> a[0] += (int)i,
                (a, b) -> {
                    a[0] += b[0];
                    return a;
                },
                a -> a[0],
                CONCURRENT,
                UNORDERED
        );
        int sum2 = (int) IntStream.rangeClosed(1,10).boxed().collect(sumCollector);
        System.out.println(sum2);
    }

    private static class SumCollector implements Collector<Integer, Integer[], Integer>{

        @Override
        public Supplier<Integer[]> supplier() {
            return () -> new Integer[]{0};
        }

        @Override
        public BiConsumer<Integer[], Integer> accumulator() {
            return (a, i) -> a[0] += i;
        }

        @Override
        public BinaryOperator<Integer[]> combiner() {
            return (a, b) -> {
                a[0] += b[0];
                return a;
            };
        }

        @Override
        public Function<Integer[], Integer> finisher() {
            return a -> a[0];
        }

        @Override
        public Set<Characteristics> characteristics() {
            return new HashSet<>(Arrays.asList(CONCURRENT, UNORDERED));
        }
    }

}
