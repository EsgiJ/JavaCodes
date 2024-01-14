package oguzhanesgiyusufo_lab3;

import java.util.LinkedList;

public class Patient implements IMedicalPersonnel{
	private String name;
	private LinkedList<Treatment> treatments;
	
	public Patient(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", treatments=" + treatments + "]";
	}
	
	public LinkedList<Treatment> getTreatments() {
		return treatments;
	}
	public String getName() {
		return name;
	}
	
}
