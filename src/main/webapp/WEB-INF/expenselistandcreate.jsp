<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
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
	<h1>java54formitup ExpenseList AND CREATE</h1>

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

		      <td >
		      	<a href= "/expenses/${record.id}">${record.expenseName}</a>
		      </td>
		      
		      <td>${record.vendorName}</td>

		      <td>
			      $<fmt:formatNumber type="number" pattern="0.00" value="${record.expenseAmount}"/> 
		      </td>
		      
		      <td>
		      	<a href= "/expenses/${record.id}/edit">Edit</a>
		      	
		      	<form action="/expenses/${record.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete this thang">
				</form>
		      	
		      </td>
		      
		    </tr>
    	</c:forEach>  
	  
	  
	  
	  
	  </tbody>
	</table>
    
	<h2> Submit a new expense right here!</h2>
	
	<div class="card" class="cardPaddingJonLikes" style="width: 50rem;">
	
		<form:form action='/expensesAndCreate' method='post' modelAttribute='expense'>
		  
		  <div class="form-group">
		    <form:label path="expenseName" for="expenseName" >expenseName</form:label>
		     <form:input type="text" class="form-control"  path="expenseName" aria-describedby="expenseNameHelp" />
		     <p class="errorText"><form:errors path="expenseName"/></p>
		  </div>
		  
		  <div class="form-group">
		    <form:label path="vendorName" for="vendorName">vendorName</form:label>
		    <form:input type="text" class="form-control" path="vendorName" />
		    <p class="errorText"><form:errors path="vendorName"/></p>
		  </div>
		  
		  <div class="form-group">
		    <form:label path="expenseAmount" for="expenseAmount">expenseAmount</form:label>
		    <form:input type="number" class="form-control"  path="expenseAmount" 
		    min="0.00" step="0.01" value="0.00"
		     />
		    <p class="errorText"><form:errors path="expenseAmount"/></p>
		  </div>
		  
		  <div class="form-group">
		    <form:label path="expenseDescription" for="expenseDescription">expenseDescription</form:label>
		    <form:input type="text" class="form-control" path="expenseDescription"  />
		    <p class="errorText"><form:errors path="expenseDescription"/></p>
		  </div>
		  <%-- 
		  <div class="form-check">
		    <form:input type="checkbox" class="form-check-form:input" id="exampleCheck1"/>
		    <form:label class="form-check-form:label" for="exampleCheck1">Check me out</form:label>
		  </div> 
		   --%>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	  </div>

    <a href= "/expenses/new">Sep page: Add New Expense</a> 
	
	
	
</body>
</html>