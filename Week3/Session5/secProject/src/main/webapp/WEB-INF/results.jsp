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
<h1>Submitted Info:</h1>
<br />
Name: <c:out value="${firstName}"></c:out>
<br />
Email:<c:out value="${email}"></c:out>
<br />
Program:<c:out value="${program}"></c:out>

</body>
</html>