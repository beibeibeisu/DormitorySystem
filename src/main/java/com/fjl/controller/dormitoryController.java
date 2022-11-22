package com.fjl.controller;

import com.fjl.pojo.dormitory;
import com.fjl.service.buildingService;
import com.fjl.service.dormitoryService;
import com.fjl.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dormitory")
public class dormitoryController {
    @Autowired
    private dormitoryService dormitoryService;
    @Autowired
    private buildingService buildingService;
    @Autowired
    private studentService studentservice;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list",dormitoryService.listAndBuildingName());
        model.addAttribute("buildingList",buildingService.findList());
        return "dormitorymanager";
    }
    @PostMapping("/save")
    public String save(dormitory dormitory){
        dormitoryService.insertOneDormitory(dormitory);
        return "redirect:/dormitory/list";
    }
    @PostMapping("/update")
    public String update(dormitory dormitory){
        dormitoryService.updateDormitoryMessage(dormitory);
        return "redirect:/dormitory/list";
    }
    @PostMapping("/search")
    public String search(String key,String value,Model model){
        model.addAttribute("list",dormitoryService.likeSearch(key,value));
        model.addAttribute("buildingList",buildingService.findList());
        return "dormitorymanager";
    }
    @PostMapping("/delete")
    public String delete(int id ){
        dormitoryService.deleteOneDormitory(id);
        return "redirect:/dormitory/list";
    }
    @PostMapping("/findByBuildingId")
    @ResponseBody
    public List findByBuildingId(int buildingId){
        List list=new ArrayList<>();
        List<dormitory>dormitoryList=dormitoryService.findByBuildingId(buildingId);
        list.add(dormitoryList);
        list.add(studentservice.findByDormitoryId(dormitoryList.get(0).getId()));
        return list ;
    }
}
