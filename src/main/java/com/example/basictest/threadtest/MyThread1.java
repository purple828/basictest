package com.example.basictest.threadtest;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/6/5     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class MyThread1 implements Runnable {

    private MyThread1 thread1 = new MyThread1();
    private MyThread2 thread2 = new MyThread2();


    @Override
    public void run() {
        synchronized (thread1){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread2.test2();

        }

    }

    public void test1(){
        synchronized (thread2){
            System.out.println("MyThread1 ..... test1..........");
        }
    }
}
