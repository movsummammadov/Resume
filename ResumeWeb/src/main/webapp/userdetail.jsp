<%--
  Created by IntelliJ IDEA.
  User: Movsum Mammadov
  Date: 3/28/2020
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>

<%@page import="com.mycompany.entity.User"%>
<%@page import="com.mycompany.main.Context"%>
<%@page import="com.mycompany.dao.inter.UserDaoInter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUSerDao();
    String userIdStr=request.getParameter("id");
    if(userIdStr==null || userIdStr.trim().isEmpty()){%>
specificy id
     <%
    }else{
    Integer userId=Integer.parseInt(userIdStr);
    User u = userDao.getById(userId);
    if(u==null){%>
    There is no user with this id
<%
    }else{
%>
<form action="UserController" method="POST">
    <div>
        <%--@declare id="surname"--%>
        <%--@declare id="name"--%>
            <input type="hidden" name="id" value="<%=u.getId()%>" />
            <label for="name">Name:</label>
            <input type="text" name="name" value="<%=u.getName()%>" />
            <br>
            <label for="surname">Surname:</label>
            <input type="text" name="surname" value="<%=u.getSurname()%>" />
            <hr>
            <br>
            <label for="surname">Email:</label>
            <input type="email" name="email" value="<%=u.getEmail()%>" />
            <br>
            <label for="surname">Address:</label>
            <input type="text" name="address" value="<%=u.getAddress()%>" />
            <input type="submit" name="save" value="Save" />
    </div>
</form>
<%}%>
<%}%>
</body>
</html>
