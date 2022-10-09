<%--
  Created by IntelliJ IDEA.
  User: mchernova
  Date: 05.10.2022
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order information</title>
</head>


<body>
<table border="1">
    <thread>
        <tr>
            <th>order id</th>
            <th>order description</th>
            <th>order weight</th>
            <th>order departure</th>
            <th>order destination</th>
            <th>order price</th>
            <th>order client_id</th>
            <th>order status_id</th>
        </tr>
    </thread>
    <tbody>
    <c:forEach items="${orders}" var="order">
        <td><c:out value="${order.id}"/></td>
        <td><c:out value="${order.description}"/></td>
        <td><c:out value="${order.weight}"/></td>
        <td><c:out value="${order.departure}"/></td>
        <td><c:out value="${order.destination}"/></td>
        <td><c:out value="${order.price}"/></td>
        <td><c:out value="${order.client_id}"/></td>
        <td><c:out value="${order.status_id}"/></td>
    </c:forEach>
    </tbody>
</table>
<p><a href="OrderController?action=insert">Add Order ???</a></p>


</body>
</html>