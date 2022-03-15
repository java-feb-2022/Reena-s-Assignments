<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <title>Registration Page</title>
</head>
<body>
    <div class="container">
    <h1>Welcome to Projects Dashboard:  <c:out value="${loggedInUser.userName}"/> </h1>
	    <a href="">Home</a> || 
	    <a href="/new">New Project</a> || 
	    <a href="/logout">Logout</a> ||
   </div>
 
 	<table class="table table-dark">
		<thead>
			<tr>
				<th>Project name</th>
				<th>Created By</th>
				<th>Likes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
   <c:forEach items="${books}" var="book">
   <tr>
     <td><a href="/book/${book.id}">${book.title}</a> </td>
     <td>${book.thoughts}</td>
     <td>${book.borrower.userName}</td>
     <td><a href="/borrow/${book.id}">Borrow</a></td>
     
     <c:if test="${book.borrower.id==loggedInUser.id}">
     <span style="color:red">Borrowed By you!!</span>
     <td>${book.author}<a href="/return/${book.id}">Return</a></td>
     
     </c:if>
     
       
   </tr>
   </c:forEach>
   <hr />
     <c:forEach items="${availableBooks}" var="book">
     <p><a href="/book/${book.id}">${book.title}</a> </p>
     <p>${book.thoughts}</p>
     <p>${book.borrower.userName}</p>
     <p>${book.author}<a href="/borrow/${book.id}">Borrow</a></p>
     
     <c:if test="${book.borrower.id==loggedInUser.id}">
     <span style="color:red">Borrowed By you!!</span>
     <p>${book.author}<a href="/return/${book.id}">Return</a></p>
     
     </c:if>
     
       
   
   </c:forEach>
   
  
</body>
</html>