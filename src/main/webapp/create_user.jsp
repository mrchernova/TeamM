<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="by.trucking.model.Role" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create user</title>
</head>
<body>
<h3>New User</h3>
<form method="post">

    <label>Login</label><br>
    <input name="login"/><br><br>
    <label>Password</label><br>
    <input name="password"/><br><br>

    <label>Role</label><br>
    <select name="role">
        <option value="${Role.getByOrdinal(1)}">${Role.getByOrdinal(1).label}</option>
        <option value="${Role.getByOrdinal(2)}">${Role.getByOrdinal(2).label}</option>
    </select>

    <br>
    <br>

    <input type="submit" value="Save"/>
</form>
</body>
</html>