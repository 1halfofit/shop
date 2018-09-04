package com.bo.filter;

import javax.servlet.*;

public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        System.out.println("init encodingFilter, ing ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        /* 设置编码格式为 UTF-8 */
        try {
            System.out.println("running doFilter, ing ...");
            servletRequest.setCharacterEncoding("UTF-8");
            servletResponse.setCharacterEncoding("UTF-8");

            /* 设置返回页面类型 */
//            servletResponse.setContentType("text/html;charset-utf-8");

            /* 将过滤器传递到下去 */
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            System.out.println("encodingFilter exception ...");
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("destroy encodingFilter, ing ...");
    }
}
