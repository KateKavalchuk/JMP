package by.epam.kavalchuk.stackoverflow.model;

import static by.epam.kavalchuk.util.Constatns.*;

public class Doctor {
	private String name;
	private String surname;
	private String position;
	private Patient patient;

	public Doctor() {
		patient = new Patient();
	}

	public Doctor(String name, String surname, String position) {
		super();
		this.name = name;
		this.surname = surname;
		this.position = position;
		this.patient = new Patient(DEFAULT_NAME, DEFAULT_SURNAME,
				DEFAULT_DIAGNOSIS);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "name " + this.name + " surname " + this.surname + " position "
				+ this.position;
	}
}
