<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<title>Project Page</title>
</head>
<body>
	<div class="container">
	<a href="/dashboard">Home</a> || <a href="/new">New Project</a> || <a
			href="/logout">Logout</a>
	<h1>Project Details</h1>
	<p>${project.projectName}</p>
	<p>${project.description}</p>
	<h4>Created By:</h4>
	<p>${project.user.userName}</p>
	
	<c:if test="${project.user.id==loggedInUser.id}">
		<a href="/edit/${project.id}">Edit</a>
		<a href="/delete/${project.id}">Delete</a>	
	</c:if>
	
	</div>
</body>
</html>