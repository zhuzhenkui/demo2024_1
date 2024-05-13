package com.demo2024_1.entity;

public class Storeinfo {
    private int store_id;
    private String store_name;
    private String store_man;
    private String store_telephone;
    private int store_status;

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getStore_man() {
        return store_man;
    }

    public void setStore_man(String store_man) {
        this.store_man = store_man;
    }

    public String getStore_telephone() {
        return store_telephone;
    }

    public void setStore_telephone(String store_telephone) {
        this.store_telephone = store_telephone;
    }

    public int getStore_status() {
        return store_status;
    }

    public void setStore_status(int store_status) {
        this.store_status = store_status;
    }

    @Override
    public String toString() {
        return "Storeinfo{" +
                "store_id=" + store_id +
                ", store_name='" + store_name + '\'' +
                ", store_man='" + store_man + '\'' +
                ", store_telephone='" + store_telephone + '\'' +
                ", store_status=" + store_status +
                '}';
    }
}
