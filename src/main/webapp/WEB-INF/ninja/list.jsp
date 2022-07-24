<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html lang="en">
<head>
<title>java54formitup</title>
<meta charset="UTF-8">
<!-- local css -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- local javascript -->
<script type="text/javascript" src="javascript/app.js"></script>
<!--  Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div id=header class="container-fluid">
		<h1>java54formitup Ninja List</h1>
		<a href="/">Home</a>
		<a href="/dojo">Dojo List</a>
		<a href="/ninja">Ninja List</a>
		<h2>Ninja Management</h2>
	</div>

	<div id=main class="container-fluid">
		<div id=list class="container-fluid">
	
			<table class="table table-striped">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">firstName</th>
						<th scope="col">lastName</th>
						<th scope="col">Dojo</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${ninjaList}">
						<tr>
							<td><a href="/ninja/${record.id}">${record.id}</a></td>
							<td>${record.firstName}</td>
							<td>${record.lastName}</td>
							<td>${record.dojoMdl.dojoName} </td>
		
		
		
							<td><a href="/ninja/${record.id}/edit">Edit</a>
		
								<form action="/ninja/${record.id}" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete">
								</form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div id=form class="container-fluid">
			<h2>Add new ninja</h2>
		
			<form:form action='/ninja' method='post' modelAttribute='ninja'>
		
				<div class="form-group">
					<form:label path="firstName" for="firstName">firstName</form:label>
					<form:input type="text" class="form-control" path="firstName"/>
					<p class="errorText"><form:errors path="firstName" />
					</p>
				</div>
		
				<div class="form-group">
					<form:label path="lastName" for="lastName">lastName</form:label>
					<form:input type="text" class="form-control" path="lastName" />
					<p class="errorText"><form:errors path="lastName" /></p>
				</div>
		
				<div class="form-group">
					<form:select path="dojoMdl">
						<c:forEach var="record" items="${dojoList}">
							<!--- Each option VALUE is the id of the dojo --->
							<form:option value="${record.id}" path="dojoMdl">
								<!--- This is what shows to the user as the option --->
								<c:out value="${record.dojoName}" />
							</form:option>
						</c:forEach>
					</form:select>
				</div>
		
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
			
			<c:choose>
				<c:when test="${onErrorPath == 'yep' }">
					<a href= "/ninja"><button class="btn btn-secondary">Cancel</button></a>
				</c:when>
				<c:otherwise>
					<!-- <div><p>lookin good</p></div> -->
				</c:otherwise>
			</c:choose> 
		</div>
	</div>			


	<div id=footer class="container-fluid">
		<p class="footerText">Powered by Coding Dojo</p>
		</div>
</body>
</html>