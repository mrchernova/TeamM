<%--
  Created by IntelliJ IDEA.
  User: mchernova
  Date: 03.10.2022
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
  <link type="text/css"
        href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
  <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
  <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
  <title>Add new order</title>
</head>
<body>
<script>
  $(function() {
    $('input[name=dob]').datepicker();
  });
</script>

<form method="POST" action='OrderController' name="frmAddOrder">
  Order ID : <input type="text" readonly="readonly" name="orderid"
                   value="<c:out value="${order.orderid}" />" /> <br />
  Cargo : <input
        type="text" name="cargo"
        value="<c:out value="${order.cargo}" />" /> <br />
  Weight : <input
        type="text" name="weight"
        value="<c:out value="${order.weight}" />" /> <br />

  Departure : <input
        type="text" name="departure"
        value="<c:out value="${order.departure}" />" /> <br />

  Destination : <input
        type="text" name="destination"
        value="<c:out value="${order.destination}" />" /> <br />



  Price : <input type="text" name="price"
                 value="<c:out value="${order.price}" />" /> <br />

  <input type="submit" value="Submit" />
</form>
</body>
</html>
