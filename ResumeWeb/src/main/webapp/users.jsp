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
    <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
    <title>Search Page</title>
</head>
<body>
<%
    UserDaoInter userDao = Context.instanceUSerDao();
    String name=request.getParameter("name");
    String surname=request.getParameter("surname");
    String nationalityIdStr=request.getParameter("nId");
    Integer nationaltyId=null;
    if(nationalityIdStr!=null && !nationalityIdStr.trim().isEmpty()){
    nationaltyId=Integer.parseInt(request.getParameter(nationalityIdStr));}
    List<User> list = userDao.getAllUser(name,surname,nationaltyId);

%>
<form action="users.jsp" method="GET">
    <div class="container">
        <div class="control_panel">
            <%--@declare id="surname"--%><%--@declare id="name"--%><%--@declare id="nationality"--%>
                <label for="name">Name:</label>
                <input type="text" name="name" value="" />
                <br>
                <label for="surname">Surname:</label>
                <input type="text" name="surname" value="" />
                <br>
                <label for="nationality">Nationality:</label>
                <input type="text" name="nationality" value="" />

                <input type="submit" name="search" value="Search" />
        </div>
        <div>
            <table border="2px solid">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Nationality</th>
                    <th>Operation</th>
                </tr>
                </thead>
                <tbody>
                <%for(User u:list){%>
                <tr>
                    <td><%=u.getName()%></td>
                    <td><%=u.getSurname()%></td>
                    <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>
                    <td>
                        <input type="submit" name="action" value="Delete" class="btn"/>
                        <input type="submit" name="action" value="Update" class="btn"/>
                    </td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</form>

</body>
</html>
