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

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@Table(name = "priority")
@JsonIgnoreType
public class Priority implements Serializable {

	private static final long serialVersionUID = -961479458157888723L;

	@Id
	@Column(name = "idPriority", nullable = false)
	private int id;

	@Column(name = "priority", nullable = false)
	private String priority;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "priority", cascade = CascadeType.ALL)
	private Set<Request> requests = new LinkedHashSet<Request>();

	public Priority() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setRequests(Set<Request> requests) {
		this.requests = requests;
	}

}
