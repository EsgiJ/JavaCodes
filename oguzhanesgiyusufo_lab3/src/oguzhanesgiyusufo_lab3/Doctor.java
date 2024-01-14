package oguzhanesgiyusufo_lab3;

import java.util.ArrayList;
import java.util.List;

public class Doctor implements IMedicalPersonnel, ISurgeon{
	private static ArrayList<Doctor> doctorList;
	private String name;
	private double experience;
	private int surgeries;
	
	public Doctor(String name) {
		this.name = name;
		doctorList = new ArrayList<Doctor>();
	}

	public static List<Doctor> getDoctorList() {
		doctorList = new ArrayList<Doctor>();
		return doctorList;
	}
	double surgerySuccessRate = 0.80;
	double surgerySuccessChance = Math.random();
	public void performSurgery() throws SurgeryUnsuccessfulException {
		 if (surgerySuccessChance < surgerySuccessRate) {
			 throw new SurgeryUnsuccessfulException("Surgery by" + getName() + " was unsuccessful");
		 }
		 else {
			experience+= 2.5;
		}
	}
	public int getSurgeries() {
		return surgeries;
	}

	public void setSurgeries(int surgeries) {
		this.surgeries = surgeries;
	}

	@Override
	public String toString() {
		return "Doctor [name=" + name + ", experience=" + experience + ", surgeries=" + surgeries + "]";
	}
	 public String getName() {
		 return this.name;
	 }
}
