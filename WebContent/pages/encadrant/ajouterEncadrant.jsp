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
	<h3>Ajouter un nouveau encadrant</h3>
	<form action="/login" method="Post">
	<table border=0 width=50%>
		<tr>
			<td>Nom Encadrant</td>
			<td><input type="text" name="nom"/></td>
		</tr>
		<tr>
			<td>Pr�nom Encadrant</td>
			<td><input type="text" name="prenom"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td>N� t�l�phone</td>
			<td><input type="text" name="tele"/></td>
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