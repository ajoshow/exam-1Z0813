package com.ajoshow.exam1z0813;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AtomicIntegerMain {

    public static void main(String[] args) {

        Worker worker = new Worker();

        Thread t1 = new Thread(worker);
        Thread t2 = new Thread(worker);
        t1.start();
        t2.start();
    }

    private static class Worker implements Runnable {
        private int x = 1;
        private AtomicInteger a = new AtomicInteger(10);

        @Override
        public void run() {
            synchronized (this) {
                while(x > 0){
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    x = a.decrementAndGet();
                    System.out.print(x);
                }

            }
        }
    }

}
