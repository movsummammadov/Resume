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
//            if(request.getParameter("save")!=null && request.getParameter("save").equals("Save")){
//            int id = Integer.valueOf(request.getParameter("id"));
//            String name = request.getParameter("name");
//            String surname = request.getParameter("surname");
//
//            User user = userDao.getById(id);
//            user.setName(name);
//            user.setSurname(surname);
//
//            userDao.updateUser(user);
//            response.sendRedirect("user.jsp");
//            }
    User u = userDao.getById(1);
%>
<form action="UserController" method="POST">
    <div>
        <input type="hidden" name="id" value="<%=u.getId()%>" />
        <label for="name">Name:</label>
        <input type="text" name="name" value="<%=u.getName()%>" />
        <br>
        <label for="name">Surname:</label>
        <input type="text" name="surname" value="<%=u.getSurname()%>" />
        <input type="submit" name="save" value="Save" />
    </div>
</form>

</body>
</html>
