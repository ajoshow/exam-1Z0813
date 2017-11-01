package com.ajoshow.exam1z0813;

import java.util.Arrays;
import java.util.HashMap;

public class HashMapMergeMain {

    public static void main(String[] args) {

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.put("A", 1);
        map1.put("B", 2);

        map2.put("B", 2);
        map2.put("C", 3);

        map1.forEach((k,v) -> map2.merge(k,v, (i,j)->j));

        map1.keySet().forEach(System.out::print);
        map2.values().forEach(System.out::print);

    }
}
