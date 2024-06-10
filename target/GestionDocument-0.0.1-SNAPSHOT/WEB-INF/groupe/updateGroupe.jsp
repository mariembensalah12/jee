<%@include file="../common/headerAdmin.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<div class="container">

    <h1>Modifier un Groupe</h1>
    <form action="groupePage.action" method="post">


<input type="hidden" name="action" value="${action}">
    <input type="hidden" name="id" value="${groupe.id}">

    	<!-- groupe Name -->
    		<div class="mb-3">
    			<label for="nom" class="form-label">nom groupe</label>
    			<input type="text" class="form-control" id="nom"
    				name="nom" placeholder="Entrer nom Groupe" value="${groupe.name}" required>
    		</div>

    		<!-- nombre groupe -->
    		<div class="mb-3">
            			<label for="nombre" class="form-label">nombre des eleves</label>
            			<input type="number" class="form-control" id="nombre"
            				name="nombre" placeholder="Entrer nombre de groupe" value="${groupe.nombre}" required>
            </div>

        <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<%@include file="../common/footer.jspf"%>
