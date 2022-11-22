package com.fjl.controller;

import com.fjl.pojo.absent;
import com.fjl.pojo.building;
import com.fjl.pojo.dormitory;
import com.fjl.pojo.student;
import com.fjl.service.absentService;
import com.fjl.service.buildingService;
import com.fjl.service.dormitoryService;
import com.fjl.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/absent")
public class absentController {
    @Autowired
    private absentService absentService;
    @Autowired
    private buildingService buildingService;
    @Autowired
    private studentService studentService;
    @Autowired
    private dormitoryService dormitoryService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list",absentService.findAllAbsent());
        return "absentrecord";
    }
    @PostMapping("/search")
    public String search(String key,String value,Model model){
        model.addAttribute("list",absentService.likeSearch(key,value));
        return "absentrecord";
    }
    @GetMapping("/init/{adminId}")
    public String init(@PathVariable("adminId")int adminId,Model model){
        //buildingList
        //宿舍所有信息
        //宿舍学生信息
        List<building>buildingList=buildingService.findByAdminId(adminId);
        model.addAttribute("buildingList",buildingList);
        List<dormitory>dormitoryList=dormitoryService.findByBuildingId(buildingList.get(0).getId());
        model.addAttribute("dormitoryList",dormitoryList);
        List<student>studentList=studentService.findByDormitoryId(dormitoryList.get(0).getId());
        model.addAttribute("studentList",studentList);
        return "absentregister";
    }
    @PostMapping("/save")
    public String save(absent absent){
        int adminId=buildingService.findOneAdminId(absent.getBuildingId());
        absent.setDormitoryAdminId(adminId);
        absentService.insertOne(absent);
        return "redirect:/absent/init/"+adminId;
    }
}
