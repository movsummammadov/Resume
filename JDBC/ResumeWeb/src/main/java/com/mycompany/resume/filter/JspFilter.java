package com.mycompany.resume.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "JspFileFilter", urlPatterns = {"*.jsp"})
public class JspFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain){
        HttpServletResponse res=(HttpServletResponse) response;
        try {
            res.sendRedirect("error?msg=not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}