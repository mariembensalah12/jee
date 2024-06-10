package dao;

import java.util.ArrayList;
import java.util.List;


import entities.Groupe;
import entities.Matiere;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class MatiereDao {
    public static MatiereDao instance;

    private MatiereDao() {

    }

    public static MatiereDao getInstance() {
        if (null == instance) {
            instance = new MatiereDao();
        }
        return instance;

    }

    public static void saveMatiere(Matiere matiere) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.save(matiere);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static List<Matiere> getAllMatiere() {
        List<Matiere> matiereList = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Matiere> query = session.createQuery("FROM Matiere",
                    Matiere.class);
            matiereList = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return matiereList;
    }

    public static Matiere findMatiereByName(String name) {
        Matiere matiere = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Option 1: HQL with named parameters (recommended)
            Query query = session.createQuery("FROM Matiere m WHERE m.name = :name");
            query.setParameter("name", name);
            matiere = (Matiere) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(); // Replace with proper logging
        }
        return matiere;
    }



    public static void deleteMatiere(long requestId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("DELETE FROM Matiere WHERE id = :id");
            query.setParameter("id", requestId);
            int result = query.executeUpdate(); // Execute the deletion

            if (result > 0) {
                System.out.println("matiere deleted successfully");
            } else {
                System.out.println("No matiere found with the given ID");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateMatiere(Matiere matiere) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(matiere);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }


    public static Matiere findMatiereById(long requestId) {
        Matiere matiere = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            matiere = session.get(Matiere.class, requestId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return matiere;
    }

}
