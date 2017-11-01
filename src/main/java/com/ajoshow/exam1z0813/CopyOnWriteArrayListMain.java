package com.ajoshow.exam1z0813;

import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.*;

public class CopyOnWriteArrayListMain {

    public static void main(String[] args){
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>(new Integer[]{1,2,3,4,5});

        // suitable for simple modification (add/remove)
        // but heavily modification may cause performance degrade.
        new Thread(new Print(list)).start();
        new Thread(new Add(list)).start();
        new Thread(new Removal(list)).start();
        new Thread(new Print(list)).start();

        // following block will cause UnsupportedOperationException
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//             iterator.remove();
//        }

    }

    private static class Removal implements Runnable{

        private CopyOnWriteArrayList<Integer> list;

        public Removal(CopyOnWriteArrayList<Integer> list){
            this.list = list;
        }

        @Override
        public void run() {
            list.remove(new Random().nextInt(list.size()));
        }
    }

    private static class Add implements Runnable{

        private CopyOnWriteArrayList<Integer> list;

        public Add(CopyOnWriteArrayList<Integer> list){
            this.list = list;
        }

        @Override
        public void run() {
            // random add number from 6~10
            list.add(new Random().nextInt(11)+ 6);
        }
    }

    private static class Print implements Runnable{

        private CopyOnWriteArrayList<Integer> list;

        public Print(CopyOnWriteArrayList<Integer> list){
            this.list = list;
        }

        @Override
        public void run() {
            System.out.println("======");
            for(Integer i : list){
                System.out.println(i);
            }
        }
    }
}
