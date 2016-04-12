package by.bsuir.kovalchuk.requestservice.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status implements Serializable {

	private static final long serialVersionUID = -6582979104980170125L;

	@Id
	@Column(name = "idStatus", nullable = false)
	private int id;

	@Column(name = "status")
	private String status;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "status", cascade = CascadeType.ALL)
	private Set<Request> requests = new LinkedHashSet<Request>();

	public Status() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

}
