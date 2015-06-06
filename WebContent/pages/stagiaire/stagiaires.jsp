<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../template/header.jsp" />

<script type="text/javascript">
function showSuppressionDialog(value, id) {
		document.getElementById('idsupp').value = id;
	   $('#confirmSuppressionTitle').html("Confirmation suppression");
	   $('#confirmSuppressionBody').html("Voulez-vous vraiment supprimer "+ value +    "?");
	   $('#confirmSuppression').modal('show');
}
</script>

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath}/pages/index.jsp">Accueil</a></li>
  <li class="active">Stagiaires</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Criteres de recherche</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=stagiaireController&action=chercher" method="Post" class="form-horizontal">
	<div class="form-inline">
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Nom" class="form-control" id="nom" type="text" name="nom" value="<c:out value="${stagiaire.nom}" />"/></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Prénom" class="form-control" id="prenom" type="text" name="prenom" value="<c:out value="${stagiaire.prenom}" />"/></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Date de naissance" class="form-control" id="datenaissance" type="text" name="datenaissance"  value="<c:out value="${stagiaire.dateNaissance}"/>" /></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Lieu de naissance" class="form-control" id="lieunaissance" type="text" name="lieunaissance" value="<c:out value="${stagiaire.lieuNaissance}" />"/></div>
	  </div> </div><br>
	  <div class="form-inline">
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Ville" class="form-control" id="ville" type="text" name="ville" value="<c:out value="${stagiaire.ville}" />"/></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Numéro de téléphone" class="form-control" id="telephone" type="text" name="telephone" value="<c:out value="${stagiaire.telephone}" />"/></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Email" class="form-control" id="email" name="email" value="<c:out value="${stagiaire.email}" />"/></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="CIN" class="form-control" id="cin" type="text" name="cin" value="<c:out value="${stagiaire.cin}" />" /></div>
	  </div>
	  <div class="text-right">
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Rechercher"/>         
		<a href="${pageContext.request.contextPath}/app?controller=stagiaireController&action=recuperer" class="btn btn-primary" role="button">Ajouter</a>  
		</div>  </div>    
	</form>
  </div>
</div>

<div class="panel panel-success">
  <div class="panel-heading">Liste des stagiaires</div>
  <div class="panel-body">
  <centre>
    <table class="table table-hover table-bordered table-striped">
        <thead class="btn-primary">
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Date de Naissance</th>
                <th>Lieu de Naissance</th>
                <th>Ville</th>
                <th>Téléphone</th>
                <th>Email</th>
                <th>CIN</th>
				<th>Thème</th>
				<th>Nom Encadrant</th>
				<th>Date Début</th>
				<th>Date fin</th>
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${stagiaires}" var="stagiaire">
                <tr>
                    <td><c:out value="${stagiaire.nom}" /></td>
                    <td><c:out value="${stagiaire.prenom}" /></td>
                    <td><c:out value="${stagiaire.dateNaissance}" /></td>
                    <td><c:out value="${stagiaire.lieuNaissance}" /></td>
                    <td><c:out value="${stagiaire.ville}" /></td>
                    <td><c:out value="${stagiaire.telephone}" /></td>
                    <td><c:out value="${stagiaire.email}" /></td>
                    <td><c:out value="${stagiaire.cin}" /></td>
					<td><c:out value="${stagiaire.theme}" /></td>
					<td><c:out value="${stagiaire.nomEncadrant}" /></td>
					<td><c:out value="${stagiaire.dateDebut}" /></td>
					<td><c:out value="${stagiaire.dateFin}" /></td>
                    <td><a href="${pageContext.request.contextPath}/app?controller=stagiaireController&action=recuperer&id=<c:out value="${stagiaire.id}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td>
                    <a href="#" onClick="showSuppressionDialog('${stagiaire.nom}  ${stagiaire.prenom}','${stagiaire.id}')" >
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </centre>
      </div>
</div>


<!-- Modal -->
<div class="modal fade" id="confirmSuppression" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

<form 
action="${pageContext.request.contextPath}/app?controller=stagiaireController&action=supprimer" method="Post">
	<input type="hidden" id="idsupp" name="idsupp">
	
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="confirmSuppressionTitle"></h4>
      </div>
      <div class="modal-body" id="confirmSuppressionBody">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
        <button type="submit" class="btn btn-danger">Supprimer</button>
      </div>
    </div>
  </div>
</form> 

</div>

</body>
</html>