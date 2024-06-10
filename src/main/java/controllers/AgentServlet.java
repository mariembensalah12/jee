package controllers;

import entities.Groupe;
import entities.PrintDocumentRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.EnseignantService;
import services.GroupeService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/agentPage")
public class AgentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    EnseignantService enseignantService = EnseignantService.getInstance();
    GroupeService groupeService = GroupeService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Groupe> groupes = groupeService.allGroupe();
        request.setAttribute("groupes", groupes);
        List<PrintDocumentRequest> printRequests = enseignantService.findAllPrintRequests();
        request.setAttribute("printRequests", printRequests);
        request.getRequestDispatcher("/WEB-INF/agent/agentPage.jsp").forward(request, response);
    }
}
