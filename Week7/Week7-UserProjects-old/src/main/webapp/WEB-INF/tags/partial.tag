<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				Dear <c:out value="${loggedInUser.userName}" />, Welcome to Coding Dojo Projects: <span class="text-danger">This is Reena's code, use it only for understanding, if you use this in exam it will be act of plagiarism </span>
		
		</h1>
		<p class="bg-dark p-3">
			<a href="/dashboard">Home</a> || 
			<a href="/new">New Project</a> || 
			<a href="/logout">Logout</a>
		</p>
		<jsp:doBody />
	</div>
</body>
</html>