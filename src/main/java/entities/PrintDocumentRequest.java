package entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table
public class PrintDocumentRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "groupe")
	private String groupe;

	@Column(name = "subject")
	private String subject;

	@Column(name = "document_path")
	private String documentPath;

	@Column(name = "date")
	private LocalDateTime date;
	
	@Column(name = "print_status")
	@Enumerated(EnumType.STRING)
	private PrintStatusEnum printStatus;

	public PrintStatusEnum getPrintStatus() {
		return printStatus;
	}

	public void setPrintStatus(PrintStatusEnum printStatus) {
		this.printStatus = printStatus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getGroupe() {
		return groupe;
	}

	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime dateTime) {
		this.date = dateTime;
	}
	
}
