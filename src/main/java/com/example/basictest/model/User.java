package com.example.basictest.model;

import java.math.BigDecimal;
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

    private Double high;

    private Date birth;

    private Student student;

    private BigDecimal weight;

    public User(){}

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }

    public User(String name,int age,BigDecimal weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public User(String name,int age,BigDecimal weight,Double high){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.high = high;
    }

    public void create(String name){
        System.out.println(" create user :"+name);
    }

    public void print(){
        System.out.println("------------->print<-------------");
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
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

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
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
