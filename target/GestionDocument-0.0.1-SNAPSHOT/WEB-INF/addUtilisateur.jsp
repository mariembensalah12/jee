<%@include file="./common/headerAdmin.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<div class="container">
<a href="/GestionDocument/adminPage.action" class="btn btn-secondary mb-3"> Liste des Utilisateurs</a>

	<h1>Ajouter un Utilisateur</h1>
	<form action="adminPage.action" method="post">

		<!-- user Name -->
		<div class="mb-3">
			<label for="nom" class="form-label">nom utilisateur</label>
			<input type="text" class="form-control" id="nom"
				name="nom" placeholder="Entrer nom utilisateur" required>
		</div>

		<!-- user email -->
		<div class="mb-3">
        			<label for="email" class="form-label">email utilisateur</label>
        			<input type="text" class="form-control" id="email"
        				name="email" placeholder="Entrer email utilisateur" required>
        </div>

        <!-- user password -->
        		<div class="mb-3">
                			<label for="pwd" class="form-label">mot de passe utilisateur</label>
                			<input type="text" class="form-control" id="pwd"
                				name="pwd" placeholder="Entrer mot de passe utilisateur" required>
                </div>

		<!-- Filiere Select Box -->
		<div class="mb-3">
			<label for="role" class="form-label">Niveau</label> <select
				class="form-select" id="role" name="role" required>
				<option value="">Selectionner un role</option>
				<option value="admin">admin</option>
				<option value="enseignant">enseignant</option>
				<option value="agent">agent</option>
				<!-- Add more options as needed -->
			</select>
		</div>

		<!-- Submit Button -->
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@include file="./common/footer.jspf"%>