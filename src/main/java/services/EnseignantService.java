package services;

import java.util.List;

import dao.EnseignantDao;
import entities.PrintDocumentRequest;

public class EnseignantService {
	public static EnseignantService instance;

	private EnseignantService() {

	}

	public void savePrintRequest(PrintDocumentRequest printDocumentRequest) {
		EnseignantDao.savePrintRequest(printDocumentRequest);
	}

	public static EnseignantService getInstance() {
		if (null == instance) {
			instance = new EnseignantService();
		}
		return instance;
	}

	public List<PrintDocumentRequest> findAllPrintRequests() {
		return EnseignantDao.getPrintRequest();
	}

	public void deletePrintRequest(long requestId) {
		EnseignantDao.deletePrintRequest(requestId);
	}
	
	
	public PrintDocumentRequest findPrintRequestById(Long id) {
        return EnseignantDao.findPrintRequestById(id);
    }
	public void updatePrintRequest(PrintDocumentRequest printDocumentRequest) {
	    EnseignantDao.updatePrintRequest(printDocumentRequest);
	}

}
