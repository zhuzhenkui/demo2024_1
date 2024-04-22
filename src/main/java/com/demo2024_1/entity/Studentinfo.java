package com.demo2024_1.entity;

public class Studentinfo {
    private  String stu_no;
    private  String stu_name;
    private  String tel;
    private  String add;
    private  int age;
    private String stu_pwd;
    private int pro_id;
    private int class_no;
    private String class_name;
    private String pro_name;

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public int getPro_id() {
        return pro_id;
    }

    public void setPro_id(int pro_id) {
        this.pro_id = pro_id;
    }

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

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }



    public String getStu_no() {
        return stu_no;
    }

    public void setStu_no(String stu_no) {
        this.stu_no = stu_no;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Studentinfo{" +
                "stu_no='" + stu_no + '\'' +
                ", stu_name='" + stu_name + '\'' +
                ", tel='" + tel + '\'' +
                ", add='" + add + '\'' +
                ", age=" + age +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", pro_id=" + pro_id +
                ", class_no=" + class_no +
                ", class_name='" + class_name + '\'' +
                ", pro_name='" + pro_name + '\'' +
                '}';
    }

}
