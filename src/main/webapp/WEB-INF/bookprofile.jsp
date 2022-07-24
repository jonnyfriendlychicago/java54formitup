<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
<!DOCTYPE html>
<html lang="en">
<head>
<title>java54formitup - ${book.title}</title>
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
	<h2>java54formitup - Book Profile</h2>
	<a href= "/">Home</a>
	<a href= "/books">Books</a>
	
	<h3>Book title: <c:out value="${book.title}"></c:out></h3>
	<h4>Description: <c:out value="${book.description}"></c:out></h4>
	<h4>Language: <c:out value="${book.language}"></c:out></h4>
	<h4>Page Count: <c:out value="${book.numberOfPages}"></c:out></h4> 

	
</body>
</html>