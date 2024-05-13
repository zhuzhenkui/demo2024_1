package com.demo2024_1.service;

import com.demo2024_1.entity.ProductInfo;
import com.demo2024_1.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<ProductInfo> getProductList(String productName) {
        //查询条件默认按照产品名称查询。
        return productMapper.getProductList(productName);
    }

    public ProductInfo getAProduct(int product_id,int store_id) {
        //查询条件默认按照产品id和商店id查询。
        return productMapper.getAProduct(product_id,store_id);
    }
}

