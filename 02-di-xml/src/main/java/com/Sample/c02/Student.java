package com.Sample.c02;

public class Student {
    // 简单类型
    private String name;
    private int age;

    // 声明一个引用类型
    private School school;

    public Student() {
        System.out.println("先执行无参构造");
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name.toUpperCase();
    }

    public void setAge(int age) {
        System.out.println("setAge:" + age);
        this.age = (int) age;
    }

    public void setSchool(School school) {
        System.out.println("setSchool="+school);
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
