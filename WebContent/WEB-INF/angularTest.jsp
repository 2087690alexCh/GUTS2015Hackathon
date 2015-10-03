<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angularTest.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular-route.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/countryControllers.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular.soap.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/soapclient.js"></script>

</head>
<body data-ng-app="demoApp">
	<div data-ng-view=""></div>
	<!-- <div data-ng-controller="SimpleController"></div> -->
</body>
</html>