package controllers;

import entities.Groupe;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.GroupeService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/groupePage.action")
public class GroupeServlet extends HttpServlet{
    GroupeService groupeService = GroupeService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        System.out.println("***************************** "+action);
        if ("add".equals(action)) {
            request.getRequestDispatcher("/WEB-INF/groupe/addGroupe.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            long requestId = Long.parseLong(request.getParameter("id"));
            groupeService.deleteGroupe(requestId);
            response.sendRedirect("/GestionDocument/groupePage.action");
        } else  if ("update".equals(action)) {
            long requestId = Long.parseLong(request.getParameter("id"));
            Groupe groupe = groupeService.findGroupeById(requestId);
            request.setAttribute("groupe", groupe);
            request.getRequestDispatcher("/WEB-INF/groupe/updateGroupe.jsp").forward(request, response);
        } else {
            List<Groupe> groupes = groupeService.allGroupe();
            request.setAttribute("groupes", groupes);
            request.getRequestDispatcher("/WEB-INF/groupe/groupeList.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        Groupe groupe;

        if (idParam != null && !idParam.isEmpty()) {
            // Update existing print request
            long requestId = Long.parseLong(idParam);
            groupe = groupeService.findGroupeById(requestId);
        } else {
            // Create new print request
            groupe = new Groupe();
        }

        // Common code for both new and existing print requests
        groupe.setName(request.getParameter("nom"));
        groupe.setNombre(Integer.parseInt(request.getParameter("nombre")));

        if (idParam != null && !idParam.isEmpty()) {
            // Update existing print request
            groupeService.updateGroupe(groupe);
        } else {
            // Save new print request
            groupeService.saveGroupe(groupe);
        }

        response.sendRedirect("/GestionDocument/groupePage.action");
    }

}
