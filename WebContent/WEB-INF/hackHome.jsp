<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="officeAdvisor" style="height:100%">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title><!-- Latest compiled and minified CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="http://www.bootstrapzero.com/theme.css">
<!-- Latest compiled and minified JavaScript -->
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/angular.js"></script>
	<script src="${pageContext.request.contextPath}/resources/mytheme/js/officeAdvisor.js"></script>
	<script type="text/javascript"
       src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsT8kZchsbN1VhpZ2BCaxI1-K4NKZPTjE&sensor=false&libraries=visualization"
    ></script>
    <style type="text/css">
      html, body { height: 100%; margin: 0; padding: 0; }
      #map { height: 100%; }
      .navbar {
    margin-bottom: 0px;
}
    </style>
</head>

<body ng-controller="mainController" style="height:100%">
<nav class="navbar navbar-default" style="position:fixed;left:0; right:0;  z-index:999999;">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Sergeant /Dispatcher UI/</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
        <li class="active"><a href="#">Application <span class="sr-only">(current)</span></a></li>

      </ul>
      <form class="navbar-form navbar-right" role="search">
       Add critical points by clicking on the map and
        <button type="submit" class="btn btn-default" ng-click="submitNearest()">Submit Flags to Nearest Officers</button>
      </form>
      
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
		    <div id="map"></div>
</body>
</html>