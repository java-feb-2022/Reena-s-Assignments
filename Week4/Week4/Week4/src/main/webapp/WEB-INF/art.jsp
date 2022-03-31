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

 <div class="card">
            <div class="row">
                <div class="col-sm-5">
                    <img class="card-img" src="${art.artUrl}" alt="NFT Art">
                </div>
                <div class="col-sm-7">
                    <div class="card-body">
                        <h5 class="card-title"> ${art.title} </h5>
                       
                         <p class="card-text">${art.description}</p>
                       
                    </div>
                    	<hr>
                </div>
                </div>
                </div>
                
                </body>
                </html>
                