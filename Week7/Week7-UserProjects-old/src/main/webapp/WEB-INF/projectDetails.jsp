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
	
	<h4>Project Ratings</h4>
	<c:forEach items="${project.ratings}" var="rating">
		<p>
		Rated By: <c:out value=" ${rating.ratedBy.userName}"></c:out> ,
		Rating : <c:out value=" ${rating.rating}"></c:out> 
		</p>
	</c:forEach>
	
	<div class="card w-75 bg-dark text-white">
  	<div class="card-body">
    <h5 class="card-title">Add Rating</h5>
  <form:form action="/project/addRating" method="post" modelAttribute="newRating">
      <div class="form-group">
	        <form:label path="rating">Rating</form:label>
	        <form:errors class="text-danger" path="rating"/>
	        <form:input class="form-control" path="rating"/>
	    </div>
	      <!-- Hidden Input for userId -->
	     <form:input type="hidden" value="${loggedInUser.id}" path="ratedBy"/>
	       <!-- Hidden Input for ArtId -->
	     <form:input type="hidden" value="${project.id}" path="ratedProject"/><br />
	     <button class="btn btn-primary">Rate it!!</button>
  </form:form>
	
  </div>
</div>
	
		
	<c:if test="${project.user.id==loggedInUser.id}">
		<a href="/edit/${project.id}">Edit</a>
		<a href="/delete/${project.id}">Delete</a>	
	</c:if>
	

</t:partial>