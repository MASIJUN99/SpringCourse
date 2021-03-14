package com.Sample.c05;

public class Student {
    // 简单类型
    private String name;
    private int age;

    // 声明一个引用类型
    private School school;

    // 无参构造
    public Student() {
        System.out.println("执行无参构造");
    }

    // 有参构造
    public Student(String name, int age, School school){
        System.out.println("执行有参构造");
        this.age = age;
        this.name = name;
        this.school = school;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setAge(int age) {
        this.age = (int) age;
    }

    public void setSchool(School school) {
        System.out.println("setSchool="+school);
        this.school = school;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}

