<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page isErrorPage="true"%>
<t:partial>
	<h1>Project Details</h1>
	<p>${project.projectName}</p>
	<p>${project.description}</p>
	<h4>Created By:</h4>
	<p>${project.user.userName}</p>
	
	<c:if test="${project.user.id==loggedInUser.id}">
		<a href="/edit/${project.id}">Edit</a>
		<a href="/delete/${project.id}">Delete</a>	
	</c:if>
	
</t:partial>