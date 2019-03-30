package com.example.basictest.reflecttest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/3/30     flj    java.lang.Class实例化
 *
 * *********************************************
 * </pre>
 */

public class ClassInstanceDemo {

    private static final Logger logger = LoggerFactory.getLogger(ClassInstanceDemo.class);
    public static void main(String[] args){

        Class clazz1 = getClassInstance1(new Person());
        Class clazz2 = getClassInstance2();
        Class clazz3 = getClassInstance3("com.example.basictest.reflecttest.Person");
        logger.info("clazz1------------>{}",clazz1);
        logger.info("clazz2------------>{}",clazz2);
        logger.info("clazz3------------>{}",clazz3);

    }

    /**
     * 实例化方式一
     * Object类的支持，可以通过实例化对象获取
     * @param obj
     * @return
     */
    public static Class getClassInstance1(Object obj){
        return obj.getClass();
    }

    /**
     * 实例化方式二
     * JVM直接支持，使用 类.class 形式
     * @return
     */
    public static Class getClassInstance2(){
        return Person.class;
    }

    /**
     * 实例化方式三
     * Class类支持，提供静态方法 forName(String className)支持
     * @param className
     * @return
     */
    public static Class getClassInstance3(String className){
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



}

class Person{

    public Person(){}

}
