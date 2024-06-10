package controllers;

import entities.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UtilisateurService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/adminPage.action")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UtilisateurService utilisateurService = UtilisateurService.getInstance();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        System.out.println("***************************** "+action);
        if ("add".equals(action)) {
            request.getRequestDispatcher("/WEB-INF/addUtilisateur.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            long requestId = Long.parseLong(request.getParameter("id"));
            utilisateurService.deleteUtilisateur(requestId);
            response.sendRedirect("/GestionDocument/adminPage.action");
        } else  if ("update".equals(action)) {
            long requestId = Long.parseLong(request.getParameter("id"));
            Utilisateur utilisateur = utilisateurService.findUtilisateurById(requestId);
            request.setAttribute("utilisateur", utilisateur);
            request.getRequestDispatcher("/WEB-INF/updateUtilisateur.jsp").forward(request, response);
        } else {
            List<Utilisateur> utilisateurs = utilisateurService.findAllUtilisateur();
            request.setAttribute("utilisateurs", utilisateurs);
            request.getRequestDispatcher("/WEB-INF/adminPage.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        Utilisateur utilisateur;

        if (idParam != null && !idParam.isEmpty()) {
            // Update existing print request
            long requestId = Long.parseLong(idParam);
            utilisateur = utilisateurService.findUtilisateurById(requestId);
        } else {
            // Create new print request
            utilisateur = new Utilisateur();
        }

        // Common code for both new and existing print requests
        utilisateur.setName(request.getParameter("nom"));
        utilisateur.setEmail(request.getParameter("email"));
        utilisateur.setRole(request.getParameter("role"));
        utilisateur.setPwd(request.getParameter("pwd"));

        if (idParam != null && !idParam.isEmpty()) {
            // Update existing print request
            utilisateurService.updateUtilisateur(utilisateur);
        } else {
            // Save new print request
            utilisateurService.saveUtilisateur(utilisateur);
        }

        response.sendRedirect("/GestionDocument/adminPage.action");
    }

}
