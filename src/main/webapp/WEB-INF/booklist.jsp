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
	<h1>java54formitup BookList</h1>
	<a href= "/date">Date Template</a>
	<a href= "/time">Time Template</a>
	<a href= "/dojos">Dojos</a>
	<a href= "/">Home</a>
	<!-- <a href= "/counter">Site Visit Counter</a> -->
	
	<h2>Bookety-Books</h2>
	<%-- 
	<h3>bookListy: <c:out value="${bookListy}"></c:out></h3>
	
	<c:forEach var="fruit" items="${bookListy}">
        <p> ${fruit.title} - $${fruit.description}</p>
    </c:forEach>  
	 --%>
	<table class="table table-striped">
	  <thead>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Title</th>
	      <!-- <th scope="col">Description</th> -->
	      <th scope="col">Language</th>
	      <th scope="col">Page Count</th>
	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach var="book" items="${bookListy}">
	        <tr>
		      <th scope="row">${book.id}</th>
		      <td >
		      	<a href= "/books/${book.id}">${book.title}</a>
		      </td>
		     <%--  <td>${book.description}</td> --%>
		      <td>${book.language}</td>
		      <td>${book.numberOfPages}</td>
		    </tr>
    	</c:forEach>  
	  </tbody>
	</table>
    <a href= "/books/new">Add New Book</a> 
	
	
	
</body>
</html>