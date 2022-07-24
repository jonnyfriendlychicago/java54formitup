<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="include/head.jsp" />

<body>
	<jsp:include page="include/header.jsp" />
	
	<div id=pageHeader class="container-fluid">
		<h2>Java App Login</h2>
	</div>
	
	<div id=main class="container-fluid">
		<div id=registerLogin class="container-fluid">
		<h2>Welcome!</h2>
		<h3>Join our growing community.</h3>
		<div id=registerLogin2 class="container-fluid">
			<div id="register" class="card" style="width: 30rem;">
				<h4>Register</h4>
				<form:form action='/register' method='post' modelAttribute='newUser'>
			
					<div class="form-group">
						<form:label path="userName" for="userName">userName</form:label>
						<form:input type="text" class="form-control" path="userName"/>
						<p class="errorText"><form:errors path="userName" />
						</p>
					</div>
					
					<div class="form-group">
						<form:label path="email" for="email">email</form:label>
						<form:input type="email" class="form-control" path="email"/>
						<p class="errorText"><form:errors path="email" />
						</p>
					</div>
					
					<div class="form-group">
						<form:label path="password" for="password">password</form:label>
						<form:input type="password" class="form-control" path="password"/>
						<p class="errorText"><form:errors path="password" />
						</p>
					</div>
					
					<div class="form-group">
						<form:label path="confirm" for="confirm">confirm</form:label>
						<form:input type="password" class="form-control" path="confirm"/>
						<p class="errorText"><form:errors path="confirm" />
						</p>
					</div>
			
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
			<div id="login" class="card" style="width: 30rem;">
				<h4>Login</h4>
				<form:form action='/login' method='post' modelAttribute='newLogin'>
					
					<div class="form-group">
						<form:label path="email" for="email">email</form:label>
						<form:input type="email" class="form-control" path="email"/>
						<p class="errorText"><form:errors path="email" />
						</p>
					</div>
					
					<div class="form-group">
						<form:label path="password" for="password">password</form:label>
						<form:input type="password" class="form-control" path="password"/>
						<p class="errorText"><form:errors path="password" />
						</p>
					</div>
			
					<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
	</div>

			<h2>Page Visit Counter</h2>
			<p>Count of index visits: <c:out value="${countToShow}"></c:out></p>
			
			<p><a href="/reset-counter/">Reset counter to zero</a></p>
		
	</div>
	
	<jsp:include page="include/footer.jsp"/>
			
			
</body>
</html>