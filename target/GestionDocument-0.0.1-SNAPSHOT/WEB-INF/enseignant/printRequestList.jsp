<%@include file="../common/header.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
    .input-group-lg {
      width: 50%;
      height: 50%;
    }
  </style>
<div class="container mt-3">
	<h2>Mes demandes</h2>
	<div class="d-flex justify-content-between mb-3">
		<div class="input-group input-group-lg mb-3">
			<input type="text" class="form-control"
				placeholder="Search by name or category" id="searchInput">
		</div>
	</div>

	<table class="table table-striped" id="tableData">
		<thead>
			<tr>
				<th>Nom</th>
				<th>Groupe</th>
				<th>Matiere</th>
				<th>Document</th>
				<th>Date</th>
				<th>Etat Impression</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="printRequest" items="${requestScope.printRequests}">
				<tr>
					<td>${printRequest.name}</td>
					<td>${printRequest.groupe}</td>
					<td>${printRequest.subject}</td>
					<td>${printRequest.documentPath}</td>
					<td>${printRequest.date}</td>
					<td>${printRequest.printStatus}</td>
					<td>
						<div class="d-flex justify-content-center">
							<a href="/GestionDocument/printRequest.action?action=update&id=${printRequest.id}" class="btn btn-sm btn-primary me-1">
								<i class="bi bi-pen"></i>
							</a> 
							<a href="/GestionDocument/printRequest.action?action=delete&id=${printRequest.id}" class="btn btn-sm btn-danger"> <i
								class="bi bi-trash"></i>
							</a>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
 <script>
    const searchInput = document.getElementById('searchInput');
    const tableBody = document.getElementById('tableData');
    searchInput.addEventListener('keyup', function() {
      const searchTerm = this.value.toLowerCase();
      const tableRows = tableBody.querySelectorAll('tr');

      for (let i = 0; i < tableRows.length; i++) {
        const rowText = tableRows[i].textContent.toLowerCase();
        const shouldShowRow = rowText.indexOf(searchTerm) !== -1;
        tableRows[i].style.display = shouldShowRow ? '' : 'none';
      }
    });
  </script>
<%@include file="../common/footer.jspf"%>
