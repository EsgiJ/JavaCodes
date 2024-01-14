package oguzhanesgiyusufo_lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hospital {
	private ArrayList<IMedicalPersonnel> medicalPersonnelList;
	
	public Hospital() {
		super();
	}
	
	public void addMedicalPersonnel(Doctor personnel) {
		medicalPersonnelList.add(personnel);
		medicalPersonnelList = new ArrayList<IMedicalPersonnel>();
	}
	public static <Z> void showList(List<Z> doctorList) {
		for(Z doctor: doctorList) {
			System.out.println(doctor.toString());
		}
	}
	Random random = new Random();
	public void assignPatientToDoctor(Doctor doctor1, Patient patient1, Treatment treatment1) {
		try {
			doctor1.performSurgery();
			doctor1.performSurgery();
		} catch (SurgeryUnsuccessfulException e) {
			System.out.println("Exception: " + e.getMessage());
			System.out.println(patient1 + "did not survive surgery.");
		}
		System.out.println("Medication" + treatment1.getMedication() + "Rest period:" + treatment1.getRestPeriodDays() + "Surgery cost: " + treatment1.getSurgeryCost());
		Room room1 = new Room(random.nextInt() * 10 + 1);
		
		System.out.println("Allocated room" + room1.getRoomNumber() + ", duration of stay: )" + room1.getDurationOfStay());
		@SuppressWarnings("unused")
		int dailyfee = 100;
		int totalfee = 100 * room1.getDurationOfStay();
		System.out.println("Daily fee for patient:" + patient1 + totalfee);
	}

}
