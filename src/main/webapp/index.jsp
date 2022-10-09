<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<%--<jsp:forward page="/getorders"/>--%>
<fieldset>
    <legend>MENU</legend>
    <br>
    <form name="orderForm" action="/part_2_war_exploded/getorders" method="get">
        <input type="submit" value="show all orders" id="submitOrder">
    </form>
    <br>
    <form name="clientForm" action="/part_2_war_exploded/getclients" method="get">
        <input type="submit" value="show all clients" id="submitClient">
    </form>

</fieldset>


<table border="1">

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

   <tr>
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
   </tr>

</table>
<p><a href="OrderController?action=insert">Add Order ???</a></p>
<br>
<br>
<br>

<form action="hello" method="POST">
    Name: <input name="username" />
    <br><br>
    Age: <input name="userage" />
    <br><br>
    Gender: <input type="radio" name="gender" value="female" checked />Female
    <input type="radio" name="gender" value="male" />Male
    <br><br>
    Country: <select name="country">
    <option>Canada</option>
    <option>Spain</option>
    <option>France</option>
    <option>Germany</option>
</select>
    <br><br>
    Courses:
    <input type="checkbox" name="courses" value="JavaSE" checked />Java SE
    <input type="checkbox" name="courses" value="JavaFX" checked />Java FX
    <input type="checkbox" name="courses" value="JavaEE" checked />Java EE
    <br><br>
    <input type="submit" value="Submit" />
</form>

</body>
</html>