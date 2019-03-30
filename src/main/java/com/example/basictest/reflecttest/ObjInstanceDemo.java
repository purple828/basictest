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
 *   v1.0       2019/3/30     flj    通过反射获取实例化对象
 *
 * *********************************************
 * </pre>
 */

public class ObjInstanceDemo {

    private static final Logger logger = LoggerFactory.getLogger(ObjInstanceDemo.class);

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("com.example.basictest.model.User");

        //newInstance() 等同于 new关键字，只能调用无参构造，故被反射的实例化对象必须有无参构造，若无则会抛异常
        Object obj = clazz.newInstance();
        logger.info("obj------------>{}",obj);
        //jdk1.9之前使用newInstance(),jdk1.9之后，newInstance()不推荐使用，用getDeclaredConstuctor().newInstance()代替
        Object obj1 = clazz.getDeclaredConstructor().newInstance();
        logger.info("obj1------------>{}",obj1);


    }

}
