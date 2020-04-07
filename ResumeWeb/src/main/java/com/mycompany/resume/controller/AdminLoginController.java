package com.mycompany.resume.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Movsum Mammadov
 *
 */

@WebServlet(name = "AdminLoginController", urlPatterns = {"/adminlogin"})
public class AdminLoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("adminlogin.jsp").forward(request, response);
    }
}

