package org.example.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadUtil {
    private ExecutorService executor1 = Executors.newFixedThreadPool(3);

    private ExecutorService executor2 = Executors.newFixedThreadPool(3);


    public void submitTask(){
        for(int i =0;i<10;i++){
            executor1.submit(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"正处理");
                }
            });

            executor2.submit(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"正处理");
                }
            });
        }

        //处理完成后关闭线程池
        executor1.shutdown();
        executor2.shutdown();
    }

    public static void main(String[] args) {
        ThreadUtil c = new ThreadUtil();
        c.submitTask();
    }

}
