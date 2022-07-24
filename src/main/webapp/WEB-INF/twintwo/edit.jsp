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
<%-- 
		<div id="recordHeader"> 
		<a href= "/twintwo/${twintwo.id}/editrecord"><button class="btn btn-primary">Edit</button></a>
		</div>
--%>
		<div id=about class="card">
			
			<form:form action='/twintwo/${twintwo.id}/edit' method='post' modelAttribute='twintwo'>
	
				<form:input type="hidden" value="${twintwo.id}" path="id" />
				
				<%-- <form:input type="hidden" value="${twintwo.userMdl.id}" path="userMdl" /> --%>
				
				<%-- <form:input type="hidden" value="${assignedCategories}" path="twinoneMdl" /> --%>
		
				<div class="form-group">
					<form:label path="twintwoName" for="twintwoName">twintwoName</form:label>
					<form:input type="text" class="form-control" path="twintwoName"/>
					<p class="errorText"><form:errors path="twintwoName" />
					</p>
				</div>
				
				<div>
					<button type="submit" class="btn btn-primary">Update</button>
				</div>
			</form:form>
	
			<a href="/twintwo/${twintwo.id}"><button class="btn btn-secondary">Cancel</button></a>
			
		</div>
		
		<div id=list class="card">
			<h3>Twinone List</h3>

			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">twinoneName</th>
						<th scope="col">actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${assignedTwinones}">
						<tr>
							<td>${record.id}</td>
							<td><a href="/twinone/${record.id}">${record.twinoneName}</a></td>
 								
							<td>
								<form action="/removeTwintwoTwinoneJoin" method="post">
								    
								    <input type="hidden" name="_method" value="delete">
								    <input type="hidden" name="twinoneId" value="${record.id}"/>
								    <input type="hidden" name="twintwoId" value="${twintwo.id}"/>
								    <!-- <input type="hidden" name="origin" value="1"/> -->
								    
								    <button class="btn btn-danger">Delete</button>
								</form>
							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


		<div id=form class="card">
			<h2>Add a Twinone:</h2>
			<form action='/twintwo/${twintwo.id}/editTwinoneJoins' method='post' >
				<div class="form-group">
					<select name="twinoneId"> 
						<c:forEach var="record" items="${unassignedTwinones}">
							<option value="${record.id}" >
								<c:out value="${record.twinoneName}" />
							</option>
						</c:forEach>
					</select>
				</div>
 				
 				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
	</div>
 	
 	<jsp:include page="/WEB-INF/include/footerbuffer.jsp"/>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>