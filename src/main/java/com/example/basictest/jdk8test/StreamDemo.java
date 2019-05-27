package com.example.basictest.jdk8test;

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

    /**
     * filter()方法是一个中间操作，所以允许在返回结果的基础上再进行其他的流操作（如：forEach）
     */
    public static void filterFunc(){
        List<Integer> numList = Lists.newArrayList(1,10,null,2,null);
        Stream stream1 = numList.stream();
//        Stream stream = stream1.filter(num -> null != num );
//        System.out.println(stream.count());
        //sorted只是创建一个流对象排序的视图，而不会改变原来集合中元素的顺序
        stream1.filter(num -> null != num).sorted().forEach(System.out::println);

    }



}
