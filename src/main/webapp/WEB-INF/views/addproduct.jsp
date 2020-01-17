<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spring:form action="addproduct" method="post" modelAttribute="product">
		<spring:input type="hidden" path="id" />
		<div>
			<label>Product Name: </label>
			<spring:input path="name" />
			<spring:errors path="name"></spring:errors>
			<span style="color: red">${nameError}</span>
		</div>
		<div>
			<label>Product Price</label>
			<spring:input path="price" />
			<spring:errors path="price"></spring:errors>
		</div>
		<input type="submit" value="Add Product">
	</spring:form>
</body>
</html>