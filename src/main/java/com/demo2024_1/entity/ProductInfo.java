package com.demo2024_1.entity;

public class ProductInfo {
    private int product_id;
    private String product_name;
    private String brand;
    private String p_type;
    private String p_GL;
    private String p_size;
    private String p_date;
    private String p_class;
    private int p_status;
    private double p_price;
    private int store_id;
    private String store_name;//通过冗余来解决少关联表的问题

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public String getP_GL() {
        return p_GL;
    }

    public void setP_GL(String p_GL) {
        this.p_GL = p_GL;
    }

    public String getP_size() {
        return p_size;
    }

    public void setP_size(String p_size) {
        this.p_size = p_size;
    }

    public String getP_date() {
        return p_date;
    }

    public void setP_date(String p_date) {
        this.p_date = p_date;
    }

    public String getP_class() {
        return p_class;
    }

    public void setP_class(String p_class) {
        this.p_class = p_class;
    }

    public int getP_status() {
        return p_status;
    }

    public void setP_status(int p_status) {
        this.p_status = p_status;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }

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

    @Override
    public String toString() {
        return "ProductInfo{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", brand='" + brand + '\'' +
                ", p_type='" + p_type + '\'' +
                ", p_GL='" + p_GL + '\'' +
                ", p_size='" + p_size + '\'' +
                ", p_date='" + p_date + '\'' +
                ", p_class='" + p_class + '\'' +
                ", p_status=" + p_status +
                ", p_price=" + p_price +
                ", store_id=" + store_id +
                ", store_name='" + store_name + '\'' +
                '}';
    }
}
