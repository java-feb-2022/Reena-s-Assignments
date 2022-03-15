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
    <div class="row">
     	<!-- User registration Form -->
	    <div class="col">
	    <h1>Register User</h1>
	   
	    <form:form method="POST" action="/registration" modelAttribute="newUser">
	      <div class="form-group">
		        <form:label path="userName">User Name:</form:label>
		        <form:errors class="text-danger" path="userName"/>
		        <form:input class="form-control" path="userName"/>
		    </div>
		    
		    <div class="form-group">
		        <form:label path="email">Email:</form:label>
		        <form:errors class="text-danger" path="email"/>
		        <form:input class="form-control" path="email"/>
		    </div>
	      <div class="form-group">
	            <form:label path="password">Password:</form:label>
	            <form:password class="form-control" path="password"/>
	             <form:errors class="text-danger" path="password"/>
	        </div>
	         <div class="form-group">
	            <form:label path="confirm">Password Confirmation:</form:label>
	            <form:password class="form-control" path="confirm"/>
	             <form:errors class="text-danger" path="confirm"/>
	        </div>
	         <br/>
	        <button class="btn btn-primary">Register</button>
	       
	    </form:form>
	    </div>
	    <!-- User Login Form -->
		<div class="col">
	    <h1>Login</h1>
	  	<form:form action="/login" modelAttribute="newLogin">
				<div class="form-row">
					<form:errors path="email" class="text-danger"/>
					<form:label for="email" path="email">Email:</form:label>
					<form:input type="text" path="email" class="form-control"/>
				</div>
				
				<div>
					<form:errors path="password" class="text-danger"/>
					<form:label for="password" path="password">Password:</form:label>
					<form:password path="password" class="form-control"/>
				</div>
				<br/>
					  <button class="btn btn-primary">Login</button>
			</form:form>
		</div>
    </div> 
 </div>
 
</body>
</html>