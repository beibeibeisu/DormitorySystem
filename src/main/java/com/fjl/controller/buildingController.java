package com.fjl.controller;

import com.fjl.pojo.building;
import com.fjl.service.buildingService;
import com.fjl.service.dormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/building")
public class buildingController {
    @Autowired
    private buildingService buildingService;
    @Autowired
    private dormitoryService dormitoryService;
    @GetMapping("/list")
    public String list(Model model){

        model.addAttribute("list",buildingService.findList());
        model.addAttribute("dormitoryAdminList",dormitoryService.getList());
        return "buildingmanager";
    }
    @PostMapping("/update")
    public String update(building building){
        buildingService.updateOne(building);
        return "redirect:/building/list";
    }
    @PostMapping("/save")
    public String save(building building){
        buildingService.insertOne(building);
        return "redirect:/building/list";
    }
    @PostMapping("/search")
    public String search(String key,String value,Model model){
        model.addAttribute("list",buildingService.likeSearch(key,value));
        model.addAttribute("dormitoryAdminList",dormitoryService.getList());
        return "buildingmanager";
    }
    @PostMapping("/delete")
    public String delete(int id){
        buildingService.delete(id);
        return "redirect:/building/list";
    }
}
