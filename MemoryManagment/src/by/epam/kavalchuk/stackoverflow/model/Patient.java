package by.epam.kavalchuk.stackoverflow.model;

import static by.epam.kavalchuk.util.Constatns.*;

public class Patient {
	private String name;
	private String surname;
	private String diagnosis;
	private Doctor doctor;

	public Patient() {
	}

	public Patient(String name, String surname, String diagnosis) {
		super();
		this.name = name;
		this.surname = surname;
		this.diagnosis = diagnosis;
		this.doctor = new Doctor(DEFAULT_NAME, DEFAULT_SURNAME,
				DEFAULT_POSITION);
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

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "name " + this.name + " surname " + this.surname + " diagnosis "
				+ this.diagnosis;
	}
}
