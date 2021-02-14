<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<div align="right">
<a href="logout">Logout</a>
</div>
<div align="center">
        <form:form action="adminRegister.view" method="post" modelAttribute="user">
            <table border="0">
                <tr>
                    <td colspan="2" align="center"><h2>Employee - Registration</h2></td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.username" /></td>
                    <td>
                    <form:input path="userName" />
                    <form:errors path="userName" cssStyle="color : red;"></form:errors>
                    </td>
                </tr>
            	<tr>
                    <td><spring:message code="label.user.name" /></td>
                    <td>
                    <form:input path="name" />
                    <form:errors path="name" cssStyle="color : red;"></form:errors>
                    </td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.password" /></td>
                    <td>
                    <form:password path="password" />
                    <form:errors path="password" cssStyle="color : red;"></form:errors>
                    </td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.email" /></td>
                    <td>
                    <form:input path="email" />
                    <form:errors path="email" cssStyle="color : red;"></form:errors>
                    </td>
                </tr>
                <tr>
                    <td><spring:message code="label.user.dateOfBirth" /></td>
                    <td>
                    <form:input path="dateOfBirth" />
                    <form:errors path="dateOfBirth" cssStyle="color : red;"></form:errors>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="<spring:message code="label.user.register" />" /></td>
                </tr>
            </table>
        </form:form>
    </div>
    <div align="center">
    	<a href="/MyApp">Go to home</a>
    </div>
</body>
</html>