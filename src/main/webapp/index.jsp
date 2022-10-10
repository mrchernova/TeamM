<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    String[] people = new String[]{"Tom", "Bob", "Sam"};
    String header = "Users list";
%>

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



<form action="orders/" method="post">
    Title: <input name="title_p" size="45"/>
    <br><br>
    Author: <input name="author_p" size="45"/>
    <br></br>
    <input type="submit" value="Save" />
</form>


</body>
</html>