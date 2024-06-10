<%@include file="../common/headerAgent.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


       <div class="top-left">

    </div>
    <div class="container">
      <div class="date">Date: <%= new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %></div>
    <div class="d-flex justify-content-between mb-3">
		<div class="input-group input-group-lg mb-3">
			<input type="text" class="form-control"
				placeholder="Chercher par nom" id="searchInput">
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
				<th>Nombre de page</th>
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
					<c:forEach var="groupe" items="${requestScope.groupes}">

                        <td>
                          <c:if test="${printRequest.groupe == groupe.name}">
                            ${groupe.nombre}
                          </c:if>
                        </td>

                    </c:forEach>
					<td>
						<div class="d-flex justify-content-center">
							<button class="btn btn-primary" onclick="printDocument(this)">Print</button>
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

    function printDocument(button) {
        const table = document.getElementById('tableData'); // Assuming your table has the ID 'tableData'
          const win = window.open("", "", "width=800,height=500"); // Open a new print window (optional: adjust size)
          win.document.write(table.outerHTML); // Write the table's HTML content to the new window
          win.document.close(); // Close the new window document
          win.focus(); // Focus the new window
          win.print(); // Print the content of the new window
    }

    </script>
<%@include file="../common/footer.jspf"%>