package com.bo.filter;

import com.bo.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //判断当前的用户登录状态
        HttpServletRequest  request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("activeuser");
        if(user != null){
            filterChain.doFilter(request,response);
        }else{
          //  response.sendRedirect(request.getContextPath()+"/login.jsp");
            String car = request.getParameter("car");
            response.sendRedirect(request.getContextPath()+"/login.jsp?name="+car);
        }


    }

    @Override
    public void destroy() {

    }
}
