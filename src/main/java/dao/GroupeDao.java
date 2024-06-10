package dao;

import java.util.ArrayList;
import java.util.List;


import entities.Groupe;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class GroupeDao {

    public static GroupeDao instance;

    private GroupeDao() {

    }

    public static GroupeDao getInstance() {
        if (null == instance) {
            instance = new GroupeDao();
        }
        return instance;

    }

    public static void saveGroupe(Groupe groupe) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // save the utilisateur in database
            session.save(groupe);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static List<Groupe> getAllGroupe() {
        List<Groupe> groupeList = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Groupe> query = session.createQuery("FROM Groupe",
                    Groupe.class);
            groupeList = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return groupeList;
    }

    public static Groupe findGroupeByName(String name) {
        Groupe groupe = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Option 1: HQL with named parameters (recommended)
            Query query = session.createQuery("FROM Groupe g WHERE g.name = :name");
            query.setParameter("name", name);
            groupe = (Groupe) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(); // Replace with proper logging
        }
        return groupe;
    }



    public static void deleteGroupe(long requestId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("DELETE FROM Groupe WHERE id = :id");
            query.setParameter("id", requestId);
            int result = query.executeUpdate(); // Execute the deletion

            if (result > 0) {
                System.out.println("groupe deleted successfully");
            } else {
                System.out.println("No groupe found with the given ID");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateGroupe(Groupe groupe) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(groupe);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }


    public static Groupe findGroupeById(long requestId) {
        Groupe groupe = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            groupe = session.get(Groupe.class, requestId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return groupe;
    }
}

