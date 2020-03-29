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
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Search Page</title>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUSerDao();
    List<User> list = userDao.getAllUser();
%>
<form action="UserController" method="POST">
    <div>
        <%--@declare id="surname"--%>
        <%--@declare id="name"--%>
        <input type="hidden" name="id" value="" />
        <label for="name">Name:</label>
        <input type="text" name="name" value="" />
        <br>
        <label for="surname">Surname:</label>
        <input type="text" name="surname" value="" />
        <input type="submit" name="search" value="Search" />
    </div>
    <div>
        <table border="2">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Nationality</th>
            </tr>
            </thead>
            <tbody>
            <%for(User u:list){%>
            <tr>
                <td><%=u.getName()%></td>
                <td><%=u.getSurname()%></td>
                <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</form>

</body>
</html>
