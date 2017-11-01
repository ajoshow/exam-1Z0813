package com.ajoshow.exam1z0813;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CyclicBarrierMain {

    public static void main(String[] args){
        final int numberOfWorker = 5;

        CyclicBarrier cb = new CyclicBarrier(numberOfWorker, ()->
                // barrier action
                System.out.println("All worker await is met.")
        );

        for(int i=0; i<numberOfWorker; i++){
            new Thread(new Worker(cb, i)).start();
        }

        // if you want following line to be printed after all worker
        // action is done, you can either put this line at barrier action
        // runnable or add additional barrier await for the main thread
        // above this line.
        System.out.println("This line is printed at main thread.");


    }

    private static class Worker implements Runnable{

        private CyclicBarrier cb;
        private int id;

        public Worker(CyclicBarrier cb, int id){
            this.cb = cb;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                System.out.println("Worker" + id + ": is processing." );
                int remain = cb.await(3, TimeUnit.SECONDS);
                System.out.println("Worker" + id + ": " + remain + " is remaining.");
            } catch (InterruptedException e) {
                System.out.println("Worker" + id + ": is interrupted." );
            } catch (BrokenBarrierException e) {
                System.out.println("Worker" + id + ": is at broken state." );
            } catch (TimeoutException e) {
                System.out.println("Worker" + id + ": is timeout." );
            }

        }
    }
}
