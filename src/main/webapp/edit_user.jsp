<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.trucking.model.Role" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Change password</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
<h3>Change password</h3>
<table class="userForm">
    <tr>
        <td style="padding-top: 15px">
            <form method="post">
                <input type="hidden" value="${user.id}" name="id" class="width"/>
                <label>Login</label><br>
                <input name="login" value="${user.login}" class="width" disabled/><br><br>
                <label>Password</label><br>
                <input name="password" value="${user.password}" class="width" required/><br><br>

                <label>Role</label><br>
                <input name="role" value="${user.role}" class="width" disabled/><br><br>
                <%--  <select name="role">--%>
                <%--    <c:forEach var="type" items="<%= by.trucking.model.Role.values() %>">--%>
                <%--      <option value="${type}">${type}</option>--%>
                <%--    </c:forEach>--%>
                <%--  </select>--%>


                <%--  <select name="role" class="width">--%>
                <%--    <option value="${Role.getByOrdinal(3)}">${Role.getByOrdinal(3).label}</option>--%>
                <%--    <option value="${Role.getByOrdinal(1)}">${Role.getByOrdinal(1).label}</option>--%>
                <%--    <option value="${Role.getByOrdinal(2)}">${Role.getByOrdinal(2).label}</option>--%>
                <%--  </select>--%>
                <br>
                <br>
                <input type="submit" value="Send"/>
            </form>
        </td>
    </tr>
</table>
</body>
</html>