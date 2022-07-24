<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    
<!DOCTYPE html>
<html lang="en">
<head>
<title>Display Time</title>
<meta charset="UTF-8">
<!-- local css -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- local javascript -->
<script type ="text/javascript" src="javascript/time.js"></script>
<!--  Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" /> 
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	
	<h1>Date Assignment - Time Page</h1>
	<a href= "/">Home</a>
	<a href= "/date">Date Template</a>
	
	<h2 class = "greenStuff"><c:out value="${displayTime}"></c:out></h2>
	
	<%-- <h1>Content from Hopper Assignment, keeping around for future ref</h1>
	<h2>Customer Name: <c:out value="${customerName}"></c:out></h2>
	
	<h2>Item Name: <c:out value="${itemName }"></c:out></h2>
	
	<h2>Item Price: $<c:out value="${itemPrice }"></c:out></h2>
	<h2>Item Description: <c:out value="${itemDescription }"></c:out></h2>
	<h2>Vendor Name: <c:out value="${vendorName }"></c:out></h2> --%>
	
	
	<%-- <% for (int i = 0; i < 5; i++) { %>
		<h2> <%=i %> </h2>
	<% } %> --%>
	
	<%-- <h3> This time is: <%= new Date() %></h3>
	
	<h1>Two plus two is: </h1>
	<h2><c:out value="${2+2}"/></h2> --%>
	
	
	
</body>
</html>