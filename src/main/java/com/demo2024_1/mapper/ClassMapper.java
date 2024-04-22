package com.demo2024_1.mapper;

import com.demo2024_1.entity.Classinfo;
import com.demo2024_1.entity.Proinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClassMapper {
    @Select("SELECT class_no,CONCAT(class_no,\"-\",class_name) AS class_name FROM class_info")
    List<Classinfo> getClassList();

}
