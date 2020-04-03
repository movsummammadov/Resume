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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
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
<div class="container mycontainer">
    <div >
        <div class="col-4">
        <form action="users.jsp" method="GET">
            <%--@declare id="surname"--%><%--@declare id="name"--%><%--@declare id="nationality"--%>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" placeholder="Enter your name" class="form-control" name="name" value="" />
            </div>
            <div class="form-group">
                <label for="surname">Surname:</label>
                <input type="text" placeholder="Enter your surname" class="form-control" name="surname" value="" />
            </div>
            <div class="form-group">
                <label for="nationality">Nationality:</label>
                <input type="text" placeholder="Enter your nationality" class="form-control" name="nationality" value="" />
            </div>
            <input class="btn btn-primary" type="submit" name="search" value="Search"/>
        </form>
    </div>
    </div>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Surname</th>
                <th>Nationality</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%for(User u:list){%>
            <tr>
                <td><%=u.getName()%></td>
                <td><%=u.getSurname()%></td>
                <td><%=u.getNationality().getName()==null?"N/A":u.getNationality().getName()%></td>
                <td>
                    <button class="btn btn-danger" type="submit" title="delete" value="delete" name="action">
                        <i class="fas fa-trash-alt"></i>
                    </button>
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="id" value="<%=u.getId()%>" />
                        <button class="btn btn-primary" type="submit" title="update" value="update" name="action">
                            <i class="fas fa-pen-square"></i>
                        </button>
                    </form>
                </td>
            </tr>
            <%}%>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>



<%--        <div class="col-sm-4">--%>
<%--            <form action="users.jsp" method="GET">--%>
<%--                &lt;%&ndash;@declare id="surname"&ndash;%&gt;&lt;%&ndash;@declare id="name"&ndash;%&gt;&lt;%&ndash;@declare id="nationality"&ndash;%&gt;--%>
<%--                <div class="form-group">--%>
<%--                    <label for="name">Name:</label>--%>
<%--                    <input type="text" placeholder="Enter your name" class="form-control" name="name" value="" />--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="surname">Surname:</label>--%>
<%--                    <input type="text" placeholder="Enter your surname" class="form-control" name="surname" value="" />--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="nationality">Nationality:</label>--%>
<%--                    <input type="text" placeholder="Enter your nationality" class="form-control" name="nationality" value="" />--%>
<%--                </div>--%>
<%--                <input class="btn btn-primary" type="submit" name="search" value="Search"/>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--        <div class="col-sm-4">--%>
<%--            <form action="users.jsp" method="GET">--%>
<%--                &lt;%&ndash;@declare id="surname"&ndash;%&gt;&lt;%&ndash;@declare id="name"&ndash;%&gt;&lt;%&ndash;@declare id="nationality"&ndash;%&gt;--%>
<%--                <div class="form-group">--%>
<%--                    <label for="name">Name:</label>--%>
<%--                    <input type="text" placeholder="Enter your name" class="form-control" name="name" value="" />--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="surname">Surname:</label>--%>
<%--                    <input type="text" placeholder="Enter your surname" class="form-control" name="surname" value="" />--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="nationality">Nationality:</label>--%>
<%--                    <input type="text" placeholder="Enter your nationality" class="form-control" name="nationality" value="" />--%>
<%--                </div>--%>
<%--                <input class="btn btn-primary" type="submit" name="search" value="Search"/>--%>
<%--            </form>--%>
<%--        </div>--%>
<%--        <div class="col-sm-4">--%>
<%--            <form action="users.jsp" method="GET">--%>
<%--                &lt;%&ndash;@declare id="surname"&ndash;%&gt;&lt;%&ndash;@declare id="name"&ndash;%&gt;&lt;%&ndash;@declare id="nationality"&ndash;%&gt;--%>
<%--                <div class="form-group">--%>
<%--                    <label for="name">Name:</label>--%>
<%--                    <input type="text" placeholder="Enter your name" class="form-control" name="name" value="" />--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="surname">Surname:</label>--%>
<%--                    <input type="text" placeholder="Enter your surname" class="form-control" name="surname" value="" />--%>
<%--                </div>--%>
<%--                <div class="form-group">--%>
<%--                    <label for="nationality">Nationality:</label>--%>
<%--                    <input type="text" placeholder="Enter your nationality" class="form-control" name="nationality" value="" />--%>
<%--                </div>--%>
<%--                <input class="btn btn-primary" type="submit" name="search" value="Search"/>--%>
<%--            </form>--%>
<%--        </div>--%>
