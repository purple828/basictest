package com.example.basictest.reflecttest;

import com.example.basictest.model.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/3/30     flj    使用反射进行对象操作
 *  Constructor
 *  Method
 *  Field
 *
 * *********************************************
 * </pre>
 */

public class ObjInitDemo {

    public static void main(String[] args) throws Exception{

        Class clazz = User.class;

        Constructor<User> constructor =  clazz.getDeclaredConstructor();
        System.out.println("本类constructor---->"+constructor);
        Constructor<User> constructor1 =  clazz.getConstructor();
        System.out.println("父子类constructor---->"+constructor1);
        Constructor<User>[] constructors = clazz.getDeclaredConstructors();
        for(Constructor cons:constructors){
            System.out.println("constructors---->"+cons);

        }
        System.out.println("--------------------------------------");

        Constructor<User>[] constructors1 = clazz.getConstructors();
        for(Constructor cons:constructors1){
            System.out.println("constructors---->"+cons);

        }

        //能获取到的方法都是public
        Method[] methods = clazz.getMethods();
        for(Method method:methods){
            System.out.println("method---->"+method);
        }

        try {
            User obj = (User) clazz.getDeclaredConstructor().newInstance();
            Method method = clazz.getMethod("create", String.class);
            method.invoke(obj,"张三");
            Method setNameMethod = clazz.getMethod("setName", String.class);
            setNameMethod.invoke(obj,"halou");
            System.out.println("user:"+obj.getName());
//            System.out.println("name:"+user.getName());
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}

