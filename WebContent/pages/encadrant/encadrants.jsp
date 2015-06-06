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
  <li class="active">Encadrants</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Criteres de recherche</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=encadrantController&action=chercher" method="Post" class="form-horizontal">
	<div class="form-inline">
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Nom encadrant" class="form-control" id="nomE" type="text" name="nomE" value="<c:out value="${encadrant.nomE}" />"/></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Prénom encadrant" class="form-control" id="prenomE" type="text" name="prenomE" value="<c:out value="${encadrant.prenomE}" />"/></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Email" class="form-control" id="email" type="text" name="email"  value="<c:out value="${encadrant.email}"/>" /></div>
	  </div>
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Numéro de Telephone" class="form-control" id="telephone" type="text" name="telephone" value="<c:out value="${encadrant.telephone}" />"/></div>
	  </div> </div><br>
	  <div class="text-right">
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Rechercher"/>         
		<a href="${pageContext.request.contextPath}/pages/encadrant/encadrant.jsp" class="btn btn-primary" role="button">Ajouter</a>  
		</div>  
	</form> </div>   
  </div>
<div class="panel panel-success">
  <div class="panel-heading">Liste des encadrants</div>
  <div class="panel-body">
    <table class="table table-hover table-bordered table-striped">
        <thead class="btn-primary">
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Email</th>
                <th>Telephone</th>
                <th>Login</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${encadrants}" var="encadrant">
                <tr>
                    <td><c:out value="${encadrant.nomE}" /></td>
                    <td><c:out value="${encadrant.prenomE}" /></td>
                    <td><c:out value="${encadrant.email}" /></td>
                    <td><c:out value="${encadrant.telephone}" /></td>
                    <td><c:out value="${encadrant.login}" /></td>
         			<td><a href="${pageContext.request.contextPath}/app?controller=encadrantController&action=recuperer&id=<c:out value="${encadrant.id}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
         			 <td><a href="#" onClick="showSuppressionDialog('${encadrant.nomE}  ${encadrant.prenomE}  ','${encadrant.id}')" >
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
            </c:forEach>
        </tbody>
    </table>
    </div>   
  </div>
  
  <!-- Modal -->
<div class="modal fade" id="confirmSuppression" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

<form 
action="${pageContext.request.contextPath}/app?controller=encadrantController&action=supprimer" method="Post">
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