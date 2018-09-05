package com.bo.controller;

import com.bo.bean.User;
import com.bo.bean.UserVo;
import com.bo.service.CartService;
import com.bo.service.UserService;
import com.bo.util.UUIDutil;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {
    @Resource //注入  自动装配
    private UserService userService;
    @Resource
    private CartService cartService;
    //用户注册
    @RequestMapping("saveInfo")
    public String saveInfo(User user, ModelMap mm){
        user.setUid(UUIDutil.getuuid());
        boolean b1 = userService.saveInfo(user);
        if(b1){
            //可以在下一个资源中使用user数据
            mm.addAttribute("user",user);
            return "redirect:/login.jsp";
        }else{
            return "registerFail";
        }
    }
    //用户登录
    @RequestMapping("enter")
    public String enter(UserVo userVo, HttpSession session, HttpServletRequest request , HttpServletResponse response){
        User user = userService.loginCheck(userVo);

        if(user!=null){
            //获取验证码是否正确
            String code = (String) session.getAttribute("code");
            if(code.equalsIgnoreCase(userVo.getCode())){
                session.setAttribute("activeuser",user);

                //判断是否记住用户名
                if("rem".equals(userVo.getRem())){
                    //使用Cookie
                    Cookie cookie = new Cookie("userinfo",userVo.getUsername()+":"+userVo.getPassword());
                    cookie.setPath(request.getContextPath());
                    cookie.setMaxAge(Integer.MAX_VALUE);
                    response.addCookie(cookie);
                }
                //自动登录
                if("autoLogin".equals(userVo.getRem())){
                    //使用Cookie
                    Cookie cookie2 = new Cookie("autoLogin","auto");
                    cookie2.setPath(request.getContextPath());
                    cookie2.setMaxAge(Integer.MAX_VALUE);
                    response.addCookie(cookie2);

                }
                return "jump";
            }
        }
        return "login";
    }

    //退出
    @RequestMapping("logout")
    public String logout( HttpSession session){
        session.setAttribute("activeuser",null);
        return "jump";
    }













    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
}
