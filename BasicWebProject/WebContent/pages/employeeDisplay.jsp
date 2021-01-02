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
<h1>List of employees</h1>
<table border="1">
<tr>
	<th>Employee Id</th>
	<th>Employee Name</th>
</tr>
<c:forEach var="employee" items="${requestScope.empList}">
  <tr>
      <td>${employee.employeeId}</td>
      <td>${employee.employeeName}</td>
  </tr>
</c:forEach>
</table>
<a href="index.jsp">Go to login page</a>
</body>
</html>