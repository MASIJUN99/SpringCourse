package com.Sample.c03;

public class Student {
    // 简单类型
    private String name;
    private int age;

    // 声明一个引用类型
    private School school;

    // 无参构造
    public Student() {
        System.out.println("无参构造");
    }

    // 有参构造
    public Student(String name, int age, School school){
        System.out.println("有参构造");
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
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return school +
                ", name:'" + name + '\'' +
                ", age:" + age +
                '}';
    }
}
