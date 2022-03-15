<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

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
		<h1>
			Welcome to Projects Dashboard:
			<c:out value="${loggedInUser.userName}" />
		</h1>
		<a href="/dashboard">Home</a> || <a href="/new">New Project</a> || <a
			href="/logout">Logout</a>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Project name</th>
					<th>Created By</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${projects}" var="project">
					<tr>
						<td><a href="/projects/projectDetails/${project.id}">${project.projectName} </a>  </td>
						<td>${project.user.userName}</td>
				    </tr>
			
			</c:forEach>
					
				
			</tbody>
		</table>
	</div>
</body>
</html>