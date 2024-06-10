package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import entities.PrintDocumentRequest;
import util.HibernateUtil;

public class EnseignantDao {

	public static EnseignantDao instance;

	private EnseignantDao() {

	}

	public static EnseignantDao getInstance() {
		if (null == instance) {
			instance = new EnseignantDao();
		}
		return instance;

	}

	public static void savePrintRequest(PrintDocumentRequest printDocumentRequest) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// save the printDocumentRequest in database
			session.save(printDocumentRequest);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static List<PrintDocumentRequest> getPrintRequest() {
		List<PrintDocumentRequest> printDocumentRequestList = new ArrayList();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			Query<PrintDocumentRequest> query = session.createQuery("FROM PrintDocumentRequest",
					PrintDocumentRequest.class);
			printDocumentRequestList = query.list();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return printDocumentRequestList;
	}

	public static void deletePrintRequest(long requestId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		  try {
			  Query query = session.createQuery("DELETE FROM PrintDocumentRequest WHERE id = :id");
			    query.setParameter("id", requestId);
			    int result = query.executeUpdate(); // Execute the deletion
			    
			    if (result > 0) {
			      System.out.println("Item deleted successfully");
			    } else {
			      System.out.println("No item found with the given ID");
			    }
			  transaction.commit();
		  } catch (Exception e) {
			transaction.rollback();
		    e.printStackTrace();
		  } finally {
		    session.close();
		  }
	}

	public static PrintDocumentRequest findPrintRequestById(long requestId) {
	    PrintDocumentRequest printDocumentRequest = null;
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        printDocumentRequest = session.get(PrintDocumentRequest.class, requestId);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return printDocumentRequest;
	}

	public static void updatePrintRequest(PrintDocumentRequest printDocumentRequest) {
	    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	        Transaction transaction = session.beginTransaction();
	        try {
	            session.update(printDocumentRequest);
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	    }
	}


}
