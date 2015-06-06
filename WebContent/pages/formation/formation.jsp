<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../template/header.jsp" />

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath}/pages/index.jsp">Accueil</a></li>
  <li><a href="${pageContext.request.contextPath}/app?controller=formationController&action=lister">formations</a></li>
  <li class="active">Detail formation</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Detail formation</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=formationController&action=ajouterEtModifier" method="Post" class="form-horizontal">
	  <input type="hidden" name="id" value="<c:out value="${formation.id}" />"/>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="etablissement">Etablissement</label>
    	<div class="col-md-4">
			<input class="form-control" id="etablissement" type="text" name="etablissement" value="<c:out value="${formation.etablissement}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="diplome">Diplôme</label>
    	<div class="col-md-4">
			<input class="form-control" id="diplome" type="text" name="diplome" value="<c:out value="${formation.diplome}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="filiere">Filière</label>
    	<div class="col-md-4">
			<input class="form-control" id="filiere" type="text" name="filiere" value="<c:out value="${formation.filiere}" />"/></div>
	  </div>
	  <div class="text-right">
		 <a href="${pageContext.request.contextPath}/app?controller=formationController&action=lister" class="btn btn-primary" role="button">Retour</a>
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Enregistrer"/>  </div>             
	</form>
  </div>
</div>
</body>
</html>