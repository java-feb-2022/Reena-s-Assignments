<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page isErrorPage="true"%>
<t:partial>
	<form:form action="/update/${editProject.id}" method="put" modelAttribute="editProject">
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
	    <input type="submit" class="btn btn-primary" value="Submit"/>
	</form:form>    
</t:partial>
