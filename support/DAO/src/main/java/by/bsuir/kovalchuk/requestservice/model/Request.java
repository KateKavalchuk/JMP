package by.bsuir.kovalchuk.requestservice.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

@Entity
@Table(name = "request")
@JsonIgnoreType
public class Request implements Serializable {

	private static final long serialVersionUID = 969651916610876614L;

	@Id
	@Column(name = "idRequest", nullable = false)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private Timestamp date;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "request", cascade = CascadeType.ALL)
	private Set<AttachedFile> attachedFiles = new LinkedHashSet<AttachedFile>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "request", cascade = CascadeType.ALL)
	private Set<Comment> comments = new LinkedHashSet<Comment>();

	@ManyToOne
	@JoinColumn(name = "idEmployee")
	public Employee employee;

	@ManyToOne
	@JoinColumn(name = "idPriority", nullable = false)
	public Priority priority;

	@ManyToOne
	@JoinColumn(name = "idStatus", nullable = false)
	public Status status;

	@ManyToOne
	@JoinColumn(name = "idTopic", nullable = false)
	public Topic topic;

	@ManyToOne
	@JoinColumn(name = "idDepartment", nullable = false)
	public Department department;

	public Request() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Set<AttachedFile> getAttachedFiles() {
		return attachedFiles;
	}

	public void setAttachedFiles(Set<AttachedFile> attachedFiles) {
		this.attachedFiles = attachedFiles;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
