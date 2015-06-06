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
  <li class="active">Th�mes</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Criteres de recherche</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=themeController&action=chercher" method="Post" class="form-horizontal">
	<div class="form-inline">
	  <div class="form-group">
    	<div class="col-md-4">
			<input placeholder="Th�me" class="form-control" id="theme" type="text" name="theme" value="<c:out value="${theme.theme}" />"/></div>
	  </div>
	  </div>
	  <div class="text-right">
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Rechercher"/>         
		<a href="${pageContext.request.contextPath}/pages/stage/theme.jsp" class="btn btn-primary" role="button">Ajouter</a>  
		</div>   
	</form>
  </div>
</div>

<div class="panel panel-success">
  <div class="panel-heading">Liste des th�mes</div>
  <div class="panel-body">
    <table class="table table-hover table-bordered table-striped">
        <thead class="btn-primary">
            <tr>
                <th>th�me</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${themes}" var="theme">
                <tr>
                    <td><c:out value="${theme.theme}" /></td>
                    <td><a href="${pageContext.request.contextPath}/app?controller=themeController&action=recuperer&id=<c:out value="${theme.id}"/>"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td><a href="#" onClick="showSuppressionDialog('${theme.theme} ','${theme.id}')"> <span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    </div>
</div>
<!-- Modal -->

<div class="modal fade" id="confirmSuppression" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
 <form 
action="${pageContext.request.contextPath}/app?controller=themeController&action=supprimer" method="Post">
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