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

public class MyThreadDemo {

    public static void main(String[] args){
        MyThread1 thread1 = new MyThread1();
        MyThread2 thread2 = new MyThread2();
        thread1.run();
        thread2.run();
    }
}
