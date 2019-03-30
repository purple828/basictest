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

public class AttributeDemo {

    public static void main(String[] args){

        String str = "name:张三|age:18|num:10|high:165.5|birth:2019-12-12";
//        String str = "name:张三|age:18";
//        User user = BeanUtil.initBean(str,User.class);
        User user = (User) ClassInstanceFactory.create(User.class,str);
        System.out.println("对象："+user.toString());

    }
}

class StringUtil{

    public static String operateStr(String str){
        System.out.println("str---------------------->"+str);
        if(StringUtils.isEmpty(str)){
            return str;
        }
        if(str.length() == 1){
            return str.toUpperCase();
        }else {
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }

}

class ClassInstanceFactory{
    public static Object create(Class clazz,String value){
        Object obj = null;
        if(StringUtils.isEmpty(value)){
            return obj;
        }
        try {
            obj = clazz.getDeclaredConstructor().newInstance();
            BeanUtil.initBean(obj,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }
}

class BeanUtil{

    public static void initBean(Object obj,String str){
        try {
            String[] objArr = str.split("\\|");
            //["name:张三","age:18",...]
            for(int x = 0;x<objArr.length;x++) {
                //["name","张三"]
                System.out.println("--------------->"+x);
                String[] nameArr = objArr[x].split(":");
                String name = nameArr[0];
                String value = nameArr[1];
                System.out.println("name="+name+",value="+value);

                Class clazz = obj.getClass();
                Field field = clazz.getDeclaredField(name);
                field.setAccessible(true);
                System.out.println("nameType ====="+field.getType().getName());
                Method method = clazz.getDeclaredMethod("set" + StringUtil.operateStr(name), field.getType());
                method.invoke(obj,TypeUtil.operateType(field.getType().getName(),value));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class TypeUtil{

    public static Object operateType(String type,String value){
        if("int".equals(type) || "java.lang.Integer".equals(type)){
            return Integer.parseInt(value);
        }else if("long".equals(type) || "java.lang.long".equals(type)){
            return Long.parseLong(value);
        }else if ("double".equals(type) || "java.lang.double".equals(type)){
            return Double.parseDouble(value);
        }else if("java.util.Date".equals(type)){
            SimpleDateFormat sdf = null;
            if(value.matches("\\d{4}-\\d{2}-\\d{2}")){
                sdf = new SimpleDateFormat("yyyy-MM-dd");
            }else if (value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }else {
                return new Date();
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();
            }
        }
        return value;
    }
}
