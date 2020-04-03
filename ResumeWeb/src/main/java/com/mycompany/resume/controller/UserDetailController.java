package com.mycompany.resume.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import java.io.IOException;
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

@WebServlet(name = "UserDetailController", urlPatterns = {"/userdetail"})
public class UserDetailController extends HttpServlet {

    private UserDaoInter userDao=Context.instanceUSerDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        String email=request.getParameter("email");
        String address=request.getParameter("address");

        User user=userDao.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setAddress(address);

        userDao.updateUser(user);

        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {//musterinin id-ni gonderib gondermediyi yoxlanilir
                throw new IllegalArgumentException("id is not specified");
//           request.setAttribute("msg","specify id");
            }
            Integer userId = Integer.parseInt(userIdStr);
            UserDaoInter userDao = Context.instanceUSerDao();
            User u = userDao.getById(userId);
            if (u == null) {// Gonderilen id-ye uygun  userin olub-olmadiginin yoxlanilmasi
                throw new IllegalArgumentException("There is no user with this id");
            }
            request.setAttribute("user",u);//musterinin gonderdiyi sorgunun icine obyekt qoyuruq
            //Map kimi user key-dir u value(u tapilan obyektdir)
            request.getRequestDispatcher("userdetail.jsp").forward(request,response);
            //Dispatcher vasitesile userdetail.jsp faylina kecid elde edirik ve bize gonderilen requesti ve responseni
            //forward ele bu jsp-ye. userdetail.jsp 1 response verir musterinin gonderdiyi request esasinda ve o response
            //userdetailin qaytarmali oldugu response kimi gosterilir
        }catch(Exception ex){
//            ex.printStackTrace();
            response.sendRedirect("error?msg="+ex.getMessage());
        }
    }
}

