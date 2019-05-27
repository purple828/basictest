package com.example.basictest.jdk8test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * <pre>
 * ****************************************************
 * Copyright BAIBU.
 * All rights reserved.
 * Description: ${添加描述}
 * HISTORY:
 * ***************************************************
 *  Version      Date       Author       Desc
 *   v1.0       2019/5/24     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class StreamDemo {

    public static void main (String[] args){
//        createStream();

        filterFunc();
    }


    /**
     * 构造流的几种方式
     */
    public static Stream createStream(){
        //1.Individual values
        Stream stream = Stream.of("a","b","c");
        //2.Arrays
        String[] strArr = new String[]{"a","b","c"};
        stream = Stream.of(strArr);
        stream = Arrays.stream(strArr);
        //3.Collections
        List<String> list = Arrays.asList(strArr);
        stream = list.stream();
        return stream;
    }

    public static void filterFunc(){
        List<Integer> numList = Lists.newArrayList(1,10,null,2,null);
        Stream stream1 = numList.stream();
//        Stream stream = numList.stream().filter(num -> null != num );
        Stream stream = stream1.filter(num -> null != num );
        System.out.println(stream.count());
//        System.out.println(stream1.count());

    }



}
