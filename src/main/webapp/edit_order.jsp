<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mchernova
  Date: 12.10.2022
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Edit order</title>
</head>
<body>
<h3>Edit order</h3>
<form method="post">
    <input type="hidden" value="${order.id}" name="id"/>
    <label>Description</label><br>
    <input name="description" value="${order.description}"/><br><br>
    <label>Weight</label><br>
    <input name="weight" value="${order.weight}"/><br><br>
    <label>Departure</label><br>
    <input name="departure" value="${order.departure}"/><br><br>
    <label>Destination</label><br>
    <input name="destination" value="${order.destination}"/><br><br>
    <label>Price</label><br>
    <input name="price" value="${order.price}"/><br><br>
    <label>Status</label><br>
    <select name="status">
        <c:forEach var="type" items="<%= by.trucking.model.Status.values() %>">
            <option value="${type}">${type}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Send"/>
</form>
</body>
</html>
