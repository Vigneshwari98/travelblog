package org.viki.controllers;

import org.viki.model.User;
import org.viki.services.SignupService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignupController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        User user = new User();
        user.setFirstName(req.getParameter("firstname"));
        user.setLastName(req.getParameter("lastname"));
        user.setPassword(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setPhone(req.getParameter("phone"));
        user.setUsername(req.getParameter("username"));

        SignupService signupService = new SignupService();
        boolean isInserted = signupService.saveUser(user);

        try {
            if (isInserted) {
                req.setAttribute("user",user);
                RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
                dispatcher.forward(req, resp);
            } else {
                req.setAttribute("errMsg", "Signup failed, try again...");
                RequestDispatcher dispatcher = req.getRequestDispatcher("signup.jsp");
                dispatcher.forward(req, resp);
            }
        }catch (ServletException ex){
            ex.printStackTrace();
        }
    }
}

