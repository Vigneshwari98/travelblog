package org.viki.controllers;

import org.viki.model.User;
import org.viki.services.LoginService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // Extracting request info
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        // Sending request data to service
        LoginService loginService = new LoginService();
        User user = loginService.authenticate(name, password);

        // Preparing view
        try {
            if (user != null) {
                Cookie cookie = new Cookie("username", name);
                resp.addCookie(cookie);

                req.setAttribute("user", user);
                RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("errorMsg", "Incorrect Credentials, try again");
                RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
                dispatcher.forward(req, resp);
            }
        }catch(ServletException exception){
            exception.printStackTrace();
        }
    }
}