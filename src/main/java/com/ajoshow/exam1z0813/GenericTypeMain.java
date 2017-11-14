package com.ajoshow.exam1z0813;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeMain {
    public static void main(String[] args){
        List<? extends Number> list1 = new ArrayList<>();
        List<? super Number> list2 = new ArrayList<>();

//        list1.add(1); // may accept int, but also double and any number type, results compile error
//        list2.add(1); // accept only number and object, int is number, compile successfully.
//        Number a = list1.get(0); // get any number children. they are all number base. compile successfully.
//        int b = list1.get(0); // double may not be int, compile failed.
//        Number c = list2.get(0); // get number or object, object is not number, compile error.
//        Object d = list2.get(0); // number is object, compile successfully.

        List<String> list3 = new ArrayList<>();
        List<? extends String> list4 = new ArrayList<>();
        List<? super String> list5 = new ArrayList<>();
//        list3.addAll(list4); // list4 contains any string base type. compile successfully.
//        list3.addAll(list5); // list5 may contain String or Object, object is not string, compile error.

        List<? extends A> list6 = new ArrayList<>();
        List<? super B> list7 = new ArrayList<>();
//        list6.add(new A()); // may accept A and any A's children, results compile error.
//        list7.add(new A()); // accept only B, A, Object. A is not B, compile error.
//        list7.add(new B()); // accept only B, A, Object. B is compile successfully.

        testExtend(list6);
        testSuper(list7);
    }

    private static class A extends Object{}
    private static class B extends A{}

    public static void testExtend(List<? extends A> list){}
    public static void testSuper(List<? super B> list){}
}
