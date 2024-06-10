package controllers;

import java.io.IOException;

import entities.Utilisateur;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.UtilisateurService;

@WebServlet(urlPatterns = "/loginServlet")
public class LoginServlet extends HttpServlet {
    UtilisateurService utilisateurService = UtilisateurService.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Utilisateur utilisateur;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");


            utilisateur = utilisateurService.findUtilisateur(username, password, role);
            System.out.println(utilisateur);
            if(utilisateur != null  ) {
                if(utilisateur.getRole().equals("enseignant")){
                    response.sendRedirect("/GestionDocument/printRequest.action");
                }else if(utilisateur.getRole().equals("agent")){
                    response.sendRedirect("/GestionDocument/agentPage");
                }else if(utilisateur.getRole().equals("admin")){
                    response.sendRedirect("/GestionDocument/adminPage.action");
                }else {
                    response.sendRedirect("/GestionDocument/loginServlet");
                }
            }else {
                response.sendRedirect("/GestionDocument/loginServlet");
            }
        }



    }

