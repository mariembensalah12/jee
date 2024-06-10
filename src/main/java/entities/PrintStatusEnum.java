package entities;

public enum PrintStatusEnum {
	UNTREATED("Non traité"),
	DONE("Terminé"),
	DELIVRED("Livré");
	
	String status;
	
	private PrintStatusEnum(String status) {
		this.status = status;
	}
}
