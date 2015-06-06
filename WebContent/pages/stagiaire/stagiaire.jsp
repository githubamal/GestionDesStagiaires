<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../template/header.jsp" />

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath}/pages/index.jsp">Accueil</a></li>
  <li><a href="${pageContext.request.contextPath}/app?controller=stagiaireController&action=lister">Stagiaires</a></li>
  <li class="active">Detail stagiaire</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Detail stagiaire</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=stagiaireController&action=ajouterEtModifier" method="Post" class="form-horizontal">
	  <input type="hidden" name="id" value="<c:out value="${stagiaire.id}" />"/>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="nom">Nom</label>
    	<div class="col-md-4">
			<input class="form-control" id="nom" type="text" name="nom" value="<c:out value="${stagiaire.nom}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="prenom">Prénom</label>
    	<div class="col-md-4">
			<input class="form-control" id="prenom" type="text" name="prenom" value="<c:out value="${stagiaire.prenom}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="datenaissance">Date de naissance</label>
    	<div class="col-md-4">
			<input class="form-control" id="datenaissance" type="text" name="datenaissance"  value="<c:out value="${stagiaire.dateNaissance}"/>" /></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="lieunaissance">Lieu de naissance</label>
    	<div class="col-md-4">
			<input class="form-control" id="lieunaissance" type="text" name="lieunaissance" value="<c:out value="${stagiaire.lieuNaissance}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="ville">Ville</label>
    	<div class="col-md-4">
			<input class="form-control" id="ville" type="text" name="ville" value="<c:out value="${stagiaire.ville}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="telephone">Numéro de téléphone</label>
    	<div class="col-md-4">
			<input class="form-control" id="telephone" type="text" name="telephone" value="<c:out value="${stagiaire.telephone}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="email">Email</label>
    	<div class="col-md-4">
			<input class="form-control" id="email" name="email" value="<c:out value="${stagiaire.email}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="cin">CIN</label>
    	<div class="col-md-4">
			<input class="form-control" id="cin" type="text" name="cin" value="<c:out value="${stagiaire.cin}" />" /></div>
	  </div>
	   <div class="form-group">
    	<label class="col-sm-2 control-label" for="datDebut">Date Début</label>
    	<div class="col-md-4">
			<input class="form-control" id="datDebut" type="text" name="datDebut" value="<c:out value="${stagedatDebut}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="datFin">Date fin</label>
    	<div class="col-md-4">
			<input class="form-control" id="datFin" type="text" name="datFin" value="<c:out value="${stage.datFin}" />"/></div>
	  </div>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="Theme">Thème</label>
		<div class="col-md-4"><select name="idtheme" class="form-control">
			<c:forEach items="${themes}" var="theme">
			  <option  value="${theme.id}"><c:out value="${theme.theme}" /></option>
			 </c:forEach>
		</select>	</div>  </div>
		<div class="form-group">
    	<label class="col-sm-2 control-label" for="nom">Nom Encadrant</label>
		<div class="col-md-4"><select name="idencadrant" class="form-control">
			<c:forEach items="${encadrants}" var="encadrant">
			  <option  value="${encadrant.id}"><c:out value="${encadrant.nomE}" /></option>
			 </c:forEach>
		</select>	</div>  </div>
		<div class="form-group">
    	<label class="col-sm-2 control-label" for="nom">Formation</label>
		<div class="col-md-4"><select  name="idformation" class="form-control">
			<c:forEach items="${formations}" var="formation">
			  <option  value="${formation.id}"><c:out value="${formation.diplome}" /></option>
			 </c:forEach>
		</select>	</div>  </div>
	  <div class="text-right">
		 <a href="${pageContext.request.contextPath}/app?controller=stagiaireController&action=lister" class="btn btn-primary" role="button">Retour</a>
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Enregistrer"/>  </div>             
	</form>
  </div>
</div>
</body>
</html>