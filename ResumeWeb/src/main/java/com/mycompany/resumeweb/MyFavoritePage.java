package com.mycompany.resumeweb;

import com.mycompany.dao.inter.SkillDaoInter;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Skill;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Movsum Mammadov
 *
 */
@WebServlet(name = "MyFavoritePages", urlPatterns = {"/MyFavoritePages"})

public class MyFavoritePage extends HttpServlet {

    //    private UserDaoInter userDao = Context.instanceUSerDao();
    private SkillDaoInter skillDao = Context.instanceSkillDao();
    private int a = 0;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service");
        super.service(req, resp);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//
//            String name = String.valueOf(request.getParameter("name"));
//            skillDao.addSkill(new Skill(0, name));
//            String surname = String.valueOf(request.getParameter("surname"));
//            String phone = String.valueOf(request.getParameter("phone"));
//            String email = String.valueOf(request.getParameter("email"));
//            String prof = String.valueOf(request.getParameter("prof"));
//            User u = new User(0, name, surname, email, phone, null, prof, null, null, null);
//            boolean d = userDao.addUser(u);
//            System.out.println(userDao.getAllUser());
            a++;
            System.out.println("Get");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MyFavoritePages</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("a=" + a);
//            for (User user : users) {
                out.println(skillDao.getAllSkill());
//            }
                //out.println("<h1>Servlet MyFavoritePages at " + request.getContextPath() + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public static String getAllDataFromRequest(HttpServletRequest request) throws Exception {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();

        return body;
    }
}
