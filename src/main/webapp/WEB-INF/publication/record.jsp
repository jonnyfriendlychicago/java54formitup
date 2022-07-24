<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Publication Management</h2>
	</div>
	
	<div id=main class="container-fluid">
		<div id=about class="container-fluid">
			<%-- <h4>id: <c:out value="${publication.id}"></c:out></h4> --%>
			<h4>pubTitle: <c:out value="${publication.pubTitle}"></c:out></h4>
			<h4>pubAuthor: <c:out value="${publication.pubAuthor}"></c:out></h4>
			
			<p>Here are
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id}">your</c:when>
				<c:otherwise>
				${publication.userMdl.userName}'s
				</c:otherwise>
			</c:choose> 
			thoughtsOnPub: </p>
			
			<pre class="textAreaReadOut"><c:out value="${publication.thoughtsOnPub}"></c:out></pre>

			<%-- 
			<h4>publication.dojoMdl.dojoName: <c:out value="${publication.dojoMdl.dojoName}"></c:out></h4> 
			--%> 
			<%-- <a href= "/publication/${publication.id}/edit">OrigEdit</a>  --%>
			
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id }">
					<a href= "/publication/${publication.id}/edit"><button class="btn btn-secondary">Edit</button></a>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose> 
			
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id }">
					<form action="/publication/${publication.id}" method="post">
					    <input type="hidden" name="_method" value="delete">
					    <button class="btn btn-danger">Delete this publication</button>
					</form>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose>
						
		</div>
	</div>
 
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>