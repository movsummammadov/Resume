package com.mycompany.resume.controller;

import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.Country;
import com.mycompany.entity.User;
import com.mycompany.main.Context;
import com.mycompany.resume.util.ControllerUtil;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
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

    private UserDaoInter userDao=Context.instanceUserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id=Integer.parseInt(request.getParameter("id"));
            String action=request.getParameter("action");
            if("delete".equals(action)){
                userDao.removeUser(id);
            }else if("update".equals(action)){
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                String address = request.getParameter("address");
                String profileDesc = request.getParameter("profileDesc");
                String birthdateStr = request.getParameter("birthdate");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthdate = new Date(sdf.parse(birthdateStr).getTime());
//                String birthplaceStr=request.getParameter("birthplace");
//                String[] arr=birthplaceStr.split("\\(");
//                String bp=arr[0];
//                Country c=new Country(0,bp,null);
//                System.out.println(c);
//                System.out.println(bp);
                User user = userDao.getById(id);
                user.setName(name);
                user.setSurname(surname);
                user.setEmail(email);
                user.setPhone(phone);
                user.setAddress(address);
                user.setProfileDescription(profileDesc);
                user.setBirthdate(birthdate);
               // user.setBirthplace(birthplace);

                userDao.updateUser(user);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        response.sendRedirect("users");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action=request.getParameter("action");
        System.out.println(action);
        try {
            String userIdStr = request.getParameter("id");
            if (userIdStr == null || userIdStr.trim().isEmpty()) {//musterinin id-ni gonderib gondermediyi yoxlanilir
                throw new IllegalArgumentException("id is not specified");
            }
            Integer userId = Integer.parseInt(userIdStr);
            UserDaoInter userDao = Context.instanceUserDao();
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
            ControllerUtil.errorPage(response,ex);
        }
    }
}

