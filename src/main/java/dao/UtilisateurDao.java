package dao;

import java.util.ArrayList;
import java.util.List;

import entities.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class UtilisateurDao {

    public static UtilisateurDao instance;

    private UtilisateurDao() {

    }

    public static UtilisateurDao getInstance() {
        if (null == instance) {
            instance = new UtilisateurDao();
        }
        return instance;

    }

    public static void saveUtilisateur(Utilisateur utilisateur) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // save the utilisateur in database
            session.save(utilisateur);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static Utilisateur findUtilisateur(String name, String pwd, String role) {
        Utilisateur utilisateur = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Option 1: HQL with named parameters (recommended)
            Query query = session.createQuery("FROM Utilisateur u WHERE u.name = :name AND u.pwd = :pwd AND u.role = :role");
            query.setParameter("name", name);
            query.setParameter("pwd", pwd);
            query.setParameter("role", role);
            utilisateur = (Utilisateur) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(); // Replace with proper logging
        }
        return utilisateur;
    }

    // Separate method for password validation (replace with your actual logic)
    private static boolean validatePassword(Utilisateur utilisateur, String password) {
        // Replace with your logic to check hashed password in the database
        // This is a placeholder for illustration
        return utilisateur.getPwd().equals(password);
    }

    public static List<Utilisateur> getUtilisateur() {
        List<Utilisateur> utilisateurList = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Utilisateur> query = session.createQuery("FROM Utilisateur",
                    Utilisateur.class);
            utilisateurList = query.list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return utilisateurList;
    }

    public static void deleteUtilisateur(long requestId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("DELETE FROM Utilisateur WHERE id = :id");
            query.setParameter("id", requestId);
            int result = query.executeUpdate(); // Execute the deletion

            if (result > 0) {
                System.out.println("user deleted successfully");
            } else {
                System.out.println("No user found with the given ID");
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void updateUtilisateur(Utilisateur utilisateur) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.update(utilisateur);
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            }
        }
    }


    public static Utilisateur findUtilisateurById(long requestId) {
        Utilisateur utilisateur = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            utilisateur = session.get(Utilisateur.class, requestId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
    }
}

