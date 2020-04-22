<%--
  Created by IntelliJ IDEA.
  User: Movsum Mammadov
  Date: 4/7/2020
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/login.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login</title>
</head>
<body class="login_background">
<form action="login" method="POST">
    <div class="col-4 container  login_fix_">
            <h1 style="text-align: center">Login</h1>
            <div class="form-group">
                <label>Email address:</label>
                <input type="email"  class="form-control" placeholder="email@exapmle.com" name="email"/>
            </div>
            <div class="form-group">
                <label>Password:</label>
                <input type="password"  class="form-control" placeholder="password" name="password"/>
            </div>
            <button type="submit" class="btn btn-primary" name="login">Login</button>
    </div>
</form>
</body>
</html>
