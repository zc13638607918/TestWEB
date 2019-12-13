package com.zc.Web.servlet;

import com.zc.Web.service.LoginService;
import com.zc.Web.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cs=request.getCookies();
        if(cs!=null){
        for (Cookie c:cs) {
            String name = c.getName();
            String value = c.getValue();
            if(name.equals("uid")){
                LoginService loginService =new LoginServiceImpl();
                boolean b= loginService.checkUid(Integer.parseInt(value));
                if(b){
                    response.sendRedirect("main");
                }else{
                    response.sendRedirect("page");
                }
            }
        }
        }else{
        request.getRequestDispatcher("page").forward(request,response);
        }
    }
}
