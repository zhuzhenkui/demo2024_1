package com.demo2024_1.service;

import com.demo2024_1.entity.Studentinfo;
import com.demo2024_1.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
//保证把这个类的单一对象注册到spring容器中，通过@autowired拿出来用

public class StudentService {
    @Autowired
    private StudentMapper stuMapper;
    public Studentinfo getAStudentIfno(String stu_no){
        Studentinfo stu=new Studentinfo();
        stu.setStu_no(stu_no);
        stu.setStu_name("zzk");
        stu.setTel("11111");
        stu.setAdd("222");
        stu.setAge(24);
        return stu;
    }
    public Studentinfo getAStudentInfoByMybatis(String stu_no){
        Studentinfo stu=null;
        //service 不能直接访问数据库，需要一个mapper接口去访问数据库
        stu=stuMapper.getAStudentInfo(stu_no);
        return  stu;
    }


    public Studentinfo checkStuLogin(String  no,String pwd){
        //1.声明局部变量
        Studentinfo stu = null;

        //2.业务简单。外包给mapper层对应的函数完成
        stu=stuMapper.checkStuLogin(no,pwd);



        //3.返回值
        return  stu;
    }

    public  Studentinfo getEditAStu(String stu_no){

        return stuMapper.getEditAStu(stu_no);
    }

    public List<Studentinfo> getStuList(int class_no){

        return stuMapper.getStuList(class_no);
    }

    public int updateAStu(Studentinfo stu) {

        return stuMapper.updateAStudent(stu);
    }
    public  int insertAStu(Studentinfo stu) {
        return stuMapper.inserAStudent(stu);
    }

    public int deleteAStu(String stu_no) {
        return stuMapper.deleteAStudent(stu_no);
    }

    public List<Studentinfo> getqryList(String list_no, String stu_no) {
        return stuMapper.selectAStu(list_no,stu_no);
    }
}
