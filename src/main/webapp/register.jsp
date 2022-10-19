<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.trucking.model.Role" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<table class="userForm">
    <tr>
        <td style="padding-top: 15px">
            <form method="post" action='<c:url value="/register"/>'>
                <label>Login</label><br>
                <input name="login" class="width" required/><br><br>
                <label>Password</label><br>
                <input type="password" name="password" class="width" required/><br><br>

                <label>Role</label><br>
                <select name="role" class="width">
                    <option value="${Role.getByOrdinal(1)}">${Role.getByOrdinal(1).label}</option>
                    <option value="${Role.getByOrdinal(2)}">${Role.getByOrdinal(2).label}</option>
                </select>
                <br>
                <br>
                <input type="submit" value="Register"/>
            </form>
        </td>
    </tr>
</table>

</body>
</html>