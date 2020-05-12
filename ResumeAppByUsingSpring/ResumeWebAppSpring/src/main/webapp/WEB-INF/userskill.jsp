<%@ page import="com.mycompany.dao.inter.SkillDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.entity.Skill" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.dao.inter.UserSkillDaoInter" %>
<%@ page import="com.mycompany.entity.UserSkill" %><%--
  Created by IntelliJ IDEA.
  User: movsu
  Date: 4/10/2020
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        SkillDaoInter skillDao= Context.instanceSkillDao();
        List<Skill> skillList=skillDao.getAllSkill();
        UserSkillDaoInter userSkillDao=Context.instanceUserSkillDao();
        List<UserSkill> userSkillList=userSkillDao.getUserSkillByUserId(1);
    %>
    <link rel="stylesheet" href="../assets/css/users.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="../assets/js/users.js"></script>
    <title>Skill</title>
</head>
<body>
<div class="container col-4">
    <select>
        <%for(Skill sk:skillList){%>
        <option><%=sk.getName()%></option>
        <%}%>
    </select>
    <label>Skill</label>
    <input type="text" class="form-control" name="skill" placeholder="skill add" />
</div>
<div>
    <table class="table table-striped table-bordered">
        <thead>
        <tr>
            <th>Name</th>
            <th>Power</th>
        </tr>
        </thead>
        <%for(UserSkill usk: userSkillList){%>
        <tbody>
        <tr>
            <td><%=usk.getSkill().getName()%></td>
            <td><%=usk.getPower()%></td>
        </tr>
        </tbody>
        <%}%>
    </table>
</div>
</body>
</html>
