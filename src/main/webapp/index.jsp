<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body>


<fieldset>
    <legend>MENU</legend>
    <br>
    <form name="orderForm" action="/part_2_war_exploded/orders" method="get">
        <input type="submit" value="show all orders" id="submitOrder">
    </form>
    <br>
    <form name="clientForm" action="/part_2_war_exploded/getclients" method="get">
        <input type="submit" value="show all clients" id="submitClient">
    </form>
    <br>
    <form name="showSmth" action="/part_2_war_exploded/index" method="get">
        <input type="submit" value="show smth" id="submitShow">
    </form>

</fieldset>


<h2>Orders List</h2>
<p><a href='<c:url value="/create_order" />'>Create new order</a></p>
<table>
    <tr><th>Description</th>
        <th>Weight</th>
        <th>Departure</th>
        <th>Destination</th>
        <th>Price</th>
        <th></th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr><td>${order.description}</td>
            <td>${order.weight}</td>
            <td>${order.departure}</td>
            <td>${order.destination}</td>
            <td>${order.price}</td>
            <td>
                <a href='<c:url value="/edit?id=${order.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${order.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>



<br>
<br>

<h2>Products List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr><th>Name</th>
        <th>Price</th>
        <th></th></tr>
    <c:forEach var="product" items="${products}">
        <tr><td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <a href='<c:url value="/edit?id=${product.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>



</body>
</html>