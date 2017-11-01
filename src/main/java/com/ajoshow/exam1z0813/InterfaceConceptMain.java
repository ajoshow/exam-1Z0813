package com.ajoshow.exam1z0813;

import java.time.LocalDateTime;

public class InterfaceConceptMain {

    public static void main(String[] args) {

        A a = new E();
        a.print();

//        B b = new E();
//        b.print(); // compile error
        B.print();

        C c = new E();
        c.print();

        D d = new E();
        d.print();

        E e = new E();
        e.print();

        LocalDateTime l = LocalDateTime.parse("2017-01-01");
    }

    interface A{
        void print();
    }

    interface B {
        static void print(){
            System.out.println("B");
        }
    }

    interface C extends B{
        default void print(){
            System.out.println("C");
        }
    }

    interface D extends A, B, C{
        default void print(){
            System.out.println("D");
        }
    }

    static class E implements D{
        public void print(){
            System.out.println("E");
        }
    }



}
