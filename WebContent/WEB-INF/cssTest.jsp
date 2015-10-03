<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cssTestSource.css"/>	
</head>
<body>
	<div class="logo">
	HI from CSS!
	</div>
	<ul class="nav">
		<li class="nav"><a href="#">item</a></li>
		<li class="nav"><a href="#">item</a></li>
		<li class="nav"><a href="#">item</a></li>
		
	</ul>
	<div class="form">
		<form method="post" action="">
			<ul>
				<li>
					<label for="name">Enter your name:</label>
					<input type="text" id="name" name="name"/>	
				</li>
				<li>
					<label for="comments">Your Comments:</label>
					<textarea id="comments" name="comments"></textarea>
				</li>
				<li>
				<label for="css">Do you like CSS</label>
					<input type="checkbox" name="css"/>
				</li>
				<li>
					<label for="radioB">Choose language</label>
					<input type="radio" id="radioB"/>CSS
					<input type="radio" id="radioB"/>Java
					<input type="radio" id="radioB"/>C#
					
				</li>
			</ul>
			
		</form>
	</div>
	<div class="grid3">
		<p>Left paragraph</p>
	</div>
	<div class="grid3">
		<p>Right paragraph</p>
	</div>
</body>
</html>