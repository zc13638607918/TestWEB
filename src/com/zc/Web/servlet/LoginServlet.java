package com.zc.Web.servlet;

import com.zc.Web.pojo.User;
import com.zc.Web.service.LoginService;
import com.zc.Web.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置相应编码格式
        response.setContentType("text/html;charset=utf-8");
        //获取请求数据
        String uname=request.getParameter("uname");
        String psw = request.getParameter("psw");
        //处理请求数据
        LoginService ls = new LoginServiceImpl();
        User user= ls.checkUser(uname,psw);
        //响应请求
        if(user!=null){
            Cookie c = new Cookie("uid",user.getUid()+"");
            c.setMaxAge(3*24*3600);
            c.setPath("/testLogin/gck");
            response.addCookie(c);
            response.sendRedirect("main");
        }else{
            request.setAttribute("str","用户名或密码错误");
            request.getRequestDispatcher("page").forward(request,response);
        }
    }
}
