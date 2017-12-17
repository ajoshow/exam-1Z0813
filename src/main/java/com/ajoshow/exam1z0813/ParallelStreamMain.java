package com.ajoshow.exam1z0813;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamMain {

    public static void main(String[] args) {
        List<String> vals = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g", "a", "b", "c", "d", "e", "f", "g");
        String join = vals.parallelStream()
                .peek(System.out::println)
                .reduce("_", (a, b)->{
                    System.out.println("reducing "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
                    return a.concat(b);
                }, (a, b)->{
                    System.out.println("combining "+a+" and "+b+" Thread: "+Thread.currentThread().getName());
                    return a.concat(b);
                });
        System.out.println(join);
    }


}
