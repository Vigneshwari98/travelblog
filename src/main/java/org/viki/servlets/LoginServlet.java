package org.viki.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        PrintWriter printWriter = resp.getWriter();

        if(name.equals("Vigneshwari") && password.equals("Vigneshwari@30")){
            printWriter.println("Login Successful...");
        }else{
            printWriter.println("Login Failed .Try again with correct credential");
        }
    }
}