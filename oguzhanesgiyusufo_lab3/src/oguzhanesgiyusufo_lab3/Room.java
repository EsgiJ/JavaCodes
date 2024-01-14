package oguzhanesgiyusufo_lab3;

import java.util.ArrayList;

public class Room {
	private static int nextRoomNumber = 1;
	private int roomNumber;
	private int durationOfStay;
	private ArrayList<Treatment> treatments;
	public Room(int durationOfStay) {
		super();
		this.durationOfStay = durationOfStay;
		roomNumber = nextRoomNumber;
		nextRoomNumber++;
		treatments = new ArrayList<Treatment>();
	}
	@Override
	public String toString() {
		return "Room [roomNumber=" + roomNumber + ", durationOfStay=" + durationOfStay + ", treatments=" + treatments
				+ "]";
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void addTreatments(Treatment treatment) {
		treatments.add(treatment);
	}
	public int getDurationOfStay() {
		return durationOfStay;
	}
	
}
