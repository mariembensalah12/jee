<%@include file="../common/headerAdmin.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div class="container">

    <h1>Modifier une Matiere</h1>
    <form action="matierePage.action" method="post">


<input type="hidden" name="action" value="${action}">
    <input type="hidden" name="id" value="${matiere.id}">

    	<!-- matiere Name -->
    		<div class="mb-3">
    			<label for="nom" class="form-label">nom matiere</label>
    			<input type="text" class="form-control" id="nom"
    				name="nom" placeholder="Entrer nom matiere" value="${matiere.name}" required>
    		</div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%@include file="../common/footer.jspf"%>
