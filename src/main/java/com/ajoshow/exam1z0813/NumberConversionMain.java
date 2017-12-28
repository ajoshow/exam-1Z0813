package com.ajoshow.exam1z0813;

public class NumberConversionMain {

    public static void main(String[] args) {

        float a = 0b0001_01; // valid binary
        System.out.println("a="+a);
        float b = 010_000f; // octal cannot written into float, thus it is decimal here.
        System.out.println("b="+b);
        int c = 010_000; // valid octal
        System.out.println("c="+c);
        double d = 0x00_000d; // the last letter d is a valid hex representation
        System.out.println("d="+d);
        double e = 000_000d; // the last letter d denotes double
        System.out.println("e="+e);
        long f = 0b10000L; // the last letter L denotes long
        System.out.println("f="+f);
//        double g = 0b00001D; // binary canont have suffixes
//        System.out.println("g="+g);

    }
}
