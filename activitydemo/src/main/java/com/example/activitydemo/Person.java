package com.example.activitydemo;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/6/13.
 */
public class Person implements Serializable {

    private int age;
    private String name;
    private String address;

    public Person(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "[ name = " + name + " age = " + age + " address = " + address + " ]";
    }
}
