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
<h1>New Trainer</h1>
<a href="/">Home</a>
<a href="/trainer">New Trainer</a> ||
<a href="/new">New Book</a>

<form:form action="/createBook" method="post" modelAttribute="newBook">
    <p>
 		<form:errors class="text-danger" path="title"/>
        <form:label path="title">Title:</form:label>
        <form:input path="title"/>
    </p>
    <p>
 		<form:errors class="text-danger" path="author"/>
        <form:label path="author">Author:</form:label>
        <form:input path="author"/>
    </p>
    <p>
        <form:label path="thoughts">thoughts</form:label>
        <form:errors class="text-danger" path="thoughts"/>
        <form:textarea path="thoughts"/>
    </p>
      <!-- Hidden Input for userId -->
	     <form:input type="hidden" value="${loggedInUser.id}" path="user"/>
	<button>Submit</button>
</form:form>
</body>
</html>