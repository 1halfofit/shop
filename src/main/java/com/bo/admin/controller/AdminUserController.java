package com.bo.admin.controller;

import com.bo.admin.service.AdminUserService;
import com.bo.bean.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class AdminUserController {
    @Resource
    private AdminUserService adminUserService;

    @RequestMapping("AdminLogin")
    @ResponseBody
    public String AdminLogin(UserVo userVo, HttpSession session){
        //登录的过程
        boolean b = adminUserService.adminLogin(userVo);
        if(b){
            session.setAttribute("user",userVo);
        return"admin/main";
        }else{
            return "admin/index";
        }

    }
}
