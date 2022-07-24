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
		<a href= "/ninja">Ninja List</a>
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
							<td>${record.dojoMdl.dojoName}</td>
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
			<h2>Edit Ninja Record</h2>
	
			<form:form action='/ninja/${ninja.id}/edit' method='post' modelAttribute='ninja'>
	
				<form:hidden value="${ninja.id}" path="id" />
				<p>Currently saved ninja.dojoMdl.id: ${ninja.dojoMdl.id}</p>
				<p>Currently saved ninja.dojoMdl.dojoName:
					${ninja.dojoMdl.dojoName}</p>
				
				<div class="form-group">
					<form:label path="firstName" for="firstName">firstName</form:label>
					<form:input type="text" class="form-control" path="firstName"
						aria-describedby="firstNameHelp" placeholder="Enter firstName" />
					<p class="errorText">
						<form:errors path="firstName" />
					</p>
				</div>
	
				<%-- 	<c:if test="$	${record.id} = ${record.id} ">
			   <p>pizza!<p>
			</c:if> --%>
	
				<div class="form-group">
					<form:label path="lastName" for="lastName">lastName</form:label>
					<form:input type="text" class="form-control" path="lastName"
						placeholder="lastName here" />
					<p class="errorText">
						<form:errors path="lastName" />
					</p>
				</div>
	
				<div class="form-group">
					<p>
						<form:label path="dojoMdl" for="dojoMdl">Dojo:</form:label>
					</p>
					<form:select path="dojoMdl" name="dojoMdl">
	 					<c:forEach var="record" items="${dojoList}">
							<c:choose>
								<c:when test="${ninja.dojoMdl.id == record.id}">
									<option value="${record.id}" selected>
										<c:out value="${record.dojoName}"/>
									</Option>
								</c:when>
								<c:otherwise>
									<option value="${record.id}">
										<c:out value="${record.dojoName}" />
									</Option>
								</c:otherwise>
							</c:choose>
						</c:forEach> 
					</form:select>
				</div>
	
				<button type="submit" class="btn btn-primary">Update</button>
			</form:form>
	
			<a href="/ninja"><button class="btn btn-secondary">Cancel</button></a>
		</div>
	</div>
	<div id=footer class="container-fluid">
		<p class="footerText">Powered by Coding Dojo</p>
	</div>
	
	
</body>
</html>