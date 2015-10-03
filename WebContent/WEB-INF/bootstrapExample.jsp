<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<header></header>
	
	<!-- Changing of order of columns as page gets smaller -->
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-push-6">
				<div class="well">First</div>
			</div>
			<div class="col-sm-6 col-sm-pull-6"></div>
			<div class="well">Second</div>
		</div>
	</div>
	<footer></footer>
	
	<!-- From 4 to 2 rows as gets smaller -->
	<div class="container">
		<div class="row">
			<div class="col-xs-6 col-md-3">1</div>
			<div class="col-xs-6 col-md-3">2</div>
			<div class="clearfix hidden-md hidden-lg"></div>
			<div class="col-xs-6 col-md-3">3</div>
			<div class="col-xs-6 col-md-3">4</div>
		</div>
	</div>
	
	<!-- Button with glyphicon -->
	<a href="" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></a>
	<!-- Forms -->
	<form action="" class="form-inline">
		<div class="form-group">
			<label for="element-1" class="sr-only">This is the text of the label</label>
			<input type="text" id="element-1" class="form-control" placeholder="Enter email">
			
			<div class="form-group">
				<label for="element-2" class="sr-only">This is second label</label>
				<input type="text" class="form-control" id="element2" placeholder="Enter Passworrd"/>
			</div>
			<div class="checkbox">
				<laber for=""><input type="checkbox">Remember me</laber>
			</div>
			<button type="button" class="btn btn-primary">Sign in</button>
		</div>
	</form>
</body>
</html>