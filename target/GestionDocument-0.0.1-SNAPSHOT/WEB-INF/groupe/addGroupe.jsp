<%@include file="../common/headerAdmin.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">
<a href="/GestionDocument/groupePage.action" class="btn btn-secondary mb-3"> Liste des Groupes</a>

	<h1>Ajouter Groupe</h1>

	<form action="groupePage.action" method="post">

		<!-- groupe Name -->
		<div class="mb-3">
			<label for="nom" class="form-label">nom groupe</label>
			<input type="text" class="form-control" id="nom"
				name="nom" placeholder="Entrer nom Groupe" required>
		</div>

		<!-- nombre groupe -->
		<div class="mb-3">
        			<label for="nombre" class="form-label">nombre des eleves</label>
        			<input type="number" class="form-control" id="nombre"
        				name="nombre" placeholder="Entrer nombre de groupe" required>
        </div>

		<!-- Submit Button -->
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@include file="../common/footer.jspf"%>