package com.ajoshow.exam1z0813;

import com.ajoshow.exam1z0813.domain.Student;
import com.ajoshow.exam1z0813.factory.StudentFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PeekMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        list.stream().filter(i -> i%2 ==0)
                .peek(System.out::println)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("--------");

        // needs terminal operation to see the peek, print nothing here.
        list.stream().filter(i -> i%2 ==0)
                .peek(System.out::println)
                .mapToInt(Integer::intValue);

        System.out.println("--------");

        // same here, no terminal operation, System print won't print anything.
        // because of characteristic of the laziness.
        list.stream().filter(i -> {
            System.out.println(i);
            return i%2 == 0;
        });

        System.out.println("--------");

        list.stream().filter(i -> {
            System.out.println(i);
            return i%2 == 0;
        }).mapToInt(Integer::intValue)
                .sum();
    }


}
