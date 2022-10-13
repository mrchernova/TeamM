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
    <form name="orderForm" action="/part_2_war_exploded/orders" method="get">
        <input type="submit" value="show all orders" id="submitOrder">
    </form>

</fieldset>


</body>
</html>