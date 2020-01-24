<header>

	<ul >
		<li style="display:inline-block;"><a href="${pageContext.request.contextPath }/ServletAccueil">Accueil</a></li>
		<li style="display:inline-block;"><a href="${pageContext.request.contextPath }/ServletReservation">Mes réservations</a></li>
		<li style="display:inline-block; position: relative; left: 800px;"><a href="${pageContext.request.contextPath }/ServletDeconnexion">Me déconnecter</a></li>
		<li style="display:inline-block; position: relative; left: 800px;"><a href="${pageContext.request.contextPath }/ServletAjouterFilm">Ajouter un film</a></li>
	</ul>
	<p>Bonjour ${nomUtilisateur }</p>

</header>
<nav class="navbar navbar-expand-lg navbar-light bg-light navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown link
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
    </ul>
  </div>
</nav>