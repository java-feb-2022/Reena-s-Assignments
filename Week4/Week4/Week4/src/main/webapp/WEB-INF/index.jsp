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
<h1>Discover extraordinary NFTs</h1>
<a href="/new">New Art</a>
<table class="table table-dark">
<thead>
	<tr>
		<th>Title</th>
		<th>Description</th>
		<th>Action</th>
	
	</tr>
</thead>
<tbody>
	<c:forEach items="${arts}" var="art">
	<tr>
    <td> <a href="/arts/art/${art.id}">${art.title}"</a></td>
	<td>${art.description} </td>
	<td>
	
	<a href="/edit/${art.id}">Edit</a>
	<%-- <a href="/delete/${art.id}">Delete</a>
	 --%>
	 <form:form action="/delete/${art.id}" method="delete">
		<button>Delete</button>	 
	 </form:form>
	 
	</td>
	
	</tr>
	</c:forEach>
</tbody>

</table>
</body>
</html>