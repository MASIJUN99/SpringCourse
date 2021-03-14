package com.Sample.c03;

public class School {

    private String name;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString(){
        return "School{" +
                "School Name:'" + name + '\''+
                ", School Address:'" + address + '\'' + '}';
    }
}
