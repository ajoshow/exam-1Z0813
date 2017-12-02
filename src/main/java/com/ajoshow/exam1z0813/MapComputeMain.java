package com.ajoshow.exam1z0813;

import java.util.HashMap;
import java.util.Map;

public class MapComputeMain {

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();

        map1.computeIfAbsent("key1", key -> 1);

        map1.values().forEach(System.out::println);

        map1.computeIfPresent("key1", (k, v) -> {
            if (v == 1) return null;
            else return 0;
        });

        System.out.println("---------");
        map1.values().forEach(System.out::println);

        // similar to computerIfPresent, but value could be null
        map1.compute("key1", (k, v) ->{
            if (v == null) return 2;
            else return null;
        });

        System.out.println("---------");
        map1.values().forEach(System.out::println);

    }
}
