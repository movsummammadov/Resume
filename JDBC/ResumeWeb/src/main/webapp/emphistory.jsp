<%@ page import="com.mycompany.dao.inter.EmploymentHistoryDaoInter" %>
<%@ page import="com.mycompany.main.Context" %>
<%@ page import="com.mycompany.entity.EmploymentHistory" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.dao.inter.UserDaoInter" %><%--
  Created by IntelliJ IDEA.
  User: movsu
  Date: 4/8/2020
  Time: 20:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="assets/css/users.css" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="assets/js/users.js"></script>
    <title>Employment History</title>
</head>
<body>
<%
    EmploymentHistoryDaoInter empDao= Context.instanceEmploymentHistoryDao();
    List<EmploymentHistory> emplist=empDao.getAllImploymentHistoryUserId(1);

%>
<div class="wrapper-editor">
    <table id="dt-more-columns" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
        <tr>
<%--            <th class="th-sm">№</th>--%>
            <th class="th-sm-2">Header</th>
            <th class="th-sm-2">Begin Date</th>
            <th class="th-sm-2">End Date</th>
            <th class="th-sm-2">Job Description</th>
            <th class="th-sm-2"></th>
            <th class="th-sm-2"></th>
        </tr>
        </thead>
        <%for(EmploymentHistory emp:emplist){%>
        <tbody>
        <tr>
<%--            <td><%=emp.getId()%></td>--%>
            <td><%=emp.getHeader()%></td>
            <td><%=emp.getBeginDate()%></td>
            <td><%=emp.getEndDate()%></td>
            <td><%=emp.getJobDescription()%></td>
            <td class="td_btn_view">
                <input type="hidden" name="id" value="<%=emp.getId()%>" />
                <input type="hidden" name="action" value="delete" />
                <button class="btn btn-danger" type="submit" title="delete" value="delete"
                        data-toggle="modal" data-target="#deleteModal"
                        onclick="setIdForDelete(<%=emp.getId()%>)">
                    <i class="fas fa-trash-alt"></i>
                </button>
            </td>
        </tr>
        </tbody>
        <%}%>
    </table>
</div>

<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteLabel">delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure
            </div>
            <div class="modal-footer">
                <form action="emphistory" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete"/>
                    <input type="hidden" name="action" value="delete" />
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="delete">
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
