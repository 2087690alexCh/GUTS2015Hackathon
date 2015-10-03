<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html data-ng-app="demoApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/AngularController.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular-route.js"></script>
	<link href="${pageContext.request.contextPath}/resources/mytheme/css/demo.css" rel="stylesheet"/>
</head>
<!-- Working Angular Example<body data-ng-controller="SimpleController">
	
	Name:
	<br/>
	<input type="text" ng-model="SearchedName"/>{{SearchedName}}
	
	
	<ul>
		<li ng-repeat="cust in customers | filter: SearchedName | orderBy: 'name'">{{cust.name | uppercase}} - {{cust.city | lowercase}}</li>
	</ul>
	
	
	<h1>${welcomeMessage}</h1>
	
</body>-->
<body>
	<div>
		{{test}}
		<!--  Placeholder for views -->
		<div data-ng-view=""></div>
	</div>
</body>
</html>