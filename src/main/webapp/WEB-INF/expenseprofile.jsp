<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
<!DOCTYPE html>
<html lang="en">
<head>
<title>java54formitup - ${expense.expenseName}</title>
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
	<h2>java54formitup - expense Profile</h2>
	<a href= "/">Home</a>
	<a href= "/expenses">Expenses</a>
	<a href= "/expenses/${expense.id}/edit">Edit</a>
	
	<h3>expenseName: <c:out value="${expense.expenseName}"></c:out></h3>
	<h4>vendorName: <c:out value="${expense.vendorName}"></c:out></h4>
	<h4>expenseAmount: $<c:out value="${expense.expenseAmount}"></c:out></h4>
	<h4>expenseDescription: <c:out value="${expense.expenseDescription}"></c:out></h4> 

	<form action="/expenses/${expense.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete this thang">
	</form>

	
</body>
</html>