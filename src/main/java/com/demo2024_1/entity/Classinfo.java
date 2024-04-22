package com.demo2024_1.entity;

public class Classinfo {

    private  int class_no;
    private String class_name;
    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    @Override
    public String toString() {
        return "Classinfo{" +
                "class_no=" + class_no +
                ", class_name='" + class_name + '\'' +
                '}';
    }


}
