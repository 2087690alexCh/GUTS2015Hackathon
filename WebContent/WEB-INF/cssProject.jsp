<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cssProject.css"/>
	<script src="${pageContext.request.contextPath}/resources/js/angular.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/angular-route.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/cssProjectAngular.js"></script>
</head>
<body ng-app="cssApp">
	<div class="container grid 12">
		<header>
			<h1>Black + White</h1>
			<nav>
				<ul>
					<li><a href="#" class="selected">Home</a></li>
					<li><a href="#">Our Services</a></li>
					<li><a href="#">How we work</a></li>
					<li><a href="#">Testimonials</a></li>
					<li><a href="#/workExamples">Work Examples</a></li>
				</ul>
			</nav>

		<!--  Angular Content -->
		<div ng-view=""></div>
		<footer>
		<p><strong>Black+WHIte</strong>themes via<a href="#">Themeforest</a></p>
		</footer>
		
	</div>
</body>
</html>