package com.fjl.controller;

import com.fjl.pojo.student;
import com.fjl.service.studentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private studentService studentService;
    @GetMapping("/list")
    public String list(Model model){
        PageHelper.startPage(1,7);
        List<student> list = studentService.list();
        PageInfo<student> of = PageInfo.of(list);
        model.addAttribute("list",of.getList());
        model.addAttribute("dormitoryList",studentService.getAllAvailable());
        model.addAttribute("pageInfo",of);
        return "studentmanager";
    }
    @PostMapping("/delete")
    public String delete(int id,int dormitoryId){
        //1.从学生表中删除该学生
        //2.该宿舍id对应的宿舍人数减一
        studentService.deleteOne(id,dormitoryId);
        return "redirect:/student/list";
    }
    @PostMapping("/save")
    public String save(student student){
        //1.将该学生信息添加到学生表中  系统生成创建时间
        LocalDate now = LocalDate.now();
        student.setCreateDate(now.toString());
        student.setState("入住");
        //2.根据学生的宿舍id 为该宿舍的available减去1
        studentService.addOne(student);

        return "redirect:/student/list";
    }
    @PostMapping("/update")
    public String update(student student,int oldDormitoryId){
        //1.首先是更新学生的信息
        //2.老宿舍新加一个空位
        //3.新宿舍减去一个空位
        studentService.updateOne(student,oldDormitoryId);
        return "redirect:/student/list";
    }
    @PostMapping("/search")
    public String search(String key,String value,Model model){
        model.addAttribute("list",studentService.search(key,value));
        return "studentmanager";
    }
    @GetMapping("/page/{pageNum}")
    public String page(@PathVariable("pageNum") int num,Model model){
        PageHelper.startPage(num,7);
        List<student> list = studentService.list();
        PageInfo<student> of = PageInfo.of(list);
        model.addAttribute("list",of.getList());
        model.addAttribute("dormitoryList",studentService.getAllAvailable());
        model.addAttribute("pageInfo",of);
        return "studentmanager";
    }
    @PostMapping("/findByDormitoryId")
    @ResponseBody
    public List<student>findByDormitoryId(int dormitoryId){
        List<student>list=studentService.findByDormitoryId(dormitoryId);
        return list;
    }
}
