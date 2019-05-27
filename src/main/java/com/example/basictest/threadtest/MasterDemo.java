package com.example.basictest.threadtest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/4/15     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class MasterDemo {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args){

        CountDownLatch countDownLatch = new CountDownLatch(2);
        long startTime = System.currentTimeMillis();
        try {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread 1 running ............");
                    countDownLatch.countDown();
                }
            });

            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread 2 running ............");
                    for(int i=0;i<5;i++){
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("thread 2 sleep time ***********");
                    }
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            long endTime = System.currentTimeMillis();
            System.out.println("all time cost = "+(endTime-startTime)+"ms");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
