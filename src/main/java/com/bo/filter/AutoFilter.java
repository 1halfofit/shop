package com.bo.filter;

import com.bo.bean.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Cookie[] cookies = request.getCookies();
        String value = "";
        String auto = "";
        for (Cookie ck : cookies) {
            //记住用户名
            if ("userinfo".equals(ck.getName())) {
                value = ck.getValue();
            }
            //自动登录
            if ("autoLogin".equals(ck.getName())) {
                auto = ck.getValue();
            }
        }
        if(value.length()>0){
            String[] info = value.split(":");
            User user = new User();
            user.setUsername(info[0]);
            user.setPassword(info[1]);
            System.out.println(user.getName());
            System.out.println(user.getPassword());
            request.setAttribute("user",user);
            String name = request.getParameter("name");
            if (auto.length() > 0 && name==null) {
                request.getSession().setAttribute("activeuser", user);
                response.sendRedirect(request.getContextPath() + "/index.jsp");
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {}
}
