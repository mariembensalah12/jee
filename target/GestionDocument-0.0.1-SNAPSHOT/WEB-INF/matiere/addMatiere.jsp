<%@include file="../common/headerAdmin.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">
<a href="/GestionDocument/matierePage.action" class="btn btn-secondary mb-3"> Liste des Matieres</a>
	<h1>Ajouter Matiere</h1>
	<form action="matierePage.action" method="post">

		<!-- matiere Name -->
		<div class="mb-3">
			<label for="nom" class="form-label">nom matiere</label>
			<input type="text" class="form-control" id="nom"
				name="nom" placeholder="Entrer nom matiere" required>
		</div>


		<!-- Submit Button -->
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</div>
<%@include file="../common/footer.jspf"%>