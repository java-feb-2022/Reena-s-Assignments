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
<h1>Full CRUD Save Travels</h1>
<table class="table table-dark">
<thead>
	<tr>
		<th>Expense</th>
		<th>Vendor</th>
		<th>Amount</th>
		<th>Action</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${expenses}" var="expense">
	<tr>
	<td>${expense.expenseName} </td>
	<td>${expense.vendor}</td>
	<td>$${expense.amount}</td>
	<td><a href="/edit/${expense.id}">Edit</a> 
	<form:form action="/delete/${expense.id}" method="delete">
		<button>Delete</button>
	</form:form>
	</td>
	</tr>
	</c:forEach>
</tbody>

</table>
<h1>New Book</h1>
<form:form action="/expense" method="post" modelAttribute="newExpense">
    <p>
     	<form:errors class="text-danger" path="expenseName"/>
        <form:label path="expenseName">expenseName</form:label>
        <form:input path="expenseName"/>
    </p>
    <p>
     	<form:errors class="text-danger" path="vendor"/>
        <form:label path="vendor">vendor</form:label>
        <form:input path="vendor"/>
    </p>
    <p>
    	 <form:errors class="text-danger" path="amount"/>
        <form:label path="amount">amount</form:label>
       
        <form:input path="amount"/>
    </p>
    
    <p>
    	<form:errors class="text-danger" path="description"/>
        <form:label path="description">Description</form:label>
        <form:textarea path="description"/>
    </p>
    
   <button>Submit</button>
</form:form> 
</div>
</body>
</html>