# 过滤器
> 与Servlet类似，一个实现了Filter接口的Java类就是一个过滤器

## 工作流程：
1. 过滤器是服务端代码，用于拦截传入的请求与响应。
2. 监听、修改或者以某种方式处以正在客户端与服务器之间交互的数据流。
    - 请求：客户端 --> 拦截器 --> 服务器
    - 响应：客户端 <-- 拦截器 <-- 服务器

## Filter API：
  1、 init()
    
    > 类似于 Servlet 的 init，只调⽤用⼀一次，FilterConfig 类似于 ServletConfig，获取当前 Filter 的基本信息。
    
  2、 doFilter()
    > 类似于 Servlet 的 service，过滤器器的主要业务逻辑写在该⽅方法中，多次调⽤用，只要有请求、响应被捕
  获，就调⽤用⼀一次。
  
    > FilterChain：过滤器器链，让请求或者响应继续向下传递。
  3、 destory()
  
    > 类似于 Servlet 的 destory，当 Web 应⽤用程序关闭时调⽤用，只调⽤用⼀一次，释放资源。

## 代码实现：
```java
package com.lize.filter;

import javax.servlet.annotation.WebFilter;

// 放置需要过滤的页面或请求
@WebFilter({"/word.do","/welcome.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        
    }

    @Override
    public void destroy() {

    }
}

```
### 判断用户是否登陆的过滤器
```
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

```

### 屏蔽关键字的过滤器
```
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

```