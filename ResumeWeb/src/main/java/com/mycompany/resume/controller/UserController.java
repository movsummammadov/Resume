package com.mycompany.resume.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import com.mycompany.resume.MyFavoritePage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author Movsum Mammadov
 *
 */

@WebServlet(name = "UserController", urlPatterns = {"/users"})
public class UserController extends HttpServlet {

    private UserDaoInter userDao=Context.instanceUSerDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDaoInter userDao = Context.instanceUSerDao();
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String nationalityIdStr=request.getParameter("nId");
        Integer nationaltyId=null;
        if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()){
            nationaltyId=Integer.parseInt(request.getParameter(nationalityIdStr));
        }
        List<User> list = userDao.getAllUser(name,surname,nationaltyId);
        request.setAttribute("list",list);
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}

