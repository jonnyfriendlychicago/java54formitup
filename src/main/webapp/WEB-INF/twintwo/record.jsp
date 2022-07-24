<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Twintwo Management</h2>
	</div>
	
	<div id=main class="card">
		<div id="recordHeader"> 
			<h3><c:out value="${twintwo.twintwoName}"></c:out></h3>
<%-- 
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id }">
--%>		
			<a href= "/twintwo/${twintwo.id}/edit"><button class="btn btn-primary">Edit</button></a>
<%-- 
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
--%>
			
<%-- 
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id }">
--%>
					<form action="/twintwo/${twintwo.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <button class="btn btn-danger">Delete this Twintwo</button>
					</form>
<%-- 
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
--%>
		</div>

		
		
		
		<div id=list class="card">
			<h3>Twinone List</h3>

			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">twinoneName</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${assignedTwinones}">
						<tr>
							<td>${record.id}</td>
							<td><a href="/twinone/${record.id}">${record.twinoneName}</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

<%-- 
		<div id=form class="card">
			<h2>Add a Twinone:</h2>

			<form action='/twintwo/${twintwo.id}' method='post' >
				<div class="form-group">
					<select name="twinoneId"> 
					
						<c:forEach var="record" items="${unassignedCategories}">
							<option value="${record.id}" >
								<c:out value="${record.twinoneName}" />
							</option>
						</c:forEach>
					</select>
				</div>
 				
 				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
--%>
	</div>
 	
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>