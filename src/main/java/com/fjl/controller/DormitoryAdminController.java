package com.fjl.controller;


import com.fjl.pojo.dormitoryAdmin;
import com.fjl.service.dormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {
    @Autowired
    private dormitoryService dormitoryService;
    @GetMapping("/list")
    public String getList(Model model){
        model.addAttribute("list",dormitoryService.getList());
        return "adminmanager";
    }
    @PostMapping("/search")
    public String search(String key,String value,Model model){
        model.addAttribute("list",dormitoryService.search(key,value));
        return "adminmanager";
    }
    @PostMapping("/save")
    public String save(dormitoryAdmin dormitoryAdmin){
        dormitoryService.insertOne(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }
    @PostMapping("/delete")
    public String delete(int id){
        dormitoryService.deleteOne(id);
        return "redirect:/dormitoryAdmin/list";
    }
    @PostMapping("/update")
    public String update(dormitoryAdmin dormitoryAdmin){
        dormitoryService.updateOne(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }
}
