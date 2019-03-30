package com.example.basictest.model;

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

public class User  extends AbstractClass{

    private String name;

    private int age;

    private long num;

    private double high;

    private Date birth;

    private Student student;

    public User(){}

    public User(String name){
        System.out.println("excute user constructor............");
    }

    public void create(String name){
        System.out.println(" create user :"+name);
    }

    public void print(){
        System.out.println("------------->print<-------------");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "name="+name+","+
                "age="+age+","+
                "num="+num+","+
                "high="+high+","+
                "birth="+birth
                    ;
    }
}
