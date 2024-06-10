package controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entities.Groupe;
import entities.Matiere;
import entities.PrintDocumentRequest;
import entities.PrintStatusEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.EnseignantService;
import services.GroupeService;
import services.MatiereService;

/**
 * Servlet implementation class TirageRequestServlet
 */
@WebServlet(urlPatterns = "/printRequest.action")
public class PrintDocumentRequestServlet extends HttpServlet {
	EnseignantService enseignantService = EnseignantService.getInstance();
	GroupeService groupeService = GroupeService.getInstance();
	MatiereService matiereService = MatiereService.getInstance();

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintDocumentRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println("***************************** "+action);
		if ("add".equals(action)) {
			List<Groupe> groupes = groupeService.allGroupe();
			List<Matiere> matieres = matiereService.allMatiere();
			request.setAttribute("groupes", groupes);
			request.setAttribute("matieres", matieres);
			request.getRequestDispatcher("/WEB-INF/enseignant/addPrintRequest.jsp").forward(request, response);
		} else if ("delete".equals(action)) {
			long requestId = Long.parseLong(request.getParameter("id"));
			enseignantService.deletePrintRequest(requestId);
			response.sendRedirect("/GestionDocument/printRequest.action");
		} else  if ("update".equals(action)) {
			List<Groupe> groupes = groupeService.allGroupe();
			List<Matiere> matieres = matiereService.allMatiere();
			request.setAttribute("groupes", groupes);
			request.setAttribute("matieres", matieres);
			long requestId = Long.parseLong(request.getParameter("id"));
			PrintDocumentRequest printDocumentRequest = enseignantService.findPrintRequestById(requestId);
			request.setAttribute("printDocumentRequest", printDocumentRequest);
			request.getRequestDispatcher("/WEB-INF/enseignant/updatePrintRequest.jsp").forward(request, response);
		} else {
			List<PrintDocumentRequest> printRequests = enseignantService.findAllPrintRequests();

			request.setAttribute("printRequests", printRequests);

			request.getRequestDispatcher("/WEB-INF/enseignant/printRequestList.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    String idParam = request.getParameter("id");
	    PrintDocumentRequest printDocumentRequest;

	    if (idParam != null && !idParam.isEmpty()) {
	        // Update existing print request
	        long requestId = Long.parseLong(idParam);
	        printDocumentRequest = enseignantService.findPrintRequestById(requestId);
	    } else {
	        // Create new print request
	        printDocumentRequest = new PrintDocumentRequest();
	    }

	    // Common code for both new and existing print requests
	    printDocumentRequest.setName(request.getParameter("documentName"));
	    printDocumentRequest.setGroupe(request.getParameter("groupe"));
	    printDocumentRequest.setSubject(request.getParameter("subject"));
	    printDocumentRequest.setDocumentPath(request.getParameter("documentFile"));
	    printDocumentRequest.setPrintStatus(PrintStatusEnum.UNTREATED);

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	    LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("documentDateTime"), formatter);
	    printDocumentRequest.setDate(dateTime);

	    if (idParam != null && !idParam.isEmpty()) {
	        // Update existing print request
	        enseignantService.updatePrintRequest(printDocumentRequest);
	    } else {
	        // Save new print request
	        enseignantService.savePrintRequest(printDocumentRequest);
	    }

	    response.sendRedirect("/GestionDocument/printRequest.action");
	}



}