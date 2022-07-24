<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<div id=header class="container-fluid">
			<h1 id="siteTitle">java54formitup</h1>
			<div class=header-top-vert>
				<p class="header-profile-text">${user.userName}</p>
				<p class="header-profile-text">Email: ${user.email}</p>
				<a href="/logout">Logout</a>
			</div>
	</div>
	
	<div id=navBar class="container-fluid">
		
					<a href= "/home">Home</a>
					<a href= "/date">Date</a>
					<a href= "/time">Time Template</a>
					<a href= "/books">Books</a>
					<a href= "/expenses">Expenses</a>
					<a href= "/expensesAndCreate">expensesAndCreate</a>
					<a href="/dojo">Dojo List</a>
					<a href= "/ninja">Ninja List</a>
					<a href= "/publication">Book Club</a>
					<a href= "/store">Store-StandAlone</a>
			
	</div>