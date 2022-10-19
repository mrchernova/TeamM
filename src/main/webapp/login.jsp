<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="style.css" rel="stylesheet" type="text/css">
</head>

<body>
<table class="userForm">
    <tr>
        <td style="padding-top: 15px">
<%--            <form method="post" action='<c:url value="/login"/>'>--%>
            <form method="post">
                <label>Login</label><br>
                <input name="login" class="width" required/><br><br>
                <label>Password</label><br>
                <input type="password" name="password" class="width" required/><br><br>

                <input type="submit" value="Login"/>
            </form>
        </td>
    </tr>
</table>

</body>
</html>
