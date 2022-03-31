<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<h1>New Art</h1>

<form:form action="/create" method="post" modelAttribute="art" enctype="multipart/form-data" >

<p>
 		<form:errors class="text-danger" path="title"/>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors class="text-danger"  path="description"/>
        <form:textarea path="description"/>
        
    </p>
    <p>
     <form:label path="description">Art Image</form:label>
	       <input type="file" name="pic" id="fileToUpload" >
	   
	     </p>
<button>Submit</button>
</form:form>



</body>
</html>