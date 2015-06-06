<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="../../template/header.jsp" />

<ol class="breadcrumb">
  <li><a href="${pageContext.request.contextPath}/pages/index.jsp">Accueil</a></li>
  <li><a href="${pageContext.request.contextPath}/app?controller=themeController&action=lister">thèmes</a></li>
  <li class="active">Detail thème</li>
</ol>

<div class="panel panel-info">
  <div class="panel-heading">Détail thème</div>
  <div class="panel-body">
	<form action="${pageContext.request.contextPath}/app?controller=themeController&action=ajouterEtModifier" method="Post" class="form-horizontal">
	  <input type="hidden" name="id" value="<c:out value="${theme.id}" />"/>
	  <div class="form-group">
    	<label class="col-sm-2 control-label" for="theme">thème</label>
    	<div class="col-md-4">
			<input class="form-control" id="theme" type="text" name="theme" value="<c:out value="${theme.theme}" />"/></div>
	  </div>
	  <div class="text-right">
		 <a href="${pageContext.request.contextPath}/app?controller=themeController&action=lister" class="btn btn-primary" role="button">Retour</a>
		 <input type="reset" class="btn btn-warning" value="Effacer"/>
		<input type="submit"  class="btn btn-success" value="Enregistrer"/>  </div>             
	</form>
  </div>
</div>
</body>
</html>