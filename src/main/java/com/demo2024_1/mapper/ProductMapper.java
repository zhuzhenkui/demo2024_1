package com.demo2024_1.mapper;

import com.demo2024_1.entity.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface ProductMapper {
    @Select("SELECT pi.* ,psi.store_id,si.store_name ,pvi.url_path FROM\n" +
            "\t\tproduct_info pi INNER JOIN product_stock_info psi \n" +
            "\t\tON pi.product_id=psi.product_id and psi.product_stock_status=1\n" +
            "\t\tINNER JOIN store_info si on si.store_id=psi.store_id and si.store_status=1\n" +
            "\t\tINNER JOIN photo_video_info pvi ON pvi.product_id=psi.product_id and pvi.main_url=1\n" +
            "\t\tWHERE pi.product_name like '%${product_name}%'\n" +
            "\t\tGROUP BY pi.product_id,psi.store_id,pvi.url_path")
    List<ProductInfo> getProductList(@Param("product_name") String productName);

    @Select("SELECT pi.* ,psi.store_id,si.store_name ,pvi.url_path FROM\n" +
            "\t\tproduct_info pi INNER JOIN product_stock_info psi \n" +
            "\t\tON pi.product_id=psi.product_id and psi.product_stock_status=1\n" +
            "\t\tINNER JOIN store_info si on si.store_id=psi.store_id and si.store_status=1\n" +
            "\t\tINNER JOIN photo_video_info pvi ON pvi.product_id=psi.product_id and pvi.main_url=1\n" +
            "\t\tWHERE pi.product_id=#{product_id} and si.store_id=#{store_id}\n" +
            "\t\tGROUP BY pi.product_id,psi.store_id,pvi.url_path")
    ProductInfo getAProduct(@Param("product_id") int product_id,
                            @Param("store_id") int store_id);
}
