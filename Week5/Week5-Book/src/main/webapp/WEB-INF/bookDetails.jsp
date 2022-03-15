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
 
   
   <h2>Book Deatils</h2>
     <p><a href="/book/${book.id}">${book.title}</a> </p>
      <p>${book.thoughts}</p>
       <p>${book.author}</p>
       
  <c:if test="${book.user.id==loggedInUser.id}">
  <a href="">Edit</a>
  <a href="">Delete</a>
  
  </c:if>
  
  <c:forEach items="${book.ratings}" var="ratings">
   RAted BY:<p>${ratings.user.userName}</p>
  <p>${ratings.rating}</p>
  
  
  </c:forEach>
  
  <form:form action="/book/addRating" method="post" modelAttribute="newRating">
      <div class="form-group">
	        <form:label path="rating">Rating</form:label>
	        <form:errors class="text-danger" path="rating"/>
	        <form:input class="form-control" path="rating"/>
	    </div>
	      <!-- Hidden Input for userId -->
	     <form:input type="hidden" value="${loggedInUser.id}" path="user"/>
	       <!-- Hidden Input for ArtId -->
	     <form:input type="hidden" value="${book.id}" path="book"/>
	     <button>Rate it!!</button>
</form:form>
   
</body>
</html>