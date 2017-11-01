package com.ajoshow.exam1z0813;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamMain {

    public static void main(String[] args) {
        Sum sum = IntStream.rangeClosed(1, 10).collect(Sum::new, Sum::accept, Sum::combine);
        System.out.println(sum.sum());

        int sum2 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.summingInt(i -> i));
        System.out.println(sum2);

        int sum3 = IntStream.rangeClosed(1, 10).boxed().mapToInt(i -> i).sum();
        System.out.println(sum3);

        IntStream.iterate(1, n->n+1).limit(10).forEach(System.out::println);


    }

    private static class Sum {
        private int total;

        public int sum() {
            return total;
        }

        public void accept(int i) {
            total += i;
        }

        public void combine(Sum sum) {
            total += sum.total;
        }
    }

}
