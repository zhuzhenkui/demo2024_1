package com.demo2024_1.entity;
//商品购物车类
public class CartProuctInfo {
    private int cart_product_id; //购物车商品id
    private int product_id; //商品id
    private int store_id; //商店id
    private int product_count; //商品数量
    private int cart_product_price; //购物车商品价格
    private int cart_product_status; //购物车商品状态
    private int user_id;//用户id
    private String product_name; //商品名称
    private String store_name;//商店名称
    private double product_real_price;//商品价格
    private String url_path; //商品图片路径

    public int getCart_product_id() {
        return cart_product_id;
    }

    public void setCart_product_id(int cart_product_id) {
        this.cart_product_id = cart_product_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }

    public int getCart_product_price() {
        return cart_product_price;
    }

    public void setCart_product_price(int cart_product_price) {
        this.cart_product_price = cart_product_price;
    }

    public int getCart_product_status() {
        return cart_product_status;
    }

    public void setCart_product_status(int cart_product_status) {
        this.cart_product_status = cart_product_status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public double getProduct_real_price() {
        return product_real_price;
    }

    public void setProduct_real_price(double product_real_price) {
        this.product_real_price = product_real_price;
    }

    public String getUrl_path() {
        return url_path;
    }

    public void setUrl_path(String url_path) {
        this.url_path = url_path;
    }

    @Override
    public String toString() {
        return "CartProuctInfo{" +
                "cart_product_id=" + cart_product_id +
                ", product_id=" + product_id +
                ", store_id=" + store_id +
                ", product_count=" + product_count +
                ", cart_product_price=" + cart_product_price +
                ", cart_product_status=" + cart_product_status +
                ", user_id=" + user_id +
                ", product_name='" + product_name + '\'' +
                ", store_name='" + store_name + '\'' +
                ", product_real_price=" + product_real_price +
                ", url_path='" + url_path + '\'' +
                '}';
    }
}
