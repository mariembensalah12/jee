<%@include file="../common/header.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
    <h1>Modifier une demande de tirage</h1>
    <form action="printRequest.action" method="post">
    

<input type="hidden" name="action" value="${action}">
    <input type="hidden" name="id" value="${printDocumentRequest.id}">
    <!-- Rest of your form fields -->
        <div class="mb-3">
            <label for="documentName" class="form-label">Nom de document</label>
            <input type="text" class="form-control" id="documentName"
                name="documentName" value="${printDocumentRequest.name}" required>
        </div>

        <!-- Matiere Select Box -->
        <div class="mb-3">
            <label for="subjectSelect" class="form-label">Matieres</label>
            <select class="form-select" id="subjectSelect" name="subject" required>
                <option value="">Selectionner une matiere</option>
                <c:forEach var="matiere" items="${requestScope.matieres}">
                 <option value="${matiere.name}" ${matiere.name == printDocumentRequest.subject ? 'selected' : ''}>${matiere.name}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Group Select Box -->
        <div class="mb-3">
            <label for="groupSelect" class="form-label">Groupes</label>
            <select class="form-select" id="groupSelect" name="groupe" required>
                <option value="">Selectionner un groupe</option>
                <c:forEach var="groupe" items="${requestScope.groupes}">
                    <option value="${groupe.name}" ${groupe.name == printDocumentRequest.groupe ? 'selected' : ''}>${groupe.name}</option>
                </c:forEach>
            </select>
        </div>

        <!-- Document Upload -->
        <div class="mb-3">
            <label for="documentFile" class="form-label">Telecharger un document</label>
            <input type="file" class="form-control" id="documentFile"
                name="documentFile" accept=".pdf,.doc,.docx" required>
        </div>

        <!-- Date and Time -->
        <div class="mb-3">
            <label for="documentDateTime" class="form-label">Date and
                Time</label>
            <input type="datetime-local" class="form-control"
                id="documentDateTime" name="documentDateTime" value="${printDocumentRequest.date}" required>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@include file="../common/footer.jspf"%>
