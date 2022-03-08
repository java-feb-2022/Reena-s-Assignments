<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<h1>Let's get fit!!!</h1>
<a href="/">Home</a> ||
<a href="/trainer">New Trainer</a> ||
<a href="/new">New Fitness Class</a>

<table class="table table-striped">
<thead>
	<tr>
		<th>Class id</th>
		<th>Name</th>
		<th>Trainer</th>
		<th>Trainer Email</th>
	</tr>
</thead>
	<c:forEach items="${fitnessClasses}" var="myClass">
		<tr>
		<td>${myClass.id} </td>
		<td>${myClass.name} </td>
		<td>${myClass.trainer.name} </td>
		<td>${myClass.trainer.email} </td>
		</tr>
	
	</c:forEach>
<tbody>
	
</tbody>

</table>
</body>
</html>