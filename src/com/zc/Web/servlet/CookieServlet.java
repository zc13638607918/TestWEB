package com.zc.Web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid= (String) request.getAttribute("id");
        Cookie c = new Cookie("uid",uid);
        c.setMaxAge(3*24*3600);
        c.setPath("ck");
        response.addCookie(c);
        return;

    }
}
