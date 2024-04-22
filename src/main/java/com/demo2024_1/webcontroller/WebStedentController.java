package com.demo2024_1.webcontroller;

import com.demo2024_1.entity.Classinfo;
import com.demo2024_1.entity.Proinfo;
import com.demo2024_1.entity.Studentinfo;
import com.demo2024_1.service.ClassService;
import com.demo2024_1.service.ProService;
import com.demo2024_1.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
//RestConreoller和Controller 前者返回H5的json格式的数据 后者是 返回整个页面
public class WebStedentController {
    @Autowired
    private StudentService stuService;



    @Autowired
    private ClassService cService;

    @Autowired
    private ProService pService;

    @RequestMapping("show_stu_login")
    public String showStuLogin(){

        return "stu_login";
        //stu_login是templates目录下面的同名网页
    }
    @RequestMapping("check_stu_login")
    public String CheckStuLogin(HttpServletRequest request){
        //1.获取数据，保证数据正确
        String stuNO=request.getParameter("stu_no");
        String stuPwd=request.getParameter("stu_pwd");
        System.out.println(stuNO+"----------"+stuPwd);

        //2.处理数据
        //交给对应的service 来完成

        Studentinfo stuinfo = stuService.checkStuLogin(stuNO,stuPwd);



        //3.根据处理结果返回不同的页面
        if (stuinfo != null){
            return  "stu_main";//验证成功，放回主页面
        }else {
            return  "redirect:show_stu_login";//重新输入
            //redirect表示重定向。：后面必须只能跟请求名。没有：和redirect的是网页名
        }



    }
    @RequestMapping("show_stu_list")
    //是否接受参数，是否需要把数据从函数内部搬到下一个网页上。如果都需要
    //则加上一下2个参数，第一个是接受参数用，第二个是把数据搬运到网页上
    public String showStuList(HttpServletRequest request, Model model){

        //从前端取数据，不用管用不用
//        int classNo = Integer.parseInt(request.getParameter("class_no"));
//        System.out.println("+++"+classNo);
        //调用service层对应的类的对象，用model打包传递给前端网页

        String colum_name = request.getParameter("colum_name");
        String qry_condition = request.getParameter("qry_condition");


        //修改了原来的程序，传入参数变成了4个。
        int current_page = Integer.parseInt(request.getParameter("current_page"));
        int page_size = Integer.parseInt(request.getParameter("page_size"));


        System.out.println("当前页码："+current_page+"---每页显示条数："+page_size);
        System.out.println("前端传过来的数据："+colum_name+"---"+qry_condition);


        List<Studentinfo> stuList;
//                stuList=stuService.getStuList(1);
        stuList = stuService.getStuList(colum_name,qry_condition,current_page,page_size);
        //把返回值进行处理，用model打包传给网页
        model.addAttribute("stu_list",stuList);

        model.addAttribute("colum_name",colum_name);
        model.addAttribute("qry_condition",qry_condition);
        model.addAttribute("current_page",current_page<=0?1:current_page);
        model.addAttribute("page_size",page_size);

        return "stu_list";
    }

    @RequestMapping("show_edit_a_stu")
    public  String showEditAStu(HttpServletRequest request,Model model){
        //初始化数据
        String stuNO = request.getParameter("stu_no");
        System.out.println(stuNO+"+++++");

        //外包service 层里面的studentservice；类完成
        Studentinfo stuinfo = stuService.getEditAStu(stuNO);
        System.out.println("+++"+stuinfo.toString());



        //取班级信息构成list送到前端网页去填充下拉框
        List<Classinfo> cList = cService.getClassList();
        System.out.println(cList.size()+"+++++");


        //取专业信息构成list送到前端网页去填充下拉框
        List<Proinfo> pList=pService.getProList();
        System.out.println(pList.size()+"-----");



        //处理数据到网页
        model.addAttribute("a_stu",stuinfo);
        model.addAttribute("class_list",cList);
        model.addAttribute("pro_list",pList);


        return "edit_a_stu";

    }

    @RequestMapping("update_a_stu")
    public String updateAStu(Studentinfo stu, RedirectAttributes attributes){
        //1:stu这个参数 重要把from表单里面的字段和stu对象里面的private 成员变量名一致
        //则可以自动绑定，把from表单里面的各个字段名赋值给stu对象里面的成员变量
        //attributes 是一个RedirectAttribute类型的对象。当保存成功的时候需要跳转回显示
        //列表list的数据这个页面的时候，可能需要传递一些参数。attributes就是用来保存
        //需要传递的参数的

        //1赋初值.打印出来看看是否正确，此时stu已经自动辅助成功，不需要request在一个个赋值

        System.out.println(stu.toString()+"++++");

        //2.交给service层里面的类来完成相应的保存功能，并返回结果值
        int flag = 0;
        flag = stuService.updateAStu(stu);



        //3.根据返回结果，成功取list 不成功则取其他地方
        if (flag > 0){
            attributes.addAttribute("class_no",230935101);
            return "redirect:show_stu_list";//redirect表示要去的地方是一个控制器里面的请求名
        }else {
            return "error";
        }

    }

    @RequestMapping("show_add_a_stu")
    public String addAStu(Model model ){
        List<Classinfo> clist=cService.getClassList();
        System.out.println(clist.toString());

        List<Proinfo> proList=pService.getProList();
        System.out.println(proList.toString());


        model.addAttribute("class_list",clist);
        model.addAttribute("pro_list",proList);
        return "add_a_stu";
    }

    @RequestMapping("insert a_stu")
    public String insertAStu(Studentinfo stu,RedirectAttributes attributes){
        //验证网页传过来的数据是否正确
        //调用，插入stu到数据库

        int flag = 0;
        flag = stuService.insertAStu(stu);
        //3.根据返回结果，成功取list 不成功则取其他地方
        if (flag > 0){
            attributes.addAttribute("class_no",230935101);
            return "redirect:show_stu_list";//redirect表示要去的地方是一个控制器里面的请求名
        }else {
            return "error";
        }

    }
    @RequestMapping("delect_a_stu")
    public String deleteAStu(HttpServletRequest request,RedirectAttributes attributes){
        //1.检验前端的数据
        String stu_no = request.getParameter("stu_no");
        System.out.println("来自前端的数据：" + stu_no);

        //2.调用假删除
        int flag = stuService.deleteAStu(stu_no);
        //3.根据返回结果，成功取list 不成功则取其他地方
        if (flag > 0){
            attributes.addAttribute("class_no",230935101);
            return "redirect:show_stu_list";//redirect表示要去的地方是一个控制器里面的请求名
        }else {
            return "error";
        }

    }
//    @RequestMapping("qry_stu_list")
//    public String qryStuList(HttpServletRequest request,Model model){
//
//        String list_no = request.getParameter("colum_name");
//        String stu_no = request.getParameter("qry_condition");
//
//        System.out.println("666"+stu_no);
//        System.out.println("666"+list_no);
//
//
//        List<Studentinfo> stuList;
//        stuList=stuService.getqryList(list_no,stu_no);
//
//        //把返回值进行处理，用model打包传给网页
//        model.addAttribute("stu_list",stuList);
//        return "stu_list";
//
//
//
//    }
}
