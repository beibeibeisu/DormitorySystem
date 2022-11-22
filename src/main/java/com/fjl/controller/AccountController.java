package com.fjl.controller;

import com.fjl.dto.ReturnMessage;
import com.fjl.pojo.loginForm;
import com.fjl.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/login")
    public String login(Model model, loginForm loginForm){
        //将表单数据传给service
        ReturnMessage returnMessage=accountService.confirmLogin(loginForm);
        if (returnMessage.getEncode()==-1){
            model.addAttribute("usernameError","用户名错误");
            return "login";
        }
        else if (returnMessage.getEncode()==-2){
            model.addAttribute("passwordError","密码错误");
            return "login";
        }
        if (loginForm.getType().equals("systemAdmin")){
            model.addAttribute("systemAdmin",returnMessage.getAdmin());
            return "systemadmin";
        }
        else {
            model.addAttribute("dormitoryAdmin",returnMessage.getAdmin());
            return "dormitoryadmin";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "login";
    }
}
