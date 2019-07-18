package com.lize.controller;

import com.lize.entity.Users;
import com.lize.service.UserService;
import com.lize.service.impl.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 控制层
 * 接受用户的请求
 */
@WebServlet("/users.do")
public class UsersServlet extends HttpServlet {

    private UserService userService = new UsersServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求中文乱码
        req.setCharacterEncoding("UTF-8");
        String method = req.getParameter("method");
        if(method == null){
            method = "findAll";
        }
        switch (method){
            case "findAll":
                //查询全部数据
                List<Users> list = userService.findAll();
                req.setAttribute("list",list);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
                break;
            case "add":
                String name = req.getParameter("name");
                String score = req.getParameter("score");
                String birthday = req.getParameter("birthday");
                userService.add(name,score,birthday);
                resp.sendRedirect("/users.do?method=findAll");
                break;
            case "deleteById":
                String idStr = req.getParameter("id");
                userService.deleteById(idStr);
                resp.sendRedirect("/users.do?method=findAll");
                break;
            case "findById":
                idStr = req.getParameter("id");
                req.setAttribute("users", userService.findById(idStr));
                req.getRequestDispatcher("update.jsp").forward(req,resp);
                break;
            case "update":
                idStr = req.getParameter("id");
                name = req.getParameter("name");
                score = req.getParameter("score");
                birthday= req.getParameter("birthday");
                userService.update(idStr,name,score,birthday);
                resp.sendRedirect("/users.do?method=findAll");
                break;
        }
    }
}
