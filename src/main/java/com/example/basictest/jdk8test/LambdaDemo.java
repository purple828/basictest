package com.example.basictest.jdk8test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
 *   v1.0       2019/5/27     flj    ${添加描述}
 *
 * *********************************************
 * </pre>
 */

public class LambdaDemo {

    public static void main(String[] args){

        List list = Arrays.asList();
        System.out.println(list);
        oldFunc();
        newFunc();


    }

    public static void oldFunc(){
        List<String> strList = Arrays.asList("aaa","my","hello","you");
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(strList);
    }

    public static void newFunc(){
        List<String> strList = Arrays.asList("aaa","my","hello","you");
        Collections.sort(strList,(o1,o2)-> o1.compareTo(o2));
        Collections.sort(strList, String::compareTo);
        System.out.println(strList);
    }

}
