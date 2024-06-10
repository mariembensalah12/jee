package services;

import dao.GroupeDao;
import entities.Groupe;

import java.util.List;

public class GroupeService {

    public static GroupeService instance;

    private GroupeService() {

    }

    public static GroupeService getInstance() {
        if (null == instance) {
            instance = new GroupeService();
        }
        return instance;
    }

    public void saveGroupe(Groupe groupe) {
        GroupeDao.saveGroupe(groupe);
    }

    public List<Groupe> allGroupe() {
        return GroupeDao.getAllGroupe();
    }

    public Groupe findGroupeByName(String name) {
        return GroupeDao.findGroupeByName(name);
    }

    public Groupe findGroupeById(long requestId) {
        return GroupeDao.findGroupeById(requestId);
    }

    public void deleteGroupe(long requestId) {
        GroupeDao.deleteGroupe(requestId);
    }

    public void updateGroupe(Groupe groupe) {
        GroupeDao.updateGroupe(groupe);
    }

}
