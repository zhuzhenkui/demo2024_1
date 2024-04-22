package com.demo2024_1.mapper;

import com.demo2024_1.entity.Proinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProMapper {
    @Select("SELECT pro_id,CONCAT(pro_id,\"-\",pro_name) AS pro_name FROM pro_info")
    List<Proinfo> getProList();
}
