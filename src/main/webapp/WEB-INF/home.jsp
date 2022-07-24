<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="include/head.jsp" />

<body>
	<jsp:include page="include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Home</h2>
	</div>

	<div id=main class="container-fluid mainContainer">
		<!-- <div id=welcome class="container-fluid"> -->
		<div id="welcome" > 		
			<h2>Welcome, <c:out value="${user.userName}"></c:out>!</h2>
			<h3>Thanks for being part of our growing community.  Let's talk more soon.</h3> 
		</div>

		
		<!-- <div id="homeListAcross" class="container-fluid">  -->
		<div id="listContainer" class="container listContainerStyle" style="width: 80rem"> 
			<!-- <div id=twinoneList class="container-fluid"> -->
			<div id="twinoneList">
			
				<h3>Twinone List</h3>
				<a href= "/twinone/new"><button class="btn btn-primary">Add Twinone</button></a>
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">Name</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${twinoneList}">
							<tr>
								<td>${record.id}</td>
								<td><a href="/twinone/${record.id}">${record.twinoneName}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			
			<!-- <div id=twintwoList class="container-fluid"> -->
			<div id="twintwoList">
			
				<h3>Twintwo List</h3>
				<a href= "/twintwo/new"><button class="btn btn-primary">Add Twintwo</button></a>
	<%-- 			
				<c:choose>
					<c:when test="${mgmtPermissionErrorMsg != null}">
						<p class="errorText">${mgmtPermissionErrorMsg}</p>
					</c:when>
					<c:otherwise></c:otherwise>
				</c:choose> 
	--%>
				<table class="table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">twintwoName</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="record" items="${twintwoList}">
							<tr>
								<td>${record.id}</td>
								<td><a href="/twintwo/${record.id}">${record.twintwoName}</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<jsp:include page="include/footerbuffer.jsp"/>
	<jsp:include page="include/footer.jsp"/>
			
			
</body>
</html>