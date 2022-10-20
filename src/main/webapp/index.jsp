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

    <a href='<c:url value="/registration" />'>Registration</a> | <a href='<c:url value="/login" />'>Login</a>

</fieldset>


</body>
</html>