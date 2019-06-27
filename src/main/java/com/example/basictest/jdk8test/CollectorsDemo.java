package com.example.basictest.jdk8test;

import com.alibaba.fastjson.JSON;
import com.example.basictest.model.User;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/5/29     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class CollectorsDemo {

    private static Logger logger = LoggerFactory.getLogger(CollectorsDemo.class);

    public static void main (String[] args){
        User user1 = new User("张三",1,null,Double.valueOf(2.5));
        User user2 = new User("李四",2,new BigDecimal("165.5"),Double.valueOf(3));
        User user3 = new User("王五",1);
        User user4 = new User("刘六",2,new BigDecimal("12.4"));
        User user5 = new User("张三",1);


        List<User> userList = Arrays.asList(user1,user2,user3,user4,user5);
        //从User对象集合中筛选出name属性并做排序后放入新集合中
        List<String> userNameList = userList.stream().map(User::getName).sorted().collect(Collectors.toList());
        //userNameList=["刘六","张三","张三","李四","王五"]
        logger.info("------------userNameList={}",JSON.toJSONString(userNameList));
        TreeSet<String> userNameSet = userList.stream().map(User::getName).collect(Collectors.toCollection(TreeSet::new));
        //userNameSet=["刘六","张三","李四","王五"]
        logger.info("------------userNameSet={}",JSON.toJSONString(userNameSet));
        List<BigDecimal> weightList = userList.stream().map(User::getWeight).filter(weight -> weight != null).collect(Collectors.toList());
        //weightList=[165.5,12.4]
        logger.info("------------weightList={}",JSON.toJSONString(weightList));
        BigDecimal weigheAll = userList.stream().map(User::getWeight).filter(weight -> weight != null).reduce(BigDecimal.ZERO, BigDecimal::add);
        //weigheAll=177.9
        logger.info("------------weigheAll={}",JSON.toJSONString(weigheAll));
        double highSum = userList.stream().filter(e -> e.getHigh() != null && e.getHigh()> 2.5).mapToDouble(User::getHigh).sum();
        //highSum=3
        logger.info("------------highSum={}",new BigDecimal(highSum));

       String str = "[{\"age\":\"996\",\"name\":\"刘根宝\"},{\"age\":\"1\",\"name\":\"李水生\"}]";
        List<User> userList1 = JSON.parseArray(str, User.class);
        logger.info("----userList1 = {}",userList1);


        Object boj = 7564;
        Integer i = Integer.parseInt(boj.toString());
        System.out.println(i);

        List<String> workerNameList = Lists.newArrayList();
        List<String> work1 = Lists.newArrayList("1","2");

        workerNameList = work1;
        workerNameList.add("111");


        System.out.println("----->"+JSON.toJSONString(workerNameList));

        String ps = "^1([358][0-9]|4[579]|66|7[01356789]|9[89])[0-9]{8}$";
        String ps1 = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
        Pattern p = Pattern.compile(ps);
        Matcher m = p.matcher("17911112222");

        if (!m.matches()) {
            System.out.println("11111111111111");
        }else {
            System.out.println("222222222222222");
        }

        byte[] bytes = null;
        try {
            String s = new String(bytes,"UTF-8");
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }


    }






    }
