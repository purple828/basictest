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

public class MyThread2 implements Runnable{

    private MyThread1 thread1 = new MyThread1();
    private MyThread2 thread2 = new MyThread2();


    @Override
    public void run() {
        synchronized (thread2){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread1.test1();

        }

    }

    public void test2(){
        synchronized (thread1){
            System.out.println("MyThread2 ..... test2..........");
        }
    }

}
