<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../template/header.jsp" />

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath}/pages/index.jsp">Accueil</a></li>
  <li><a href="${pageContext.request.contextPath}/app?controller=stageController&action=lister">Stages</a></li>
  <li class="active">Detail stage</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Detail stage</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=stageController&action=ajouterEtModifier" method="Post" class="form-horizontal">
	  <input type="hidden" name="id" value="<c:out value="${stage.id}" />"/>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="intitulestage">Intitulé stage</label>
    	<div class="col-md-4">
			<input class="form-control" id="intitulestage" type="text" name="intitulestage" value="<c:out value="${stage.intituleStage}" />"/></div>
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
		<div class="col-md-4"><select class="form-control">
			<c:forEach items="${themes}" var="theme">
			  <option  value="${theme.id}"><c:out value="${theme.theme}" /></option>
			 </c:forEach>
		</select>	</div>  </div>

	  <div class="text-right">
		 <a href="${pageContext.request.contextPath}/app?controller=stageController&action=lister" class="btn btn-primary" role="button">Retour</a>
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Enregistrer"/>  </div>             
	</form>
  </div>
</div>
</body>
</html>