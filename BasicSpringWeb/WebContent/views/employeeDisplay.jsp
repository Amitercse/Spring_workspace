<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee list</title>
</head>
<body>
<h4>List of employees</h4>
<table>
<tr>
	<th>User Name</th>
	<th>Name</th>
	<th>Date of birth</th>
	<th>Email</th>
	<th>Department</th>
</tr>
<c:forEach var="employee" items="${empList}">
  <tr>
      <td>${employee.userName}</td>
      <td>${employee.name}</td>
      <td>${employee.dateOfBirth}</td>
      <td>${employee.email}</td>
      <td>${employee.department}</td>
  </tr>
</c:forEach>
</table><br>
<a href="index.jsp">Go to home</a>
</body>
</html>