package com.mycompany.resume.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String address=request.getParameter("address");
        String profileDesc=request.getParameter("profileDesc");
        String birthdateStr=request.getParameter("birthdateStr");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date birthdate=null;
        try {
            birthdate=new Date(sdf.parse(birthdateStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user=userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setProfileDescription(profileDesc);
        user.setBirthdate(birthdate);

        userDao.updateUser(user);

        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("users.jsp").forward(request,response);
    }
}

