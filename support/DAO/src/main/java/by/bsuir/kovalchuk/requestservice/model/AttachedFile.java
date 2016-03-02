package by.bsuir.kovalchuk.requestservice.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@Table(name = "attachedfile")
@JsonIgnoreType
public class AttachedFile implements Serializable {

	private static final long serialVersionUID = 4219434549370475102L;

	@Id
	@Column(name = "idFile", nullable = false)
	private int id;

	@Column(name = "fileName", nullable = false)
	private String fileName;

	@Column(name = "date")
	private Timestamp date;

	@ManyToOne
	@JoinColumn(name = "idRequest", nullable = false)
	public Request request;

	public AttachedFile() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
}
