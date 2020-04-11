package com.mycompany.resume.controller;

import com.mycompany.dao.inter.EmploymentHistoryDaoInter;
import com.mycompany.entity.EmploymentHistory;
import com.mycompany.main.Context;
import com.mycompany.resume.util.ControllerUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Movsum Mammadov
 *
 */

@WebServlet(name = "EmpHistoryController", urlPatterns = {"/emphistory"})
public class EmpHistoryController extends HttpServlet {

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    private EmploymentHistoryDaoInter empDao= Context.instanceEmploymentHistoryDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("emphistory.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String action=request.getParameter("action");
        if("delete".equals(action)){
            empDao.removeEmploymentHistory(id);
        }else{
            try {
                String header = request.getParameter("header");
                String beginDateStr = request.getParameter("begindate");
                Date beginDate = new Date(sdf.parse(beginDateStr).getTime());
                String endDateStr=request.getParameter("enddate");
                Date endDate=new Date(sdf.parse(endDateStr).getTime());
                String jobDesc=request.getParameter("jobdesc");
                EmploymentHistory emp=new EmploymentHistory();
                emp.setHeader(header);
                emp.setBeginDate(beginDate);
                emp.setEndDate(endDate);
                emp.setJobDescription(jobDesc);
                System.out.println("a="+action);
                if("update".equals(action)) {
                    empDao.addEmploymentHistory(emp);
                }
            }catch(Exception ex){
                ex.printStackTrace();
                ControllerUtil.errorPage(response,new IllegalArgumentException("Tarixi duzgun daxil edin"));
            }
        }
        response.sendRedirect("emphistory");
    }
}
