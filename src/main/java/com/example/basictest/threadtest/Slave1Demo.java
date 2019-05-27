package com.example.basictest.threadtest;

import java.util.concurrent.CountDownLatch;

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

public class Slave1Demo  extends Thread{

    private CountDownLatch countDownLatch;

    public static void main(String[] args){
//        Slave1Demo demo = new Slave1Demo();
//        demo.run();

        Test test = new Test();
        test.test();
        System.out.println(test.test());

    }

    public void start(){
        for(int i=0;i<10;i++){
            System.out.println("i="+i);
        }
    }



}


class Test{
    static  int i;
    public int test(){
        i++;
        return i;
    }
}
