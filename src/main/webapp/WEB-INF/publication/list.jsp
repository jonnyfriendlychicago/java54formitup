<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Publication Management</h2>
	</div>

	<div id=main class="container-fluid">
		<div id=list class="container-fluid">
			<c:choose>
				<c:when test="${mgmtPermissionErrorMsg != null}">
					<p class="errorText">${mgmtPermissionErrorMsg}</p>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose>
			
			<table class="table table-striped table-dark table-hover">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">pubTitle</th>
						<th scope="col">pubAuthor</th>
						<!-- <th scope="col">Dojo</th> -->
						<th scope="col">Created By</th>
						<th scope="col">actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${publicationList}">
						<tr>
							<td>${record.id}</td>
							<td><a href="/publication/${record.id}">${record.pubTitle}</a></td>
							<td>${record.pubAuthor}</td>
							<td>${record.userMdl.userName} </td>
							<td>
								<div class="buttonArrange1"> 
									<c:choose>
										<c:when test="${user.id == record.userMdl.id }">
											<a href= "/publication/${record.id}/edit"><button class="btn btn-secondary">Edit (below)</button></a>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose> 

									<c:choose>
										<c:when test="${user.id == record.userMdl.id }">
											<a href= "/publication/${record.id}/editfocus"><button class="btn btn-secondary">Edit (focused view)</button></a>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose> 
									
									<c:choose>
										<c:when test="${user.id == record.userMdl.id }">
											<form action="/publication/${record.id}" method="post">
											    <input type="hidden" name="_method" value="delete">
											    <button class="btn btn-danger">Delete</button>
											</form>
										</c:when>
										<c:otherwise>
										</c:otherwise>
									</c:choose>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>

		<div id=form class="container-fluid">
			<h2>Add new publication</h2>
			<!-- adding next line to see if userId grabbed successfully -->
			<%-- <p>user.id from session: ${user.id}  --%>
			<form:form action='/publication' method='post' modelAttribute='publication'>
		
				<form:hidden value="${user.id}" path="userMdl" />
				
				<div class="form-group">
					<form:label path="pubTitle" for="pubTitle">pubTitle</form:label>
					<form:input type="text" class="form-control" path="pubTitle"/>
					<p class="errorText"><form:errors path="pubTitle" />
					</p>
				</div>
		
				<div class="form-group">
					<form:label path="pubAuthor" for="pubAuthor">pubAuthor</form:label>
					<form:input type="text" class="form-control" path="pubAuthor" />
					<p class="errorText"><form:errors path="pubAuthor" /></p>
				</div>
<%-- 		
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
 --%>				
 				
		
				<div class="form-group">
					<form:label path="thoughtsOnPub" for="thoughtsOnPub">thoughtsOnPub</form:label>
					<form:textarea type="text" class="form-control" path="thoughtsOnPub" />
					<p class="errorText"><form:errors path="thoughtsOnPub" /></p>
				</div> 				
 				
 				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
			
			<c:choose>
				<c:when test="${onErrorPath == 'yep' }">
					<a href= "/publication"><button class="btn btn-secondary">Cancel</button></a>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose> 
		</div>
	</div>			

	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>