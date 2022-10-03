<%--
  Created by IntelliJ IDEA.
  User: mchernova
  Date: 03.10.2022
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Orders Here</title>
</head>
<body>

<table border=1>
    <thead>
    <tr>
        <th>Order Id</th>
        <th>Cargo</th>
        <th>Weight</th>
        <th>Departure</th>
        <th>Destination</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <tr>
            <td><c:out value="${order.orderid}" /></td>
            <td><c:out value="${order.cargo}" /></td>
            <td><c:out value="${order.weight}" /></td>
            <td><c:out value="${order.departure}" /></td>
            <td><c:out value="${order.destination}" /></td>
            <td><c:out value="${order.price}" /></td>


        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="OrderController?action=insert">Add User</a></p>

</body>
</html>
