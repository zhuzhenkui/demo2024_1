package com.demo2024_1.entity;

public class Proinfo {
    private int pro_id;
    private String pro_name;
    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    @Override
    public String toString() {
        return "Proinfo{" +
                "pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                '}';
    }
}
