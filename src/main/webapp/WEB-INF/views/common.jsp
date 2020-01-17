<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="logout">Logout</a>

	<security:authorize access="hasRole('ROLE_ADMIN')">
		<button>Admin Button</button>
	</security:authorize>
	<security:authorize access="hasRole('ROLE_USER')">
		<button>User Button</button>
	</security:authorize>
</body>
</html>