package com.example.basictest.extendstest;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/4/3     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class Animal {

    public Animal(){
        move();
    }
    private void move(){
        System.out.println("Animal move !");
    }

}

class Dog extends Animal{

    public  void move(String str){
        System.out.println("Dog move !");
    }

    private final void move(){
        System.out.println("Dog move !");
    }

    public static void main(String[] args){
        Dog dog = new Dog();
        dog.move();
    }
}
