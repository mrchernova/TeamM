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


</body>
</html>