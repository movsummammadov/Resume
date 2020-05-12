<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Search Page</title> <link rel="stylesheet" href="assets/css/users.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.13.0/css/all.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="assets/js/users.js"></script>
</head>
<body>
<div class="container mycontainer">
    <div>
        <div class="col-4">
        <form:form action="usersm" method="GET" modelAttribute="user">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input placeholder="Enter your name" class="form-control" path="name"/>
                <form:errors path="name"></form:errors>
            </div>
            <div class="form-group">
                <label for="surname">Surname:</label>
                <form:input placeholder="Enter your surname" class="form-control" path="surname" />
                <form:errors path="surname"></form:errors>
            </div>
            <form:button class="btn btn-primary"  type="submit">Search</form:button>
        </form:form>
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
                <th></th>
            </tr>
            </thead>
            <tbody>
            <%--jstl code--%>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td>${u.name}</td>
                    <td>${u.surname}</td>
                    <td>${u.nationality.nationality}</td>
                    <td class="td">
                        <input type="hidden" name="id" value="${u.id}" />
                        <input type="hidden" name="action" value="delete" />
                        <button class="btn btn-danger" type="submit" title="delete" value="delete"
                                data-toggle="modal" data-target="#exampleModal"
                                onclick="setIdForDelete(${u.id})">
                            <i class="fas fa-trash-alt"></i>
                        </button>
                    </td>
                    <td class="td">
                        <form action="userdetail" method="GET">
                            <input type="hidden" name="id" value="${u.id}" />
                            <input type="hidden" name="action" value="update" />
                            <button class="btn btn-primary" type="submit" title="update" value="update">
                                <i class="fas fa-pen-square"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete"/>
                    <input type="hidden" name="action" value="delete" />
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <input type="submit" class="btn btn-danger" value="Delete">
                </form>
            </div>
        </div>
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
