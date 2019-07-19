package com.lize.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/word.do")
public class WordFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 屏蔽关键字
         */
        // 修改编码
        servletRequest.setCharacterEncoding("UTF-8");
        // 从参数中获取word
        String word = (String) servletRequest.getParameter("word");
        // 判断修改
        if(word.contains("黑")){
            word = word.replaceAll("黑","*");
        }
        // 设置参数
        servletRequest.setAttribute("word",word);
        // 继续往下执行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
