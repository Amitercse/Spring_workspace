<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration page</title>
</head>
<body>
    <div align="center">
        <form:form action="register.view" method="post" modelAttribute="emp">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Employee - Registration</h2></td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.username" /></td>
                    <td><form:input path="userName" /></td>
                </tr>
            	<tr>
                    <td><spring:message code="label.user.name" /></td>
                    <td><form:input path="name" /></td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.password" /></td>
                    <td><form:password path="password" /></td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.email" /></td>
                    <td><form:input path="email" /></td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.dateOfBirth" /></td>
                    <td><form:input path="dateOfBirth" /></td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.department" /></td>
                    <td><form:select path="department" items="${deptList}" /></td>
                </tr>
                <tr>
                    <td>Dummy param:</td>
                    <td>
                    <input type="text" name="dummyParam"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="<spring:message code="label.user.register" />" /></td>
                </tr>
            </table>
        </form:form>
    </div>
</body>
</html>