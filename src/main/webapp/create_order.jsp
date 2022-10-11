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
    <title>Create order</title>
</head>
<body>
<h3>New Order</h3>
<form method="post">

    <label>Description</label><br>
    <input name="description" value="1"/><br><br>
    <label>Weight</label><br>
    <input name="weight" value="1"/><br><br>
    <label>Departure</label><br>
    <input name="departure" value="1"/><br><br>
    <label>Destination</label><br>
    <input name="destination" value="1"/><br><br>
    <label>Price</label><br>
    <input name="price" value="1"/><br><br>

    <input type="submit" value="Save" />
</form>
</body>
</html>
