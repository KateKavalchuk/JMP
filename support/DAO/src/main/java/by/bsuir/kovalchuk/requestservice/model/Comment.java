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
@Table(name = "comment")
@JsonIgnoreType
public class Comment implements Serializable {
	private static final long serialVersionUID = 44870628796932692L;

	@Id
	@Column(name = "idComment", nullable = false)
	public int id;

	@Column(name = "comment", nullable = false)
	public String comment;

	@Column(name = "date")
	public Timestamp date;

	@ManyToOne
	@JoinColumn(name = "idRequest", nullable = false)
	public Request request;

	public Comment() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
