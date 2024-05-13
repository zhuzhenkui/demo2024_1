package com.demo2024_1.mapper;

import com.demo2024_1.entity.CartProuctInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartProductMapper {


    @Select("\t\tSELECT cpi.*, pi.product_name, si.store_name, pvi.url_path, psi.product_real_price\n" +
            "\t\tFROM \n" +
            "\t\tcart_product_info cpi INNER JOIN product_info pi \n" +
            "\t\tON cpi.product_id=pi.product_id\n" +
            "\t\tINNER JOIN store_info si ON si.store_id=cpi.store_id and si.store_status=1\n" +
            "\t\tINNER JOIN photo_video_info pvi \n" +
            "\t\tON pvi.product_id=pi.product_id and pvi.main_url=1\n" +
            "\t\tINNER JOIN product_stock_info psi ON psi.product_id=cpi.product_id\n" +
            "\t\tWHERE cpi.user_id=#{user_id}\n" +
            "\t\tGROUP BY cpi.cart_product_id, si.store_id, \n" +
            "\t\t\t\tcpi.product_id, pvi.url_path, pi.product_name, psi.product_real_price\t\n" +
            "\t\tORDER BY store_name DESC\n" +
            "\t\t")
    List<CartProuctInfo> getCartProductList(@Param("user_id") int user_id);
}
