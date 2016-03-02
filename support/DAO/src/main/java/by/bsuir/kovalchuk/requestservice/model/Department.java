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
@Table(name = "department")
@JsonIgnoreType
public class Department implements Serializable {

	private static final long serialVersionUID = 6447690972358842241L;

	@Id
	@Column(name = "idDepartment", nullable = false)
	private int id;

	@Column(name = "departmentName", nullable = false)
	private String departmentName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Employee> employees = new LinkedHashSet<>();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "department", cascade = CascadeType.ALL)
	private Set<Request> requests = new LinkedHashSet<>();

	public Department() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Request> getRequests() {
		return requests;
	}

	public void setEmployees(Set<Request> requests) {
		this.requests = requests;
	}

}
