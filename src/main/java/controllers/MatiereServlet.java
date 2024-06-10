package controllers;

import entities.Matiere;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.MatiereService;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/matierePage.action")
public class MatiereServlet extends HttpServlet {
    
    MatiereService matiereService = MatiereService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        System.out.println("***************************** "+action);
        if ("add".equals(action)) {
            request.getRequestDispatcher("/WEB-INF/matiere/addMatiere.jsp").forward(request, response);
        } else if ("delete".equals(action)) {
            long requestId = Long.parseLong(request.getParameter("id"));
            matiereService.deleteMatiere(requestId);
            response.sendRedirect("/GestionDocument/matierePage.action");
        } else  if ("update".equals(action)) {
            long requestId = Long.parseLong(request.getParameter("id"));
            Matiere matiere = matiereService.findMatiereById(requestId);
            request.setAttribute("matiere", matiere);
            request.getRequestDispatcher("/WEB-INF/matiere/updateMatiere.jsp").forward(request, response);
        } else {
            List<Matiere> matieres = matiereService.allMatiere();
            request.setAttribute("matieres", matieres);
            request.getRequestDispatcher("/WEB-INF/matiere/matiereList.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");
        Matiere matiere;

        if (idParam != null && !idParam.isEmpty()) {
            // Update existing print request
            long requestId = Long.parseLong(idParam);
            matiere = matiereService.findMatiereById(requestId);
        } else {
            // Create new print request
            matiere = new Matiere();
        }

        // Common code for both new and existing print requests
        matiere.setName(request.getParameter("nom"));

        if (idParam != null && !idParam.isEmpty()) {
            // Update existing print request
            matiereService.updateMatiere(matiere);
        } else {
            // Save new print request
            matiereService.saveMatiere(matiere);
        }

        response.sendRedirect("/GestionDocument/matierePage.action");
    }}
