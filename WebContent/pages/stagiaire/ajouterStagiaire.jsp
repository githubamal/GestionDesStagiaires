<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>|| Gestion des stagiaires ||</title>
</head>
<body>
<center>
	<h3>Ajouter un nouveau stagiaire</h3>
	<form action="/stage" method="Post">
	<table border=0 width=50%>
		<tr>
			<td>Numéro</td>
			<td><input type="text" name="num"/></td>
		</tr>
		<tr>
			<td>Nom</td>
			<td><input type="text" name="nom"/></td>
		</tr>
		<tr>
			<td>Prénom</td>
			<td><input type="text" name="prenom"/></td>
		</tr>
		<tr>
			<td>Date de naissance</td>
			<td><input type="text" name="datnaiss"/></td>
		</tr>
		<tr>
			<td>Lieu de naissance</td>
			<td><input type="text" name="lieunaiss"/></td>
		</tr>
		<tr>
			<td>Numéro de téléphone</td>
			<td><input type="text" name="tele"/></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="email"/></td>
		</tr>
		<tr>
			<td>CIN</td>
			<td><input type="text" name="cin"/></td>
		</tr>
		<tr>
			<td>Ville</td>
			<td><input type="text" name="ville"/></td>
		</tr>
		<tr>
			<td>Date debut de Stage</td>
			<td><input type="text" name="dateD"/></td>
		</tr>
		<tr>
			<td>Date fin de Stage</td>
			<td><input type="text" name="dateF"/></td>
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