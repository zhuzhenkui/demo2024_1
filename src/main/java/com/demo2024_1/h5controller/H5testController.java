package com.demo2024_1.h5controller;

import com.demo2024_1.entity.Studentinfo;
import com.demo2024_1.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//用来返回json格式的数据给前端
public class H5testController {
    @Autowired
    private StudentService stuService;
//    private  StudentService stuService;
//    //spring 容器帮你创建对象
//
//    //浏览器的url最后的请求名必须和show_first_test一致
//    @RequestMapping("show_first_test")
//    public String showFristTest(){
//        return "测试6666666";
//    }
//
//    @RequestMapping("one_param")
//    //用request对象接受url请求的参数
//    public  String oneparam(HttpServletRequest request){
//        String stu_xm=request.getParameter("xm");
//        return  stu_xm+"666666";
//}
//    @RequestMapping("twe_param")
//    public String tweparam(HttpServletRequest request){
//        String stu_xm=request.getParameter("xm");
//        String stu_no=request.getParameter("no");
//
//        return stu_xm+"-------"+stu_no;
//    }
//    @RequestMapping("get_a_student_json")
//    public Studentinfo getAStudentJson(HttpServletRequest request){
//        String stu_no=request.getParameter("no");
//        System.out.println("++"+stu_no);
//        Studentinfo stu=new Studentinfo();
//        stu.setStu_no(stu_no);
//        System.out.println(stu.toString());
//        stu.setStu_name("zzk");
//        stu.setTel("11111");
//        stu.setAdd("222");
//        stu.setAge(24);
//        System.out.println(stu.toString());
//        return stu;
//    }
    @RequestMapping("get_a_student_info")
    //得到一个学生的信息，控制器不完成，交给他的的类完成
    public  Studentinfo getAStudentInfo(HttpServletRequest request){
        String stu_no=request.getParameter("no");
        Studentinfo studentinfo=null;
        //交给对应的服务类处理
//        StudentService stuService=new StudentService();
//        studentinfo=stuService.getAStudentIfno(stu_no);
        studentinfo=stuService.getAStudentInfoByMybatis(stu_no);
        return studentinfo;
    }

}