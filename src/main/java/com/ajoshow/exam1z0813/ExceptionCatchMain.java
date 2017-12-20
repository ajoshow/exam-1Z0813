package com.ajoshow.exam1z0813;

public class ExceptionCatchMain {
    public static void m1() throws Exception {
        System.out.println(1);
        throw new Exception("Exception from m1");
    }

    public static void m2() throws Exception {
        try {
            m1();
        } catch (Exception e) {
            System.out.println(2);
            //Can't do much about this exception so rethrow it
            throw e;
        } finally {
            System.out.println(3);
            throw new RuntimeException("Exception from finally");
        }

    }

    public static void main(String[] args) {
        try {
            m2();
        } catch (Exception e) {
            System.out.println(e); // exception from finally

            // nothing print here
            Throwable[] ta = e.getSuppressed();
            for (Throwable t : ta) {
                System.out.println(t.getMessage());
            }
        }
    }
}
