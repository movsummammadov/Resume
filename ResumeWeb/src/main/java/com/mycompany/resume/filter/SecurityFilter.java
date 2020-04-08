package com.mycompany.resume.filter;

import com.mycompany.resume.util.ControllerUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "SecurityFileFilter", urlPatterns = {"*"})
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res=(HttpServletResponse) response;
        HttpServletRequest req=(HttpServletRequest) request;
        if(!req.getRequestURI().contains("/login") && req.getSession().getAttribute("loggedInUser")==null){
            res.sendRedirect("login");
        }else{
            chain.doFilter(request,response);
        }
    }
}