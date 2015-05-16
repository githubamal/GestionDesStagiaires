<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stage:Login</title>
</head>
<body>
	<center>
		<h3>Bienvenue</h3>
		<form action="login" method="Post">
			<table border=0 width=50%>
				<tr>
					<td>Login</td>
					<td><input type="text" name="login" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td />
					<td colspan=3><input type="submit" value="Valider" /> <input
						type="reset" value="Annuler" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>