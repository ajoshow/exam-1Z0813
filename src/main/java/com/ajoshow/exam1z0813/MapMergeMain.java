package com.ajoshow.exam1z0813;

import java.util.HashMap;
import java.util.Map;

public class MapMergeMain {

    public static void main(String[] args) {

        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        map1.put("A", 1);
        map1.put("B", 2);

        map2.put("B", 2);
        map2.put("C", 3);

        map1.forEach((k, v) -> map2.merge(k, v, (i, j) -> j));

        map1.keySet().forEach(System.out::print);
        map2.values().forEach(System.out::print);

        System.out.println("");
        System.out.println("------------");

        Map<String, Integer> map3 = new HashMap<>();
        map3.put("a", 1);
        map3.put("b", 1);
        map3.merge("b", 1, (i1, i2)->i1+i2);
        map3.merge("c", 3, (i1, i2)->i1+i2);
        System.out.println(map3);


    }
}
