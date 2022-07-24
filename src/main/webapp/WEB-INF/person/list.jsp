<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

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
	<h1>java54formitup Person List</h1>

	<a href= "/">Home</a>
	
	<h2>Person List</h2>

	<table class="table table-striped">
	  <thead>
	    <tr>
			<th scope="col">id</th>
	      	<th scope="col">firstName</th>
	      	<th scope="col">lastName</th>
			<th scope="col">Actions</th> 
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="record" items="${personList}">
	        <tr>
		      <td >
		      	<a href= "/person/${record.id}">${record.id}</a>
		      </td>
		      <td>${record.firstName}</td>
		      <td>${record.lastName}</td>
				<td>
		      		<a href= "/person/${record.id}/edit">Edit</a>
		      	
			      	<form action="/person/${record.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <input type="submit" value="Delete">
					</form>
		      </td>
		    </tr>
    	</c:forEach>  
	  </tbody>
	</table>
    
    <a href= "/person/new">Add New Person</a> 
	
	
	
</body>
</html>