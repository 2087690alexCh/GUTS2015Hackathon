<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html data-ng-app="demoApp">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/officeAdvisor.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular-route.js"></script>
	<link href="${pageContext.request.contextPath}/resources/mytheme/css/demo.css" rel="stylesheet"/>
</head>

<body ng-app="officeAdvisor">
	<div ng-controller="mainController">
		{{test}}
	</div>
</body>
</html>