<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<h1>Discover extraordinary NFTs</h1>
<table class="table table-dark">
<thead>
	<tr>
		<th>Title</th>
		<th>Description</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${arts}" var="art">
	<tr>
	<td>${art.title} </td>
	<td>${art.description} </td>
	</tr>
	</c:forEach>
</tbody>

</table>
</body>
</html>