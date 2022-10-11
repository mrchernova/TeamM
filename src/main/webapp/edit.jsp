<%--
  Created by IntelliJ IDEA.
  User: mchernova
  Date: 11.10.2022
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit product</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">
  <input type="hidden" value="${product.id}" name="id" />
  <label>Name</label><br>
  <input name="name" value="${product.name}" /><br><br>
  <label>Price</label><br>
  <input name="price" value="${product.price}" type="number" min="100" /><br><br>
  <input type="submit" value="Send" />
</form>
</body>
</html>
