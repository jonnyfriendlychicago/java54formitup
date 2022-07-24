<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
<!DOCTYPE html>
<html lang="en">
<head>
<title>java54formitup - ${ninja.firstName} ${ninja.lastName}</title>
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
	<div id=header class="container-fluid">
		<h1>java54formitup</h1>
		<a href= "/">Home</a>
		<a href="/dojo">Dojo List</a>
		<a href= "/ninja">Ninja List</a>
		<h2>Ninja Profile</h2>
	</div>
	<div id=main class="container-fluid">
		<div id=about class="container-fluid">
			<h4>firstName: <c:out value="${ninja.firstName}"></c:out></h4>
			<h4>lastName: <c:out value="${ninja.lastName}"></c:out></h4>
			<h4>ninja.dojoMdl.dojoName: <c:out value="${ninja.dojoMdl.dojoName}"></c:out></h4> 
			<a href= "/ninja/${ninja.id}/edit">Edit</a> 
			<form action="/ninja/${ninja.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete this ninja">
			</form>
		</div>
	</div>
 
 	<div id=footer class="container-fluid">
	<p class="footerText">Powered by Coding Dojo</p>
	</div>
	
</body>
</html>