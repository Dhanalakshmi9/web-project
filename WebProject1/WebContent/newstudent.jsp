<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW STUDENT</title>
</head>
<body>

	<h1>New Student</h1>
	<form action="SaveServlet3" method="Get">
		<table>
			<tr>
				<td>ID:</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>E-MAIL:</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>DATE:</td>
				<td><input type="text" name="date" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save Student" /></td>
			</tr>
		</table>
	</form>

	<br />
</body>
</html>