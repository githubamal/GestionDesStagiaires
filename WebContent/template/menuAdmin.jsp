<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/historique/historique.jsp"> <img alt="Brand"
				src="${pageContext.request.contextPath}/resources/images/colaimoo.png" width="80" height="30">
			</a>
		</div>
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/pages/accueil/accueil.jsp">Accueil</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li  hidden="true"><a href="${pageContext.request.contextPath}/app?controller=stagiaireController&action=lister">Stagiaire						</a></li>
<%-- 				<li><a href="${pageContext.request.contextPath}/app?controller=stageController&action=lister">Stage</a></li> --%>
				<li><a href="${pageContext.request.contextPath}/app?controller=themeController&action=lister">Thème</a></li>
				<li><a href="${pageContext.request.contextPath}/app?controller=formationController&action=lister">Formation</a></li>
				<li><a href="${pageContext.request.contextPath}/app?controller=encadrantController&action=lister">Encadrant <span class="sr-only">(current)</span></a></li>
        		<li><a href="${pageContext.request.contextPath}/app?controller=serviceController&action=lister">Service</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-expanded="false">Profil
						<span class="caret"></span>
				</a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="${pageContext.request.contextPath}/pages/accueil/accueil.jsp">Profil</a></li>
						<li><a href="${pageContext.request.contextPath}/login?lougout=1">Deconnexion</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
