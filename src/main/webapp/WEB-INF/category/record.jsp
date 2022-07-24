<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/WEB-INF/include/head.jsp" />

<body>
	<jsp:include page="/WEB-INF/include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Store Management</h2>
	</div>
	
	<div id=main class="card">
		<h3><c:out value="${category.categoryName}"></c:out></h3>
		<div id=about class="card">
			<%-- <h4>id: <c:out value="${publication.id}"></c:out></h4> --%>
			
			
<%-- 			<h4>productDesc:</h4>
			<pre class="textAreaReadOut"><c:out value="${product.productDesc}"></c:out></pre>

			<h4>price: $<c:out value="${product.price}"></c:out></h4> --%>
<%-- 			
			<p>Here are
			<c:choose>
				<c:when test="${user.id == publication.userMdl.id}">your</c:when>
				<c:otherwise>
				${publication.userMdl.userName}'s
				</c:otherwise>
			</c:choose> 
			thoughtsOnPub: </p>
--%>


			<%-- 
			<h4>publication.dojoMdl.dojoName: <c:out value="${publication.dojoMdl.dojoName}"></c:out></h4> 
			--%> 
			<%-- <a href= "/publication/${publication.id}/edit">OrigEdit</a>  --%>
			
<%-- 
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
						 --%>
		</div>
		
		<div id=list class="card">
			<h3>Product List for this Category</h3>
<%-- 			
			<c:choose>
				<c:when test="${mgmtPermissionErrorMsg != null}">
					<p class="errorText">${mgmtPermissionErrorMsg}</p>
				</c:when>
				<c:otherwise></c:otherwise>
			</c:choose> 
--%>
			<table class="table table-striped table-dark">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">productName</th>
						<th scope="col">actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="record" items="${assignedProducts}">
						<tr>
							<td>${record.id}</td>
							<%-- <td><a href="/store/product/${record.id}">${record.productName}</a></td> --%>
							<td><a href="/product/${record.id}">${record.productName}</a></td>
							<td>
								<!-- <form action="/store/removeProductCategoryJoin" method="post"> -->
								<form action="/removeProductCategoryJoin" method="post">
								    
								    <input type="hidden" name="_method" value="delete">
								    <input type="hidden" name="categoryId" value="${category.id}"  />
								    <input type="hidden" name="productId" value="${record.id}"  />
								    <input type="hidden" name="origin" value="2"/>
								    
								    <button class="btn btn-danger">Delete</button>
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div id=form class="card">
			<h2>Add a Product:</h2>
			<%-- <form action='/store/category/${category.id}' method='post' > --%>
			<form action='/category/${category.id}' method='post' >
			
				<!-- JRF note to self: I don't think next line is necessry, and cam says yep! -->
				<%-- <input type="hidden" value="${product.id}" path="id" /> --%>

				<div class="form-group">
					<select name="productId"> 
					<!-- above name needs to match the value in the paramvalue in the ctl file -->
					<!-- path="categoryMdl" -->
					<!-- JRF: above left out... this is a JSTL form thing -->
					
						<c:forEach var="record" items="${unassignedProducts}">
							<!--- Each option VALUE is the id of the dojo --->
							<option value="${record.id}" >
							<!-- path="categoryMdl"> -->
								<!--- This is what shows to the user as the option --->
								<c:out value="${record.productName}" />
							</option>
						</c:forEach>
					</select>
				</div>
 				
 				<button type="submit" class="btn btn-primary">Add</button>
			</form>
		</div>
	
	</div>
 	<jsp:include page="/WEB-INF/include/footer.jsp"/>
</body>
</html>