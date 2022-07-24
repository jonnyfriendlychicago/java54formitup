<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
<!DOCTYPE html>
<html lang="en">
<head>
<title>java54formitup - ${person.firstName} ${person.lastName}</title>
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
	<h2>java54formitup - Person Profile</h2>
	<a href= "/">Home</a>
	<a href= "/personplus">Person List</a>
	<a href= "/personplus/${person.id}/edit">Edit</a> 
	
	<h3>firstName: <c:out value="${person.firstName}"></c:out></h3>
	<h4>lastName: <c:out value="${person.lastName}"></c:out></h4>
	<h4>person.licenseMdl.state: <c:out value="${person.licenseMdl.state}"></c:out></h4>
	<h4>person.licenseMdl.expirationDate: <c:out value="${person.licenseMdl.expirationDate}"></c:out></h4> 

	<form action="/personplus/${person.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete this person">
	</form>
 
	
</body>
</html>