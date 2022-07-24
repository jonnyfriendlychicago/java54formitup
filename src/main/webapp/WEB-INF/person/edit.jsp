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
	<h1>java54formitup - Edit Person</h1>
	<a href= "/person">Person List</a>
	
	<form:form action='/person/${person.id}/edit' method='post' modelAttribute='person'>
	
	<form:hidden value="${person.id}" path="id"/>
	
	  <div class="form-group">
	    <form:label path="firstName" for="firstName" >firstName</form:label>
	     <form:input type="text" class="form-control"  path="firstName" aria-describedby="firstNameHelp" placeholder="Enter firstName"/>
	     <p class="errorText"><form:errors path="firstName"/></p>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="lastName" for="lastName">lastName</form:label>
	    <form:input type="text" class="form-control" path="lastName" placeholder="lastName here"/>
	    <p class="errorText"><form:errors path="lastName"/></p>
	  </div>
	  
	  <%-- <div class="form-group">
	    <form:label path="personAmount" for="personAmount">personAmount</form:label>
	    <form:input type="number" class="form-control"  path="personAmount" 
	    min="0.00" step="0.01" value="0.00"
	     />
	    <p><form:errors path="personAmount"/></p>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="personDescription" for="personDescription">personDescription</form:label>
	    <form:input type="text" class="form-control" path="personDescription"  />
	    <p><form:errors path="personDescription"/></p>
	  </div>
	   --%>
	  <%-- 
	  <div class="form-check">
	    <form:input type="checkbox" class="form-check-form:input" id="exampleCheck1"/>
	    <form:label class="form-check-form:label" for="exampleCheck1">Check me out</form:label>
	  </div> 
	   --%>
	  <button type="submit" class="btn btn-primary">Update</button>
	</form:form>
	
</body>
</html>