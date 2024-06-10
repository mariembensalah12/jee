package services;

import java.util.List;

import dao.UtilisateurDao;
import entities.Utilisateur;

public class UtilisateurService {
    public static UtilisateurService instance;

    private UtilisateurService() {

    }

    public void saveUtilisateur(Utilisateur utilisateur) {
        UtilisateurDao.saveUtilisateur(utilisateur);
    }

    public static UtilisateurService getInstance() {
        if (null == instance) {
            instance = new UtilisateurService();
        }
        return instance;
    }

    public List<Utilisateur> findAllUtilisateur() {
        return UtilisateurDao.getUtilisateur();
    }

    public Utilisateur findUtilisateur(String name, String pwd, String role) {
        return UtilisateurDao.findUtilisateur(name, pwd, role);
    }

    public Utilisateur findUtilisateurById(long requestId) {
        return UtilisateurDao.findUtilisateurById(requestId);
    }

    public void deleteUtilisateur(long requestId) {
        UtilisateurDao.deleteUtilisateur(requestId);
    }

    public void updateUtilisateur(Utilisateur utilisateur) {
        UtilisateurDao.updateUtilisateur(utilisateur);
    }

}
