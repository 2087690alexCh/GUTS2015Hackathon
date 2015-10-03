<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form</title>
</head>
<body>
	<h1>Fill in Form</h1>
	<form action="/AngularAndSpring/form" method="post">
		<table>
			<tr>
				<td>Please enter Name:</td> <td><input type="text" name="studentName"/></td>
			</tr>
			<tr>
				<td>Your Hobby:</td><td><input type="text" name="studentHobby"/></td>
			</tr>
		</table>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>