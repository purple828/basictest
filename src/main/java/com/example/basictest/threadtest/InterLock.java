package com.example.basictest.threadtest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.basictest.model.Student;
import com.example.basictest.model.User;
import com.google.common.base.Joiner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/5/8     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class InterLock {

    private static  Integer i = 0;

    public static class AddThread extends Thread{

        @Override
        public void run(){
            for(int j=0;j<100000;j++){
//                synchronized (InterLock.class){
                synchronized (i){
                    i++;
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException{
        AddThread t1  = new AddThread();
        AddThread t2  = new AddThread();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
//        System.out.println(i);

        User user = new User();
        user.setAge(1);
        user.setName("fanglijuan");
        user.setNum(9L);
        Student student = new Student();
        student.setName("nihao");
        user.setStudent(student);
        String str = JSON.toJSONString(user);
        String str2 = "{\"high\":0.0,\"student\":{\"name\":\"nihao\",\"age\":0},\"num\":0,\"age\":1}";

        JSONObject messageBody = JSONObject.parseObject(str);


        User user1 = JSONObject.parseObject(str2,User.class);

        String userStr = JSON.toJSONString(user);
        System.out.println("------------> userStr:"+userStr);
        User user2 = JSON.parseObject(userStr,User.class);
        System.out.println("---NAME="+user2.getName()+",studentName=");


        String sss = "[{\"age\":\"2\",\"name\":\"韩宁\"},{\"age\":\"571\",\"name\":\"赵振洪\"}]";
        List<User> userList = JSON.parseArray(sss,User.class);
        System.out.println("------------> userList:"+JSON.toJSONString(userList));





    }


}
