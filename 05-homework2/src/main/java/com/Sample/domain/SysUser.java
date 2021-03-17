package com.Sample.domain;

public class SysUser {
    private String name;
    private int age;
    private String habits;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", habits='" + habits + '\'' +
                '}';
    }
}
