<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NEW REGISTER</title>
</head>
<body>

	<h1>New Register</h1>
	<form action="SaveServlet2" method="Get">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save Register" /></td>
			</tr>
		</table>
	</form>

	<br />
</body>
</html>