<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	
	<div id=pageHeader class="container-fluid">
		<h2>Store Management</h2>
	</div>

	<div id=main class="container-fluid">
		<div id=form class="container-fluid">
			<h3>Add a Product</h3>
			<%-- <form:form action='/store/product/new' method='post' modelAttribute='product'> --%>
			<form:form action='/product/new' method='post' modelAttribute='product'>
			
				
				<!-- use below, in concert with Mdl file, to capture createdBy_id value -->
				<%-- <form:hidden value="${user.id}" path="userMdl" /> --%>
				
				<div class="form-group">
					<form:label path="productName" for="productName">productName</form:label>
					<form:input type="text" class="form-control" path="productName"/>
					<p class="errorText"><form:errors path="productName" />
					</p>
				</div>

				<div class="form-group">
					<form:label path="productDesc" for="productDesc">productDesc</form:label>
					<form:textarea type="text" class="form-control" path="productDesc" />
					<p class="errorText"><form:errors path="productDesc" /></p>
				</div> 				

				<p>!!! NEED TO ADD FIELD FOR PRICE !!!</p>
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
 				
		
 				
 				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
<%-- 			
			<c:choose>
				<c:when test="${onErrorPath == 'yep' }">
					<a href= "/publication"><button class="btn btn-secondary">Cancel</button></a>
				</c:when>
				<c:otherwise>
				</c:otherwise>
			</c:choose> 			
 --%>		
 </div>

	
	</div>

	<jsp:include page="/WEB-INF/include/footer.jsp"/>
	
</body>
</html>