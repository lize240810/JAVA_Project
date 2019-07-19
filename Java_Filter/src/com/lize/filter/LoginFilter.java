package com.lize.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/word.do","/welcome.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 修改请求编码
        servletRequest.setCharacterEncoding("UTF-8");
        // 实例化获得request
        HttpServletRequest request = (HttpServletRequest)servletRequest;

        // 获得session
        HttpSession session = request.getSession();

        // 获得response
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        // 从session获取参数
        String username = (String)session.getAttribute("username");
        // 判断用户是否登陆过
        if (username == null){
            response.sendRedirect("/login.jsp");
            return;
        }
        // 继续执行下去
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
