package com.example.basictest.jdk8test;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/5/27     flj    Java 8 允许我们使用default关键字，为接口声明添加非抽象的方法实现
 *
 * *********************************************
 * </pre>
 */

public interface InterfaceDemo {

    void test(String str);

    default void test(){

    }

}
