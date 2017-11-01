package com.ajoshow.exam1z0813;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ForkJoinMain {

    public static void main(String[] args){
        List<Integer> range = IntStream.rangeClosed(0, 100).boxed().collect(Collectors.toList());

        ForkJoinPool pool = ForkJoinPool.commonPool();
        Integer result = pool.invoke(new MyTask(range));
        System.out.println("The result is: " + result);

        AtomicInteger result2 = new AtomicInteger(0);
        pool.invoke(new MyAction(range, 0, range.size(), result2));
        System.out.println("The result is: " + result2);
    }

    private static class MyTask extends RecursiveTask<Integer>{

        private List<Integer> list;

        public MyTask(List<Integer> list){
            this.list = list;
        }

        public Integer computeDirectly(){
            int sum = 0;
            for(Integer i : list){
                sum += i;
            }
            return sum;
        }

        @Override
        protected Integer compute() {
            if(list.size() < 10){
                return computeDirectly();
            }else{
                int low = 0, mid = list.size() / 2, high = list.size();

                MyTask left = new MyTask(list.subList(low, mid));
                MyTask right = new MyTask(list.subList(mid, high));

                left.fork();
                Integer rightResult = right.compute();
                Integer leftResult = left.join();

                return rightResult + leftResult;
            }
        }
    }

    private static class MyAction extends RecursiveAction{

        private List<Integer> list;
        private int start, end;
        private AtomicInteger result;


        public MyAction(List<Integer> list, int start, int end, AtomicInteger result){
            this.list = list;
            this.start = start;
            this.end = end;
            this.result = result;
        }

        public void computeDirectly(){
            for(int i = start; i<end; i++){
                result.getAndAdd(list.get(i));
            }
        }

        @Override
        protected void compute() {
            if( (end - start) < 10){
                computeDirectly();
            }else{
                int low = start, mid = (end+start) / 2, high = end;

                MyAction left = new MyAction(list, low, mid, result);
                MyAction right = new MyAction(list, mid, high, result);

                left.fork();
                right.compute();
//                left.join(); // redundant

            }
        }
    }


}

