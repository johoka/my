package org.example.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ModifyThreadPool {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 5;
        long keepAliveTime = 10;
        TimeUnit unit = TimeUnit.MINUTES;
//        BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
        BlockingQueue<Runnable> workQueue = new SynchronousQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,workQueue);

        for (int i = 0; i < 10; i++) {
            final int j = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println(j);
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            threadPoolExecutor.execute(runnable);
        }
        System.out.println("end");
        try {
            Thread.sleep(4*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//todo 修改核心数
//        threadPoolExecutor.setCorePoolSize(5);
//todo 测试守护线程
//        Thread myThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//            }
//        });
//        myThread.setDaemon(false);
//        myThread.start();        Thread myThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//            }
//        });
//        myThread.setDaemon(false);
//        myThread.start();

        //todo 两者有什么却别呢？
//        threadPoolExecutor.shutdown();
//        threadPoolExecutor.shutdownNow();
    }
}
