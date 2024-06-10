package services;

import dao.GroupeDao;
import dao.MatiereDao;
import entities.Groupe;
import entities.Matiere;

import java.util.List;

public class MatiereService {

    public static MatiereService instance;

    private MatiereService() {

    }

    public static MatiereService getInstance() {
        if (null == instance) {
            instance = new MatiereService();
        }
        return instance;
    }

    public void saveMatiere(Matiere matiere) {
        MatiereDao.saveMatiere(matiere);
    }

    public List<Matiere> allMatiere() {
        return MatiereDao.getAllMatiere();
    }

    public Matiere findMatiereByName(String name) {
        return MatiereDao.findMatiereByName(name);
    }

    public Matiere findMatiereById(long requestId) {
        return MatiereDao.findMatiereById(requestId);
    }

    public void deleteMatiere(long requestId) {
        MatiereDao.deleteMatiere(requestId);
    }

    public void updateMatiere(Matiere matiere) {
        MatiereDao.updateMatiere(matiere);
    }

}
