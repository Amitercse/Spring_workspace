<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User details</title>
</head>
<body>
<h4>List of Users</h4>
<table border="1">
<tr>
	<th>User Name</th>
	<th>Name</th>
	<th>Date of birth</th>
	<th>Email</th>
</tr>
<c:forEach var="user" items="${userList}">
  <tr>
      <td>${user.userName}</td>
      <td>${user.name}</td>
      <td>${user.dateOfBirth}</td>
      <td>${user.email}</td>
  </tr>
</c:forEach>
</table><br>
<a href="/MyApp">Go to home</a>
</body>
</html>