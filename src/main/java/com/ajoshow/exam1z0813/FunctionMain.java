package com.ajoshow.exam1z0813;

import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {
        double principle = 100;
        int interestrate = 5;
        double amount = compute(principle, x -> {
            System.out.println(x);
            return x * interestrate;
        });
        System.out.println(amount);
    }

    public static double compute(double base, Function<Integer, Integer> func) {
        return func.apply((int) base);
    }

}
