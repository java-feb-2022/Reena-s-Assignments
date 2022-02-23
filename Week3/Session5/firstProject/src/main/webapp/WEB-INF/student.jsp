<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to SpringBoot!!!</h1>

<p>Name: <c:out value="${student}"></c:out></p>
<p>City: <c:out value="${city}"></c:out></p>
<p>Email: <c:out value="${email}"></c:out></p>

<a href="/student/stacks">Stacks</a>

</body>
</html>