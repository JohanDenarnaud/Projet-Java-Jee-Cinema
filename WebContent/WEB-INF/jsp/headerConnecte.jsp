<header>

	
	<div class="container">

		<h1>CINEMA RILLHETTE</h1>

		<nav
			class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">

			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<ul class="navbar-nav">
					<li class=" nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath }/ServletAccueil">Accueil
							<span class="sr-only">(current)</span>
					</a></li>
					<li class=" nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath }/ServletReservation">Mes
							réservations</a></li>
					<li class=" nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath }/ServletAjouterFilm">Gestion
							des films</a></li>

					<li class="	 nav-item active"><a class="nav-link"
						href="${pageContext.request.contextPath }/ServletDeconnexion">Me
							déconnecter</a></li>
				</ul>
			</div>
		</nav>
	</div>



	<div class="container">
		<div class="row">
			<div class="col-auto">
				<p>Bonjour ${nomUtilisateur }</p>
			</div>
		</div>
	</div>

</header>