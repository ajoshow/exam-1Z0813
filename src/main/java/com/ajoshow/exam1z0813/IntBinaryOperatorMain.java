package com.ajoshow.exam1z0813;

import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntBinaryOperatorMain {

    public static void main(String[] args) {
        IntBinaryOperator f = Integer::compare;
        int i = f.applyAsInt(12, 11);
        System.out.println(i);

        int j = f.applyAsInt(11, 12);
        System.out.println(j);

    }

}
