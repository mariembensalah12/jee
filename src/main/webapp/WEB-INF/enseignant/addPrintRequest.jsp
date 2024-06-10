<%@include file="../common/header.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
<a href="/GestionDocument/printRequest.action" class="btn btn-secondary mb-3"> Liste des Demandes</a>

	<h1>Ajouter une nouvelle demande de tirage</h1>
	<form action="printRequest.action" method="post">
		<!-- Document Name -->
		<div class="mb-3">
			<label for="documentName" class="form-label">Nom de document</label>
			<input type="text" class="form-control" id="documentName"
				name="documentName" placeholder="Enter document name" required>
		</div>

		<!-- Matiere Select Box -->
		<div class="mb-3">
		<label for="subjectSelect" class="form-label">Matieres</label>
            <select class="form-select" id="subjectSelect" name="subject" required>
                <option value="">Selectionner une matiere</option>
                <c:forEach var="matiere" items="${requestScope.matieres}">
                    <option value="${matiere.name}">${matiere.name}</option>
                </c:forEach>
            </select>
		</div>

		<!-- Group Select Box -->
		<div class="mb-3">
			<label for="groupe" class="form-label">Groupes</label> <select
				class="form-select" id="groupe" name="groupe" required>
				<option value="">Selectionner un groupe</option>
				<c:forEach var="groupe" items="${requestScope.groupes}">
                     <option value="${groupe.name}">${groupe.name}</option>
                </c:forEach>
			</select>
		</div>

		<!-- Document Upload -->
		<div class="mb-3">
			<label for="documentFile" class="form-label">Telecharger un
				document</label> <input type="file" class="form-control" id="documentFile"
				name="documentFile" accept=".pdf,.doc,.docx" required>
		</div>

		<!-- Date and Time -->
		<div class="mb-3">
			<label for="documentDateTime" class="form-label">Date and
				Time</label> <input type="datetime-local" class="form-control"
				id="documentDateTime" name="documentDateTime" required>
		</div>


		<!-- Submit Button -->
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@include file="../common/footer.jspf"%>