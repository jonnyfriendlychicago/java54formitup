<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
<!DOCTYPE html>
<html lang="en">
<head>
<title>java54formitup - ${dojo.dojoName}</title>
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
		<h2>Dojo Profile</h2>
	</div>
	
	<div id=main class="container-fluid">
		<div id=about class="container-fluid">
			<h4>dojoName: <c:out value="${dojo.dojoName}"></c:out></h4>
		
			<a href= "/dojo/${dojo.id}/edit">Edit</a> 
			<form action="/dojo/${dojo.id}" method="post">
			    <input type="hidden" name="_method" value="delete">
			    <input type="submit" value="Delete this dojo">
			</form>
		</div>
		
		<div id=list class="container-fluid">
			<table class="table table-striped">
			  <thead>
			    <tr>
					<th scope="col">id</th>
			      	<th scope="col">firstName</th>
			      	<th scope="col">lastName</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="record" items="${dojo.ninjaList}">
			        <tr>
				      <td >
				      	<a href= "/ninja/${record.id}">${record.id}</a>
				      </td>
				      <td>${record.firstName}</td>
				      <td>${record.firstName}</td>
				    </tr>
		    	</c:forEach>  
			  </tbody>
			</table>
		</div>
	 </div>
	 
	 <div id=footer class="container-fluid">
	<p class="footerText">Powered by Coding Dojo</p>
	</div>
		
</body>
</html>