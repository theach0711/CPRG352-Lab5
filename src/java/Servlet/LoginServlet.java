/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Service.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author 847240
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //session
        HttpSession session = request.getSession();
        if (session.getAttribute("usernameInf") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        } else {
            String logout = request.getParameter("logout");
            if (logout != null) {
                request.setAttribute("logout", "You have succesfully logged out.");
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            } else {
                response.sendRedirect("home");
                return;

            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //session
        HttpSession session = request.getSession();
        
        String username = request.getParameter("usernameIn");
        String password = request.getParameter("passwordIn");

        User us = new User(username, password);
        AccountService accser = new AccountService();

        if (username != "" && password != "") {
            if (accser.login(username, password) != null) {
                session.setAttribute("userInf", us);
                response.sendRedirect("home");
                return;
            } else {
                request.setAttribute("error", "INCORRECT, try again");
                request.setAttribute("username", username);
                request.setAttribute("password", password);

                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
                return;
            }}
        else{
            request.setAttribute("error", "Invalid input, try again");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
       }

        }

    }

