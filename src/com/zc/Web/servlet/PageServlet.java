package com.zc.Web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String str = request.getAttribute("str")==null?"": (String) request.getAttribute("str");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<html>");
        response.getWriter().write("<head>");
        response.getWriter().write("<title>练习登陆页面</title>");
        response.getWriter().write("</head>");
        response.getWriter().write("<body>");
        response.getWriter().write("<h3>欢迎来到周超的登录页面</h3>");
        response.getWriter().write("<hr/>");
        response.getWriter().write("<form action='login' method='GET'>");
        response.getWriter().write("<h3>"+str+"<h3>");
        response.getWriter().write("用户名<input type='text' name='uname' value=''/><br/>");
        response.getWriter().write("密码<input type='password' name='psw' value=''/><br/>");
        response.getWriter().write("<input type='submit' id='' value='登陆'/><br/>");
        response.getWriter().write("</form>");
        response.getWriter().write("</body>");
        response.getWriter().write("</html>");
    }
}
