package com.mycompany.resume.controller;

import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.dao.inter.UserSkillDaoInter;
import com.mycompany.main.Context;

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

@WebServlet(name = "UserSkillController", urlPatterns = {"/userskill"})
public class UserSkillController extends HttpServlet {

    private UserSkillDaoInter userSkillDao= Context.instanceUserSkillDao();
    private SkillDaoInter skillDao=Context.instanceSkillDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("userskill.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}

