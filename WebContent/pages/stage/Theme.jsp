<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h3>Ajouter un nouveau theme</h3>
	<form action="/stage" method="Post">
	<table border=0 width=50%>
		<tr>
			<td>Numéro Session</td>
			<td><input type="text" name="Id"/></td>
		</tr>
		<tr>
			<td>theme</td>
			<td><input type="text" name="theme"/></td>
		</tr>	
		<tr>
		<td/>
		<td  colspan=3><input type="submit" value="Valider"/>               
		 <input type="submit" value="Annuler"/></td>
		</tr>
	</table>
	</form>
</center>
</body>
</html>