<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="by.trucking.model.Role" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>


<fieldset>
    <legend>MENU</legend>
<%--    <form action='<c:url value="/verifiedUser" />' method="get">--%>
<%--        <input type="submit" value="All users" >--%>
<%--        <p>User: </p>--%>
<%--    </form>--%>
<%--    <br>--%>

    <a href='<c:url value="/registration" />'>Registration</a> | <a href='<c:url value="/login" />'>Login</a>

</fieldset>


<table class="center">
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
        <th>Options</th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td name="role" value="${Role.valueOf(user.role).ordinal()}">${Role.valueOf(user.role).label}</td>

            <td>
                <a href='<c:url value="/edit_user?id=${user.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete_user" />' style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>


</body>
</html>