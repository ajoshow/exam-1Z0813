package com.ajoshow.exam1z0813;

import java.util.ArrayList;
import java.util.List;

public class DiamondMain {

    public static void main(String[] args){
        // data type IN must be the same as data type OUT.
        List<Integer> list1 = new ArrayList<>();
        List<? super Integer> result1 = process(list1);

        List<Number> list2 = new ArrayList<>();
        List<? extends Number> result2 = process(list1);
    }

    public static <T extends Number> List<T> process(List<T> list){
        return list;
    }
}
