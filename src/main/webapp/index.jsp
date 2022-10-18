<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="by.trucking.model.Role" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body>


<fieldset>
    <legend>MENU</legend>

    <form name="showUsers" action="/part_2_war_exploded/index" method="get">
        <input type="submit" value="CRUD Users" id="submitShow">
    </form>

</fieldset>


<h2>Orders List</h2>
<p><a href='<c:url value="/create_user" />'>Create new user</a></p>
<table>
    <tr>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
        <th></th>
    </tr>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.role}</td>

            <td>
                <a href='<c:url value="/edit_user?id=${user.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete_user" />' style="display:inline;">
                    <input type="hidden" name="id" value="${user.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>




</body>
</html>