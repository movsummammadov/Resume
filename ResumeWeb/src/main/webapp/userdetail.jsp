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
<%--    <link rel="stylesheet" href="assets/css/users.css">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%
    User u=(User) request.getAttribute("user");
%>
<div>
    <div class="container mycontainer">
        <div class="col-4">
            <form action="userdetail" method="POST">
        <%--@declare id="surname"--%>
        <%--@declare id="name"--%>
            <input type="hidden" name="id" value="<%=u.getId()%>" />
            <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" name="name" class="form-control" value="<%=u.getName()%>" />
            </div>
            <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" name="surname" class="form-control" value="<%=u.getSurname()%>" />
            </div>
            <div class="form-group">
            <label for="surname">Email:</label>
            <input type="email" name="email" class="form-control" value="<%=u.getEmail()%>" />
            </div>
            <div class="form-group">
                <%--@declare id="phone"--%><label for="phone">Phone:</label>
                <input type="text" name="phone" class="form-control" value="<%=u.getPhone()%>" />
            </div>
            <div class="form-group">
            <%--@declare id="address"--%><label for="address">Address:</label>
            <input type="text" name="address" class="form-control" value="<%=u.getAddress()%>" />
            </div>
            <div class="form-group">
                <%--@declare id="profiledesc"--%><label for="profileDesc">Profile Description:</label>
                    <textarea name="profileDesc" class="form-control" >
                        <%=u.getProfileDescription()%>
                    </textarea>
            </div>
            <div class="form-group">
                <%--@declare id="birthdate"--%><label for="birthdate">Birthdate:</label>
                <input type="date" name="birthdate" class="form-control" value="<%=u.getBirthdate()%>"/>
            </div>
            <input  class="btn btn-primary" type="submit" name="save" value="Save" />
    </form>
        </div>
    </div>
</div>
</body>
</html>
