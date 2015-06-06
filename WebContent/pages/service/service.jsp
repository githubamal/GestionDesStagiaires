<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../template/header.jsp" />

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath}/pages/index.jsp">Accueil</a></li>
  <li><a href="${pageContext.request.contextPath}/app?controller=serviceController&action=lister">services</a></li>
  <li class="active">Detail services</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Detail service</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=serviceController&action=ajouterEtModifier" method="Post" class="form-horizontal">
	  <input type="hidden" name="id" value="<c:out value="${service.id}" />"/>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="nom">Nom service</label>
    	<div class="col-md-4">
			<input class="form-control" id="nom" type="text" name="nom" value="<c:out value="${service.nom}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="prenom">Chef service</label>
    	<div class="col-md-4">
			<input class="form-control" id="chef" type="text" name="chef" value="<c:out value="${service.chef}" />"/></div>
	  </div>
	  <div class="text-right">
		 <a href="${pageContext.request.contextPath}/app?controller=serviceController&action=lister" class="btn btn-primary" role="button">Retour</a>
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Enregistrer"/>  </div>             
	</form>
  </div>
</div>
</body>
</html>