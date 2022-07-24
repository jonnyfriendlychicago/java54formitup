<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
	<title>java54formitup</title>
	<meta charset="UTF-8">
	<!-- local css -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<!-- local javascript -->
	<script type ="text/javascript" src="javascript/app.js"></script>
	<!--  Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> 
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<h1>java54formitup - Create New Book</h1>
	<a href= "/books">Books</a>
	<!-- <a href= "/counter">Site Visit Counter</a> -->
	
	<form:form action='/processNewBook' method='post' modelAttribute='book'>
	  <div class="form-group">
	    <form:label path="title" for="title" >Title</form:label>
	     <form:input type="text" class="form-control"  path="title" aria-describedby="titleHelp" placeholder="Enter Title"/>
	     <p><form:errors path="title"/></p>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="description" for="description">Description</form:label>
	    <form:input type="text" class="form-control" path="description" placeholder="Description here"/>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="language" for="language">Language</form:label>
	    <form:input type="text" class="form-control"  path="language" placeholder="lang here"/>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="numberOfPages" for="numberOfPages">Page Count</form:label>
	    <form:input type="number" class="form-control" path="numberOfPages"/>
	  </div>
	  <%-- 
	  <div class="form-check">
	    <form:input type="checkbox" class="form-check-form:input" id="exampleCheck1"/>
	    <form:label class="form-check-form:label" for="exampleCheck1">Check me out</form:label>
	  </div> 
	   --%>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form:form>
	
</body>
</html>