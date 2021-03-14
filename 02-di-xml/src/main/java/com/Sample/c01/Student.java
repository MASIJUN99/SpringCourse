package com.Sample.c01;

import java.util.Locale;

public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("先执行无参构造");
    }

    public void setEmail(String email){
        System.out.println("setEmail=" + email);
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name.toUpperCase();
    }

    public void setAge(int age) {
        System.out.println("setAge:" + age);
        this.age = (int) age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return "Student Info{" +
                "name:'" + name + '\'' +
                ", age:" + age +
                '}';
    }
}
