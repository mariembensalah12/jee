<%@include file="./common/headerAdmin.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<div class="container">
    <h1>Modifier un Utilisateur</h1>
    <form action="adminPage.action" method="post">


<input type="hidden" name="action" value="${action}">
    <input type="hidden" name="id" value="${utilisateur.id}">

    <!-- Rest of your form fields -->
        <div class="mb-3">
            <label for="nom" class="form-label">Nom utilisateur</label>
            <input type="text" class="form-control" id="nom" name="nom" value="${utilisateur.name}" required>
        </div>

        <div class="mb-3">
                            <label for="email" class="form-label">Email utilisateur</label>
                            <input type="text" class="form-control" id="email" name="email" value="${utilisateur.email}" required>
        </div>

        <div class="mb-3">
                    <label for="role" class="form-label">Role utilisateur</label>
                    <input type="text" class="form-control" id="role" name="role" value="${utilisateur.role}" required>
        </div>

        <div class="mb-3">
                            <label for="pwd" class="form-label">Mot de pass utilisateur</label>
                            <input type="text" class="form-control" id="pwd" name="pwd" value="${utilisateur.pwd}" required>
        </div>

        <!-- Filiere Select Box -->
        <div class="mb-3">
            <label for="filiereSelect" class="form-label">Role</label>
            <select class="form-select" id="levelSelect" name="level" required>
                <option value="">Selectionner un niveau</option>
                <option value="enseignant" ${utilisateur.role == 'enseignant' ? 'selected' : ''}>Enseignant</option>
                <option value="agent" ${utilisateur.role == 'agent' ? 'selected' : ''}>Agent</option>
                <option value="admin" ${utilisateur.role == 'admin' ? 'selected' : ''}>Admin</option>
                <!-- Add more options as needed -->
            </select>
        </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<%@include file="./common/footer.jspf"%>
