package com.example.basictest.reflecttest;

import com.example.basictest.model.User;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/3/30     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class DoubleObjDemo {

    public static void main(String[] args){

        String str = "name:张三|age:18|student.name:学生名";
        User user = (User) ClassInstanceFactory2.create(User.class,str);
        System.out.println("对象："+user.toString());
        System.out.println("Student对象："+user.getStudent().getName());

    }

}

class ClassInstanceFactory2{
    public static Object create(Class clazz,String value){
        Object obj = null;
        if(StringUtils.isEmpty(value)){
            return obj;
        }
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtil2.initBean(obj,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }
}

class BeanUtil2{

    public static void initBean(Object obj,String str){
        try {
            //"name:张三|age:18|student.name:学生名"
            String[] objArr = str.split("\\|");
            for(int x = 0;x<objArr.length;x++) {
                //["name","张三"]
                String[] nameArr = objArr[x].split(":");
                String name = nameArr[0];
                String value = nameArr[1];
                System.out.println("name="+name+",value="+value);
                String[] doubleArr = name.split("\\.");
                Class clazz = obj.getClass();
                if(doubleArr.length > 1){
                    Field currentField = clazz.getDeclaredField(doubleArr[0]);
                    currentField.setAccessible(true);
                    //获取学生对象
                    Object doubleObj = currentField.getType().getDeclaredConstructor().newInstance();
                    //学生对象的属性
                    Field doubleField = doubleObj.getClass().getDeclaredField(doubleArr[1]);
                    System.out.println("doubleField ====="+doubleField.getName());
                    doubleField.setAccessible(true);
                    Method doubleMethod = doubleObj.getClass().getDeclaredMethod("set"+StringUtil.operateStr(doubleField.getName()),doubleField.getType());
                    doubleMethod.invoke(doubleObj,TypeUtil.operateType(doubleField.getType().getName(),value));

                    Method currentMethod = clazz.getDeclaredMethod("set"+StringUtil.operateStr(currentField.getName()),currentField.getType());
                    System.out.println("************currentMethod="+currentMethod);
                    currentMethod.invoke(obj,doubleObj);
                }else {
                    Field field = clazz.getDeclaredField(name);
                    field.setAccessible(true);
                    System.out.println("nameType ====="+field.getType().getName());
                    Method method = clazz.getDeclaredMethod("set" + StringUtil.operateStr(name), field.getType());
                    method.invoke(obj,TypeUtil.operateType(field.getType().getName(),value));
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


