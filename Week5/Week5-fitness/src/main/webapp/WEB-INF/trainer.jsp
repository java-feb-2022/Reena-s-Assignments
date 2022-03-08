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
<h1>New Fitness Class</h1>
<a href="/">Home</a> ||
<a href="/trainer">New Trainer</a> ||
<a href="/new">New Fitness Class</a>

<form:form action="/createTrainer" method="post" modelAttribute="newTrainer">

<p>
 		<form:errors class="text-danger" path="name"/>
        <form:label path="name">Name:</form:label>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors class="text-danger"  path="email"/>
        <form:textarea path="email"/>
    </p>
    <p>
     
    </p>
<button>Submit</button>
</form:form>

</body>
</html>