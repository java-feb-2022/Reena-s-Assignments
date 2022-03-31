<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ page isErrorPage="true"%>
<t:partial>

	<div class="card">
		<div class="row no-gutters">
			<div class="col-sm-5">
				<img src="${project.imgUrl}" alt="" />
			</div>
			<div class="col-sm-7">
				<div class="card-body">
					<h1>Project Details</h1>
					<p>${project.projectName}</p>
					<p>${project.description}</p>
					<h4>Created By:</h4>
					<p>${project.user.userName}</p>



					<h3>These are the ratings for this project</h3>
					<c:forEach items="${project.ratings}" var="rating">
						<p>
							Rated By:
							<c:out value="${rating.ratedBy.userName}" />
							, Rating:
							<c:out value="${rating.rating}" />
						</p>
					</c:forEach>
					<hr />

					<c:choose>
						<c:when test="${project.isNotRatedByUser(loggedInUser.id)}">
							<h2>Ratings:</h2>
							<form:form action="/project/rating/${project.id}" method="post"
								modelAttribute="newRating">
								<div class="form-group">
									<form:label path="rating">Rating :</form:label>
									<form:errors class="text-danger" path="rating" />
									<form:input class="form-control" path="rating" />
								</div>
								<!-- Hidden Values for user id and project id  -->
								<form:input type="hidden" value="${loggedInUser.id}"
									path="ratedBy" />
								<form:input type="hidden" value="${project.id}"
									path="ratedProject" />

								<input type="submit" class="btn btn-primary" value="Rate it!!" />
							</form:form>
						</c:when>
						<c:otherwise>
							<h2>You have already rated this project!!!</h2>
						</c:otherwise>
					</c:choose>


					<c:if test="${project.user.id==loggedInUser.id}">
						<a href="/edit/${project.id}">Edit</a>
						<a href="/delete/${project.id}">Delete</a>
					</c:if>

				</div>
			</div>
		</div>
	</div>





</t:partial>