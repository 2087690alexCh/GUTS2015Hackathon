<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="officeAdvisor">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/officeAdvisor.js"></script>
	<script type="text/javascript"
       src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsT8kZchsbN1VhpZ2BCaxI1-K4NKZPTjE&sensor=false&libraries=visualization"
    ></script>
    <style type="text/css">
      html, body { height: 100%; margin: 0; padding: 0; }
      #map { height: 100%; }
    </style>
</head>

<body ng-controller="mainController">
		    <div id="map" style="height :80%"></div>
</body>
</html>