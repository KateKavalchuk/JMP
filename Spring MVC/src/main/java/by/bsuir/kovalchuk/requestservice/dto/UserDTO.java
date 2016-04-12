package by.bsuir.kovalchuk.requestservice.dto;

public class UserDTO {
	private int id;
	private String email;
	private String password;
	private String role;
	private String firstName;
	private String lastName;
	private String contanctNumber;
	private String photo;
	private int idDepartment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String login) {
		this.email = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContanctNumber() {
		return contanctNumber;
	}

	public void setContanctNumber(String contanctNumber) {
		this.contanctNumber = contanctNumber;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(int department) {
		this.idDepartment = department;
	}

}
