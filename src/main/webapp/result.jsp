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


<%
    String id = request.getParameter("id");
    String description = request.getParameter("description");
    String weight = request.getParameter("weight");
%>

<body>
<h2>Order information</h2>

<table border="1">
    <tbody>
    <tr>
        <td>Id</td>
        <td><%= id%></td>
    </tr>
    <tr>
        <td>Description</td>
        <td><%= description%></td>
    </tr>
    <tr>
        <td>Weight</td>
        <td><%= weight%></td>
    </tr>
    </tbody>

</table>

</body>
</html>