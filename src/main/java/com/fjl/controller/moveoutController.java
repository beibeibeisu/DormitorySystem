package com.fjl.controller;

import com.fjl.pojo.moveout;
import com.fjl.service.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/moveout")
public class moveoutController {
    @Autowired
    private studentService studentService;
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list",studentService.list());
        return "moveoutregister";
    }
    @PostMapping("/search")
    public String search(String key,String value,Model model){
        model.addAttribute("list",studentService.search(key,value));
        return "moveoutregister";
    }
    @PostMapping("register")
    public String register(moveout moveout){
        moveout.setCreateDate(LocalDate.now().toString());
        studentService.updateOneState(moveout);
        return "redirect:/moveout/list";
    }
    @GetMapping("/record")
    public String record(Model model){
        model.addAttribute("list",studentService.getAllMoveOut());
        return "moveoutrecord";
    }
    @PostMapping("/recordSearch")
    public String recordSearch(String key,String value,Model model){
        model.addAttribute("list",studentService.moveOutLikeSearch(key,value));
        return "moveoutrecord";
    }
}
