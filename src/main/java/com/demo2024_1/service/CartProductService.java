package com.demo2024_1.service;

import com.demo2024_1.entity.CartProuctInfo;
import com.demo2024_1.mapper.CartProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartProductService {
    @Autowired
    private CartProductMapper cartProductMapper;
    public List<CartProuctInfo> getCartProductList(int user_id) {
        //获取数据后，如何在前端用js或者服务段网页遍历刷新整个购物车
        return cartProductMapper.getCartProductList(user_id);
    }
}
