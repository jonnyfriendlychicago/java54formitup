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
	<h1>java54formitup ExpenseList</h1>

	<a href= "/">Home</a>
	
	<h2>Expenses</h2>

	<table class="table table-striped">
	  <thead>
	    <tr>
	      <!-- <th scope="col">ID</th> -->
	      	<th scope="col">expenseName</th>
	      	<th scope="col">vendorName</th>
	      	<th scope="col">expenseAmount</th>
			<th scope="col">Actions</th> 
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="record" items="${expenseListy}">
	        <tr>
		      <%-- <th scope="row">${record.id}</th> --%>
		      <td >
		      	<a href= "/expenses/${record.id}">${record.expenseName}</a>
		      </td>
		      <td>${record.vendorName}</td>
		      <td>$${record.expenseAmount}</td>
		      <td>
		      	<a href= "/expenses/${record.id}/edit">Edit</a>
		      </td>
		    </tr>
    	</c:forEach>  
	  </tbody>
	</table>
    <a href= "/expenses/new">Add New Expense</a> 
	
	
	
</body>
</html>