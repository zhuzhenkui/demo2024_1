package com.demo2024_1.mapper;

import com.demo2024_1.entity.Studentinfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student_info where stu_no=#{stu_no}")
    Studentinfo getAStudentInfo(@Param("stu_no") String stu_no);

    @Select("select * from student_info where stu_no=#{stu_no} and stu_pwd=#{stu_pwd}")
    Studentinfo checkStuLogin(@Param("stu_no") String stu_no, @Param("stu_pwd") String stu_pwd);

    @Select("SELECT si.* , ci.class_name,pi.pro_name\n" +
            "\tFROM student_info si\n" +
            "\t\tINNER JOIN class_info ci ON ci.class_no=si.class_no\n" +
            "\t\tINNER JOIN pro_info pi ON pi.pro_id = si.pro_id \n" +
            "\t\twhere si.class_no=#{classNo} and si.student_status=1")
    List<Studentinfo> getStuList(@Param("classNo") int class_no);

    @Select("SELECT si.* , ci.class_name,pi.pro_name\n" +
            "\tFROM student_info si\n" +
            "\t\tINNER JOIN class_info ci ON ci.class_no=si.class_no\n" +
            "\t\tINNER JOIN pro_info pi ON pi.pro_id = si.pro_id \n" +
            "\t\twhere si.stu_no=#{stuNo}")
    Studentinfo getEditAStu(@Param("stuNo") String stu_no);

    @Insert("insert into student_info (stu_no,stu_name,tel,student_info.add,age,stu_pwd,pro_id,class_no)"+
            " values (#{stu_no},#{stu_name},#{tel},#{add},#{age},#{stu_pwd},#{pro_id},#{class_no})")
    int inserAStudent(Studentinfo stu);


    @Update("update student_info \n" +
            "set stu_name=#{stu_name},tel=#{tel},student_info.add=#{add},class_no=#{class_no}" +
            ",pro_id=#{pro_id} \n" +
            "where stu_no=#{stu_no}")
    int updateAStudent(Studentinfo stu);


    @Delete("update student_info set student_status=0 where stu_no=#{stu_no}")
    int deleteAStudent( @Param("stu_no") String stu_no);


    @Select("SELECT si.* ,ci.class_name, pi.pro_name\n" +
            "            from student_info si INNER JOIN class_info ci on ci.class_no = si.class_no\n" +
            "            INNER JOIN pro_info pi on pi.pro_id = si.pro_id\n" +
            "            where si.${type} =#{value} and student_status=1")
    List<Studentinfo> selectAStu(@Param("type") String list_no,
                                 @Param("value")String stu_no);
}
