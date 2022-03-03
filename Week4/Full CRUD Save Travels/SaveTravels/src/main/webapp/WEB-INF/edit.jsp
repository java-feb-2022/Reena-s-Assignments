<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ page isErrorPage="true" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>
<h1>Update Expense</h1>
<form:form action="/update/${editExpense.id}" method="put" modelAttribute="editExpense">
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