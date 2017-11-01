package com.ajoshow.exam1z0813;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeMain {
    public static void main(String[] args){
        List<? extends Number> list1 = new ArrayList<>();
        List<? super Number> list2 = new ArrayList<>();

        // only line 13 will not cause compile error.
//        list1.add(1);
//        list2.add(1);
//        int a = list1.get(0);
//        int b = list2.get(0);

        List<String> list3 = new ArrayList<>();
        List<? super String> list4 = new ArrayList<>();
        // Compile error
//        list3.addAll(list4);
        int i = 0200;
    }
}
