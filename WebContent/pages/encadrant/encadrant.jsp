<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../template/header.jsp" />

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath}/pages/index.jsp">Accueil</a></li>
  <li><a href="${pageContext.request.contextPath}/app?controller=encadrantController&action=lister">encadrants</a></li>
  <li class="active">Detail encadrant</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Detail encadrant</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=encadrantController&action=ajouterEtModifier" method="Post" class="form-horizontal">
	  <input type="hidden" name="id" value="<c:out value="${encadrant.id}" />"/>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="nom">Nom</label>
    	<div class="col-md-4">
			<input class="form-control" id="nom" type="text" name="nom" value="<c:out value="${encadrant.nomE}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="prenom">Prénom</label>
    	<div class="col-md-4">
			<input class="form-control" id="prenom" type="text" name="prenom" value="<c:out value="${encadrant.prenomE}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="email">Email</label>
    	<div class="col-md-4">
			<input class="form-control" id="email" name="email" value="<c:out value="${encadrant.email}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="telephone">Numéro de téléphone</label>
    	<div class="col-md-4">
			<input class="form-control" id="telephone" type="text" name="telephone" value="<c:out value="${encadrant.telephone}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="login">Login</label>
    	<div class="col-md-4">
			<input class="form-control" id="login" type="text" name="login" value="<c:out value="${encadrant.login}" />" /></div>
	  </div>
	   <div class="form-group">
    	<label class="col-sm-2 control-label" for="password">Password</label>
    	<div class="col-md-4">
			<input class="form-control" id="password" type="text" name="password" value="<c:out value="${encadrant.password}" />"/></div>
	  </div>
	  <div class="text-right">
		 <a href="${pageContext.request.contextPath}/app?controller=encadrantController&action=lister" class="btn btn-primary" role="button">Retour</a>
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Enregistrer"/>  </div>             
	</form>
  </div>
</div>
</body>
</html>