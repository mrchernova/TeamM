
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <meta charset="UTF-8">
  <title>Edit user</title>
</head>
<body>
<h3>Edit user</h3>
<form method="post">
  <input type="hidden" value="${user.id}" name="id"/>
  <label>Login</label><br>
  <input name="description" value="${user.login}"/><br><br>
  <label>Password</label><br>
  <input name="weight" value="${user.password}"/><br><br>

  <label>Role</label><br>
  <select name="role">
    <c:forEach var="type" items="<%= by.trucking.model.Role.values() %>">
      <option value="${type}">${type}</option>
    </c:forEach>
  </select>

  <input type="submit" value="Send"/>
</form>
</body>
</html>