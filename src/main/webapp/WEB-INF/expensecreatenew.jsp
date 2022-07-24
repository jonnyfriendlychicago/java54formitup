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
	<h1>java54formitup - Create New Expense</h1>
	<a href= "/expenses">Expenses</a>
	
	<form:form action='/processNewExpense' method='post' modelAttribute='expense'>
	  
	  <div class="form-group">
	    <form:label path="expenseName" for="expenseName" >expenseName</form:label>
	     <form:input type="text" class="form-control"  path="expenseName" aria-describedby="expenseNameHelp" placeholder="Enter expenseName"/>
	     <p><form:errors path="expenseName"/></p>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="vendorName" for="vendorName">vendorName</form:label>
	    <form:input type="text" class="form-control" path="vendorName" placeholder="vendorName here"/>
	    <p><form:errors path="vendorName"/></p>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="expenseAmount" for="expenseAmount">expenseAmount</form:label>
	    <form:input type="number" class="form-control"  path="expenseAmount" 
	    min="0.00" step="0.01" value="0.00"
	     />
	    <p><form:errors path="expenseAmount"/></p>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="expenseDescription" for="expenseDescription">expenseDescription</form:label>
	    <form:input type="text" class="form-control" path="expenseDescription"  />
	    <p><form:errors path="expenseDescription"/></p>
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