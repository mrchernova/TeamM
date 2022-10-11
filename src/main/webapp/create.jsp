<%--
  Created by IntelliJ IDEA.
  User: mchernova
  Date: 11.10.2022
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create product</title>
</head>
<body>
<h3>New product</h3>
<form method="post">
    <label>Name</label><br>
    <input name="name"/><br><br>
    <label>Price</label><br>
    <input name="price" type="number" min="100" /><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
