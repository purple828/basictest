package com.example.basictest.reflecttest;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/3/30     flj    单类设计模式 （应用在Runtime类中最明显）
 *
 * 饿汉式
 * 懒汉式（需要考虑同步问题）
 * volatile   主副本数据同步
 *
 * *********************************************
 * </pre>
 */

public class SinglePatternDemo {

    public static void main(String[] args){
//        Singleton1 singleton1 = Singleton1.getInstance();
//        singleton1.print();

        for(int i=1;i<4;i++){
            new Thread(()->{
                Singleton2.getInstance().print();
            },"单例消费端-"+i).start();
        }

    }

}

/**
 * 饿汉式
 */
class Singleton1{

    private static final Singleton1 singleton = new Singleton1();

    private Singleton1(){}      //单类模式只能实例化一个对象，所以构造方法需要私有化不让外界调用

    public static Singleton1 getInstance(){
        return singleton;
    }
    public void print(){
        System.out.println("饿汉式........");
    }
}

class Singleton2{

    private static volatile Singleton2 singleton2 = null;

    private Singleton2(){
        System.out.println("init .......");
    }


    public static Singleton2 getInstance(){
        if(singleton2 == null){
            synchronized (Singleton2.class){
                if(singleton2 == null){
                    singleton2 = new Singleton2();
                }
            }
        }
        return singleton2;
    }

    public void print(){
        System.out.println("懒汉式........");
    }

}
