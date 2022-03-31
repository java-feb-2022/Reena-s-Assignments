<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page isErrorPage="true"%>
<t:partial>
	<form:form action="/projects/create" method="post" modelAttribute="newProject" enctype="multipart/form-data">
	    <div class="form-group">
	        <form:label path="projectName">Project Name:</form:label>
	        <form:errors class="text-danger" path="projectName"/>
	        <form:input class="form-control" path="projectName"/>
	    </div>
	    <div class="form-group">
	        <form:label path="description">Project Description:</form:label>
	        <form:errors class="text-danger" path="description"/>
	        <form:textarea class="form-control" path="description"/>
	    </div>
	      <!-- Hidden Input for userId -->
	  	<form:input type="hidden" value="${loggedInUser.id}" path="user"/> 
	  	
	  	<p>
	  		<form:label path="imgUrl">Poster:</form:label>
	  		<input type="file" name="pic" id="fileToUpload">
	  	</p>   
	  
	   
	    <input type="submit" class="btn btn-primary" value="Submit"/>
	</form:form>    
</t:partial>